package com.oaec.association.many2many.pojo;

import java.util.HashSet;
import java.util.Set;

public class Technology {
	private long id;
	private String name;
	private String category;
	private Set<Engineer> engis = new HashSet<>();
	public Technology() {
	}
	public Technology(long id, String name, String category, Set<Engineer> engis) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.engis = engis;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Set<Engineer> getEngis() {
		return engis;
	}
	public void setEngis(Set<Engineer> engis) {
		this.engis = engis;
	}
	@Override
	public String toString() {
		return "Technology [id=" + id + ", name=" + name + ", category=" + category + "]";
	}
	
	
}
