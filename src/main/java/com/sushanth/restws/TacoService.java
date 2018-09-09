package com.sushanth.restws;

import java.util.List;

import com.sushanth.restws.model.OrderTotal;
import com.sushanth.restws.model.Tacos;


public interface TacoService {

	
	public List<Tacos> getTacos();

	
	public OrderTotal createOrder(List<Tacos> tacoOrder);

}
