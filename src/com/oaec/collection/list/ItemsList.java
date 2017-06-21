package com.oaec.collection.list;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ItemsList implements Serializable{

	private long id;
	private String name;
	private List<String> imagesList = new ArrayList<String>();
	
	public ItemsList() {
		super();
	}

	public ItemsList(long id, String name, List<String> imagesList) {
		super();
		this.id = id;
		this.name = name;
		this.imagesList = imagesList;
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

	public List<String> getImagesList() {
		return imagesList;
	}

	public void setImagesList(List<String> imagesList) {
		this.imagesList = imagesList;
	}

	@Override
	public String toString() {
		return "ItemsList [id=" + id + ", name=" + name + ", imagesList=" + imagesList + "]";
	}
	
	
}
