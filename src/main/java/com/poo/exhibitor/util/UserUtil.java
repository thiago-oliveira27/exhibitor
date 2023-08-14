package com.poo.exhibitor.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.poo.exhibitor.model.UserModel;

public class UserUtil {
	
	public static String md5(String password) throws NoSuchAlgorithmException{
		
		MessageDigest messageDig = MessageDigest.getInstance("MD5");
		BigInteger hash = new BigInteger(1, messageDig.digest(password.getBytes()));
		return hash.toString();
	}
	
	public static ModelAndView isUserLogged(HttpSession session, ModelAndView mv) {		
		mv.addObject("user", new UserModel());			
		if(session.getAttribute("userId") == null) {
			mv.setViewName("/login");
	        return mv;
		}
		return null; 		
	}


}
