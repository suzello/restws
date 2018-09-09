package com.sushanth.restws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.sushanth.restws.model.OrderTotal;
import com.sushanth.restws.model.Tacos;

@Service
public class TacoServiceImpl implements TacoService {

	Map<Integer, Tacos> tacos = new HashMap<>();
	OrderTotal finalOrder = new OrderTotal();
	//prices can change
	static Double priceOne = 2.50;
	static Double priceTwo = 3.00;
	static Double priceThree = 3.50;

	public TacoServiceImpl() {
		init();
	}

	void init() {
		// initialize taco objects (put in some queso and guac)
		Tacos tacoOne = new Tacos();
		tacoOne.setPrice(priceOne);
		tacoOne.setItem("Veggie Taco");
		Tacos tacoTwo = new Tacos();
		tacoTwo.setPrice(priceTwo);
		tacoTwo.setItem("Chicken or Beef Taco");
		Tacos tacoThree = new Tacos();
		tacoThree.setPrice(priceThree);
		tacoThree.setItem("Chorizo Taco");
		tacos.put(1, tacoOne);
		tacos.put(2, tacoTwo);
		tacos.put(3, tacoThree);
	}

	//get all the tacos!!!!
	@Override
	public List<Tacos> getTacos() {
		Collection<Tacos> results = tacos.values();
		List<Tacos> response = new ArrayList<>(results);
		return response;
	}

	//response
	@Override
	public OrderTotal createOrder(List<Tacos> tacoOrder) {
		Double total = 0.00;
		Double orderTotal = calculateOrderTotal(tacoOrder,total);
		finalOrder.setTotalOrder(orderTotal);
		return finalOrder;
	}

	//business logic
	public Double calculateOrderTotal(List<Tacos> tacoOrder,Double total) {
		int totalQuantity = 0;
		Double discount = 0.8;
		for (Tacos taco : tacoOrder) {
			if (taco.getItem().contains(tacos.get(1).getItem())) {
				total = (total) + ((tacos.get(1).getPrice()) * (taco.getQuantity()));
				totalQuantity = totalQuantity + taco.getQuantity();
			}
			if (taco.getItem().contains(tacos.get(2).getItem())) {
				total = (total) + ((tacos.get(2).getPrice()) * (taco.getQuantity()));
				totalQuantity = totalQuantity + taco.getQuantity();
			}
			if (taco.getItem().contains(tacos.get(3).getItem())) {
				total = (total) + ((tacos.get(3).getPrice()) * (taco.getQuantity()));
				totalQuantity = totalQuantity + taco.getQuantity();
			}

		}
		if (totalQuantity >= 4) {
			total = total * discount;
		}

		return total;

	}
}
