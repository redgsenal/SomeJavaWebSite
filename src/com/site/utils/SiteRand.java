package com.site.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SiteRand {

	/**
	 * Generate random string
	 * @param len - length of the string
	 * @return a random string of length len; must be > 5 but < 128, default to 32
	 * @throws NoSuchAlgorithmException
	 */
	public static String generateRandomString(int len) throws NoSuchAlgorithmException{
		if (len < 5 || len > 128)
			len = 32;
		
		char[] VALID_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456879".toCharArray();
		SecureRandom rd = SecureRandom.getInstance("SHA1PRNG");
		StringBuffer sb = new StringBuffer();
		while(sb.length() < 20){
			sb.append(VALID_CHARACTERS[rd.nextInt(VALID_CHARACTERS.length)]);
		}
		return sb.toString();
	}
}
