package com.oaec.collection.map;

import java.util.HashMap;
import java.util.Map;

public class ItemsMap {

	private long id;
	private String name;
	private Map<String, String> images = new HashMap<>();
	public ItemsMap() {
		super();
	}
	
	
	public ItemsMap(long id, String name, Map<String, String> images) {
		super();
		this.id = id;
		this.name = name;
		this.images = images;
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


	public Map<String, String> getImages() {
		return images;
	}


	public void setImages(Map<String, String> images) {
		this.images = images;
	}


	@Override
	public String toString() {
		return "ItemsMap [id=" + id + ", name=" + name + ", images=" + images + "]";
	}
	
	
}
