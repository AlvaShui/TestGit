package com.oaec.association.one2many.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Order {

	private long id;
	private Date ordered_date;
	private Date shipped_date;
	private double total;
	private Set<OrderLine> orderlines = new HashSet<>();
	
	public Order(){}


	public Order(long id, Date ordered_date, Date shipped_date, double total, Set<OrderLine> orderlines) {
		super();
		this.id = id;
		this.ordered_date = ordered_date;
		this.shipped_date = shipped_date;
		this.total = total;
		this.setOrderlines(orderlines);
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getOrdered_date() {
		return ordered_date;
	}

	public void setOrdered_date(Date ordered_date) {
		this.ordered_date = ordered_date;
	}

	public Date getShipped_date() {
		return shipped_date;
	}

	public void setShipped_date(Date shipped_date) {
		this.shipped_date = shipped_date;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}


	public Set<OrderLine> getOrderlines() {
		return orderlines;
	}


	public void setOrderlines(Set<OrderLine> orderlines) {
		this.orderlines = orderlines;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", ordered_date=" + ordered_date + ", shipped_date=" + shipped_date + ", total=" + total
				+ ", orderlines=" + orderlines + "]";
	}
	
	
}
