package com.example.restService;

import java.util.Date;

public class Offer {
		
		private final String company;
		private final int teamSize;
		private final float price;
		private final String contact;
		private final String mail;
		private final Date validityDate;
		private final Date registrationDate;
		private final String service;

		public Offer(String company, int teamSize, float price, String contact, String mail, Date validityDate, Date registrationDate, String service) {
			this.company = company;
			this.teamSize = teamSize;
			this.price = price;
			this.contact = contact;
			this.mail = mail;
			this.validityDate = validityDate;
			this.registrationDate = registrationDate;
			this.service = service;	
		}

		public String getCompany() {
			return company;
		}

		public int getTeamSize() {
			return teamSize;
		}

		public float getPrice() {
			return price;
		}

		public String getContact() {
			return contact;
		}

		public String getMail() {
			return mail;
		}

		public Date getValidityDate() {
			return validityDate;
		}

		public Date getRegistrationDate() {
			return registrationDate;
		}

		public String getService() {
			return service;
		}

}