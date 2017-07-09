package com.nextgen.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nextgen.model.Employee;
import com.nextgen.model.SpringSecurityUser;
import com.nextgen.service.AppUserService;
import com.nextgen.utils.EncryptionUtility;

@Service(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	private static final Logger LOGGER = Logger.getLogger(UserDetailsServiceImpl.class);
	
	@Autowired
	private AppUserService appUserService;
	@Autowired
	private MessageSource source;

	/**
	 * This method to load the user based on username
	 * 
	 * @date Aug 8, 2016
	 * @param username
	 *            username to fetch the contact object form the database
	 * @return Userdetails object Userdetails object
	 */
	public UserDetails loadUserByUsername(final String username) {
		final Employee appUser = this.appUserService.loadUserByUsername(username);
		if (appUser == null) {
			LOGGER.error("App user is null...");
			throw new UsernameNotFoundException(
					source.getMessage("no.user.found.message", new Object[] { username }, null));
		} else {
			try {
				return new SpringSecurityUser(appUser.getId(), appUser.getUsername(), EncryptionUtility.decrypt(appUser.getPassword()),
						// /*decrypting the password */
						null, null, AuthorityUtils.commaSeparatedStringToAuthorityList(appUser.getAuthorities()));
			} catch (Exception e) {
				LOGGER.error("Exception in getting user by username : ", e);
			}
		}
		return null;
	}
}