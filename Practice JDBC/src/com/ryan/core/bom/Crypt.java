package com.ryan.core.bom;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Crypt {
	
	public static String md5(String string) {		
		try {
			return hexToString(stringToBytes(string)).toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}		
	}

	/**
	 * Converts hex to String format
	 * @param byteData
	 * @return
	 */
	private static StringBuffer hexToString(byte[] byteData) {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb;
	}

	/**
	 * Converts a String to bytes[]
	 * @param string
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	private static byte[] stringToBytes(String string) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(string.getBytes());
		
		byte byteData[] = md.digest();
		return byteData;
	}
}
