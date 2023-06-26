package com.poo.exhibitor.connection.facade;

import com.poo.exhibitor.builder.MessageData;
import com.poo.exhibitor.factory.WhatsAppURLFactory;
import com.poo.exhibitor.service.ProductService;

public class DataAcessTest {

	public static void main(String[] args) {
		
	ProductService productService = new ProductService();
	
	MessageData msgData = productService.getMessageData(Long.valueOf(179));	
	WhatsAppURLFactory wppLink = new WhatsAppURLFactory();
	String link = wppLink.generateWhatsAppURL(msgData.getPhoneNumber(), msgData.getUsername(), msgData.getAdName());

	System.out.println(link);
	}
}
