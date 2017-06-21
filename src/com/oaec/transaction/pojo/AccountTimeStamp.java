package com.oaec.transaction.pojo;

import java.sql.Timestamp;

public class AccountTimeStamp {
	private Long id;
	private Timestamp timeStamp;
	private Long code;
	private String name;
	private float balance;
	public AccountTimeStamp() {
		super();
	}
	public AccountTimeStamp(Long id, Timestamp timeStamp, Long code, String name, float balance) {
		super();
		this.id = id;
		this.timeStamp = timeStamp;
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
	
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
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
		return "AccountVersion [id=" + id + ", timeStamp=" + timeStamp + ", code=" + code + ", name=" + name + ", balance="
				+ balance + "]";
	}
	
	
}
