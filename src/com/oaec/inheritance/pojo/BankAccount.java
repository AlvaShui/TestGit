package com.oaec.inheritance.pojo;

public class BankAccount extends BillingDetails {
	private String bankName;
	private String bankSwift;//ÒøÐÐµÄ¼ò³Æ
	public BankAccount() {
		super();
	}
	public BankAccount(String bankName, String bankSwift) {
		super();
		this.bankName = bankName;
		this.bankSwift = bankSwift;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankSwift() {
		return bankSwift;
	}
	public void setBankSwift(String bankSwift) {
		this.bankSwift = bankSwift;
	}
	@Override
	public String toString() {
		return "BankAccount [bankName=" + bankName + ", bankSwift=" + bankSwift + "]";
	}
	
	
}
