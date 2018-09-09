package com.sushanth.restws.model;

public class OrderTotal {

	private String orderTotal = "%s $";
	private String totalOrder = null;

	
	public OrderTotal(String totalOrder) {
		super();
		this.totalOrder = totalOrder;
	}
	public OrderTotal(){
		
	}

	public String getTotalOrder() {
		return totalOrder;
	}
	public void setTotalOrder(Double totalOrder) {
		this.totalOrder =((String.format(orderTotal, totalOrder)));
	}

}
