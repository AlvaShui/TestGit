package com.oaec.collection.bag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ItemsBag implements Serializable{
	private long id;
	private String name;
	private List<String> bags = new ArrayList<>();
	
	public ItemsBag() {super();}

	public ItemsBag(long id, String name, List<String> bags) {
		super();
		this.id = id;
		this.name = name;
		this.bags = bags;
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

	public List<String> getBags() {
		return bags;
	}

	public void setBags(List<String> bags) {
		this.bags = bags;
	}

	@Override
	public String toString() {
		/*for (String string : bags) {
			System.out.println(string);
		}*/
		return "ItemsBag [id=" + id + ", name=" + name + ", bags=" + bags + "]";
	}
	
	
}	
