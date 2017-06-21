package com.oaec.collection.set;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ItemsSet implements Serializable{

	private long id;
	private String name;
	private Set<String> imagesSet = new HashSet<>();
	
	public ItemsSet() {
		super();
	}
	
	public ItemsSet(long id, String name, Set<String> imagesSet) {
		super();
		this.id = id;
		this.name = name;
		this.imagesSet = imagesSet;
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


	public Set<String> getImagesSet() {
		return imagesSet;
	}

	public void setImagesSet(Set<String> imagesSet) {
		this.imagesSet = imagesSet;
	}


	@Override
	public String toString() {
		return "ItemsSet [id=" + id + ", name=" + name + ", imagesSet=" + imagesSet.toString() + "]";
	}
	
	
}
