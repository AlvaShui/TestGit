package com.oaec.component.pojo;

public class Address {

	private String province;
	private String city;
	private String street;
	private Customer customer;
	
	public Address(){}
	
	public Address(String province, String city, String street, Customer customer) {
		super();
		this.province = province;
		this.city = city;
		this.street = street;
		this.customer = customer;
	}
	
//这里新增了一个构造方法
	public Address(String province, String city, String street) {
		super();
		this.province = province;
		this.city = city;
		this.street = street;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Address [province=" + province + ", city=" + city + ", street=" + street + "]";
	}
	
	
	
}
