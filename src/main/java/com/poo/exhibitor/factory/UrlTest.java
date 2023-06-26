package com.poo.exhibitor.factory;

public class UrlTest {

	public static void main(String[] args) {

		WhatsAppURLFactory wpp = new WhatsAppURLFactory();
		String formattedMessage = wpp.generateWhatsAppURL("1792616226", "Thigas", "Corolla 2012");
		System.out.println(formattedMessage);
	}

}
