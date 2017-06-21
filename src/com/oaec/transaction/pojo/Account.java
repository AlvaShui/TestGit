package com.oaec.transaction.pojo;

public class Account {

	private Long id;
	private Long code;
	private String name;
	private float balance;
	public Account() {
		super();
	}
	public Account(Long id, Long code, String name, float balance) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.balance = balance;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", code=" + code + ", name=" + name + ", balance=" + balance + "]";
	}
	
	
}
