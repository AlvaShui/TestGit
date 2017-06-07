package com.oaec.inheritance.pojo;

import java.util.Date;

/**
 * @author Administrator
 *订单详情类，父类
 */
public abstract class BillingDetails {
	private long id;
	private String owner;
	private String code;
	private Date created;
	public BillingDetails() {
	}
	public BillingDetails(long id, String onwer, String code, Date created) {
		this.id = id;
		this.owner = owner;
		this.code = code;
		this.created = created;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	@Override
	public String toString() {
		return "BillingDetails [id=" + id + ", owner=" + owner + ", code=" + code + ", created=" + created + "]";
	}
	
	
}
