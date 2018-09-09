package com.sushanth.restws.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


public class Tacos {

	private Double price;
	private String item;
	private Integer quantity;

	public Tacos(Double price, String item, Integer quantity) {
		super();
		this.price = price;
		this.item = item;
		this.quantity = quantity;
	}
	public Tacos(){
		
	}
	// price,name,quantity of each taco
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Tacos [price=" + price + ", item=" + item + ", quantity=" + quantity + "]";
	}	
	@Override
	public boolean equals(Object o){
		return this.toString().equalsIgnoreCase(o.toString());
	}
}
