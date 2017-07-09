package com.nextgen.component;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.nextgen.enums.BaseAppConstants;

@Component(value = "authenticationEntryPoint")
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {
	private static final Logger LOGGER = Logger.getLogger(EntryPointUnauthorizedHandler.class);
	@Autowired
	private MessageSource source;
	
	/**
	 * Commences an authentication scheme.
	 * <p>
	 * <code>ExceptionTranslationFilter</code> will populate the <code>HttpSession</code>
	 * attribute named
	 * <code>AbstractAuthenticationProcessingFilter.SPRING_SECURITY_SAVED_REQUEST_KEY</code>
	 * with the requested target URL before calling this method.
	 * <p>
	 * Implementations should modify the headers on the <code>ServletResponse</code> as
	 * necessary to commence the authentication process.
	 *
	 * @param httpServletRequest that resulted in an <code>AuthenticationException</code>
	 * @param httpServletResponse so that the user agent can begin authentication
	 * @param authException that caused the invocation
	 *
	 */
	@Override
	public void commence(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse,
			final AuthenticationException authException) throws IOException, ServletException {
		try {
			final JSONObject json = new JSONObject(source.getMessage("access.denied.message", null, null));
			httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			httpServletResponse.setContentType(BaseAppConstants.APPLICATION_JSON.getValue());
			json.write(httpServletResponse.getWriter());
		} catch (IOException | JSONException e) {
			LOGGER.error(e.getMessage());
		}
	}
}