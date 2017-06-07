package com.oaec.inheritance.pojo;

public class CreditCard extends BillingDetails {

	private String credit_card_type;
	private String expired_month;
	private String expired_year;
	public CreditCard() {
		super();
	}
	public CreditCard(String credit_card_type, String expired_month, String expired_year) {
		super();
		this.credit_card_type = credit_card_type;
		this.expired_month = expired_month;
		this.expired_year = expired_year;
	}
	public String getCredit_card_type() {
		return credit_card_type;
	}
	public void setCredit_card_type(String credit_card_type) {
		this.credit_card_type = credit_card_type;
	}
	public String getExpired_month() {
		return expired_month;
	}
	public void setExpired_month(String expired_month) {
		this.expired_month = expired_month;
	}
	public String getExpired_year() {
		return expired_year;
	}
	public void setExpired_year(String expired_year) {
		this.expired_year = expired_year;
	}
	@Override
	public String toString() {
		return "CreditCard [credit_card_type=" + credit_card_type + ", expired_month=" + expired_month
				+ ", expired_year=" + expired_year + "]";
	}
	
	
}
