package com.poo.exhibitor.factory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class WhatsAppURLFactory implements UrlMethods{

	private String MAIN_URL = "https://api.whatsapp.com/send?phone=";
	private String TXT_URL = "&text=";
	
	private String TXT_MESSAGE_1 = "Hi, ";
	private String TXT_MESSAGE_2 = ". Im interested in the ad \"";
	private String TXT_MESSAGE_3 = "\"!";
	
	//"https://api.whatsapp.com/send?phone=" + formattedPhoneNumber + "&text=" + encodedDynamicMessage
	
	@Override
	public String generateWhatsAppURL(String phoneNumber, String username, String adName) {
		
		String formattedNumber = formatPhoneNumber(phoneNumber);
		String formattedMessage = encodeDynamicMessage(username, adName);
		
		return this.MAIN_URL.concat(formattedNumber).concat(TXT_URL).concat(formattedMessage);
	}

	@Override
	public String formatPhoneNumber(String phoneNumber) {		
		return phoneNumber.replace(" ","");
	}

	@Override
	public String encodeDynamicMessage(String username, String adName) {
		
		String COMPLETE_MESSAGE = TXT_MESSAGE_1.concat(username).concat(TXT_MESSAGE_2).concat(adName).concat(TXT_MESSAGE_3);		
		try {	         
	        return URLEncoder.encode(COMPLETE_MESSAGE, "UTF-8");
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }
	    
	    return COMPLETE_MESSAGE;
	}
	
	

}
