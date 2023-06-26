package com.poo.exhibitor.builder;

public class MessageData {

	private String phoneNumber;
	private String username;
	private String adName;

	private MessageData(Builder builder) {

		this.phoneNumber = builder.phoneNumber;
		this.username = builder.username;
		this.adName = builder.adName;

	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public String getAdName() {
		return adName;
	}

	public static class Builder {

		private String phoneNumber;
		private String username;
		private String adName;

		public Builder setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public Builder setUsername(String username) {
			this.username = username;
			return this;
		}

		public Builder setAdName(String adName) {
			this.adName = adName;
			return this;
		}

		public MessageData build() {
			return new MessageData(this);
		}

	}
}
