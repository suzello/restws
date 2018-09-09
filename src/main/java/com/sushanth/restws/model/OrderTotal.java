package com.sushanth.restws.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "OrderTotal")
public class OrderTotal {

	private String orderTotal = "%s $";

	public void setOrderTotal(Double Total) {
		orderTotal = (String.format(orderTotal, Total));
	}
	
	public String getOrderTotal() {
		return orderTotal;
	}

}
