package com.oaec.association.one2one.pojo;


public class Passport{

	private long id;
	private String bh;
	private Person person;
	
	public Passport() {
	}
	public Passport(long id, String bh, Person person) {
		this.id = id;
		this.bh = bh;
		this.person = person;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBh() {
		return bh;
	}
	public void setBh(String bh) {
		this.bh = bh;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "Passport [id=" + id + ", bh=" + bh + "]";
	}
	
	
	
}
