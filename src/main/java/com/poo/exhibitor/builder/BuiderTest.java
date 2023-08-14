package com.poo.exhibitor.builder;

public class BuiderTest {

	public static void main(String[] args) {

		MessageData md = new MessageData.Builder()
										.setPhoneNumber("99999999")
										.setAdName("AdNameTest")
										.setUsername("UserTest")
										.build();

		System.out.println(md.getAdName());
		System.out.println(md.getPhoneNumber());
		System.out.println(md.getUsername());
	}
}
