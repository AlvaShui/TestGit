package com.oaec.component.pojo;

public class Customer {

	private long id;
	private String name;
	private Address address;
	public Customer() {
		super();
	}
	public Customer(long id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	
}
