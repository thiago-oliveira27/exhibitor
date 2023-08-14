package com.poo.exhibitor.factory;

public interface UrlMethods {
	
	String generateWhatsAppURL(String phoneNumber, String username, String adName);
	String formatPhoneNumber(String phoneNumber);
	String encodeDynamicMessage(String username, String adName);

}
