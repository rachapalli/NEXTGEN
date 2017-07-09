package com.nextgen.utils;

import java.security.Key;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

import com.nextgen.enums.BaseAppConstants;

/**
 * this is a utility class. it is used to Encryption and decryption of String.
 * 
 * @author umamaheswarar 
 * @version ArtigemRS-FI July 13, 2016
 */
public class EncryptionUtility {
	
	private static final String ALGORITHM = BaseAppConstants.AES.getValue();
	private static final String KEY = BaseAppConstants.KEY.getValue();
	private static final Logger LOGGER = Logger.getLogger(EncryptionUtility.class);

	/**
	 * this method is use to perform the encoding on passed the string
	 * 
	 * @param base
	 *            String type
	 * @return String
	 */
	public static String encriptData(String base) {
		String ercriptData = null;
		try {
			MessageDigest digest = MessageDigest.getInstance(BaseAppConstants.SHA_256.getValue());
			byte[] hash = digest.digest(base.getBytes(BaseAppConstants.UTF_8.getValue()));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append(BaseAppConstants.ZERO_CHARACTER.getValue());
				hexString.append(hex);
			}
			ercriptData = hexString.toString();
		} catch (Exception e) {
			LOGGER.error("Exception occured while encripting the string ", e);
		}
		return ercriptData;
	}

	/**
	 * this method is use to perform the encoding on passed the string
	 * 
	 * @param base
	 *            String type
	 * @return String
	 */
	public static String encrypt(String value) {
		String encryptedValue64 = null;
		try {
			Key key = generateKey();
			Cipher cipher = Cipher.getInstance(EncryptionUtility.ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			if (null != value) {
				byte[] encryptedByteValue = cipher.doFinal(value.getBytes(BaseAppConstants.UTF_8.getValue()));
				encryptedValue64 = new sun.misc.BASE64Encoder().encode(encryptedByteValue);
			}
		} catch (Exception e) {
			LOGGER.error("Exception occured while encripting the string ", e);
		}
		return encryptedValue64;

	}

	/**
	 * this method is use to perform the decoding on passed the string
	 * 
	 * @param base
	 *            String type
	 * @return String
	 */
	public static String decrypt(String value) throws Exception {
		String decryptedValue = null;
		try {
			Key key = generateKey();
			Cipher cipher = Cipher.getInstance(EncryptionUtility.ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, key);
			if (null != value) {
			byte[] decryptedValue64 = new sun.misc.BASE64Decoder().decodeBuffer(value);
			byte[] decryptedByteValue = cipher.doFinal(decryptedValue64);
			decryptedValue = new String(decryptedByteValue, BaseAppConstants.UTF_8.getValue());
			}
		} catch (Exception e) {
			LOGGER.error("Exception occured while decripting the string ", e);
		}
		return decryptedValue;

	}

	/**
	 * this method is use generate key
	 * 
	 * @return Key
	 */
	private static Key generateKey() throws Exception {
		LOGGER.info("Start generateKey method");
		Key key = new SecretKeySpec(EncryptionUtility.KEY.getBytes(), EncryptionUtility.ALGORITHM);
		LOGGER.info("End generateKey method");
		return key;
	}
}