package com.poo.exhibitor.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserUtil {
	
	public static String md5(String password) throws NoSuchAlgorithmException{
		
		MessageDigest messageDig = MessageDigest.getInstance("MD5");
		BigInteger hash = new BigInteger(1, messageDig.digest(password.getBytes()));
		return hash.toString();
	}

}
