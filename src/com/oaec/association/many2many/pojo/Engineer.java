package com.oaec.association.many2many.pojo;

import java.util.HashSet;
import java.util.Set;

public class Engineer {

	private long id;
	private String name;
	private String gender;
	private int age;
	private String company;
	private Set<Technology> techs = new HashSet<>();
	
	public Engineer(){}

	public Engineer(long id, String name, String gender, int age, String company, Set<Technology> techs) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.company = company;
		this.techs = techs;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Set<Technology> getTechs() {
		return techs;
	}

	public void setTechs(Set<Technology> techs) {
		this.techs = techs;
	}

	@Override
	public String toString() {
		return "Engineer [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", company=" + company
				+ ", techs=" + techs + "]";
	}
	
	
}
