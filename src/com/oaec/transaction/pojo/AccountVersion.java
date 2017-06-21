package com.oaec.transaction.pojo;

public class AccountVersion {
	private Long id;
	private Integer version;
	private Long code;
	private String name;
	private float balance;
	public AccountVersion() {
		super();
	}
	public AccountVersion(Long id, Integer version, Long code, String name, float balance) {
		super();
		this.id = id;
		this.version = version;
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
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
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
		return "AccountVersion [id=" + id + ", version=" + version + ", code=" + code + ", name=" + name + ", balance="
				+ balance + "]";
	}
	
	
}
