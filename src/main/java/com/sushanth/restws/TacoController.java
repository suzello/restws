package com.sushanth.restws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sushanth.restws.model.OrderTotal;
import com.sushanth.restws.model.Tacos;

@RestController
@RequestMapping(value="/path")
public class TacoController {

	@Autowired
	private TacoService tacoService;
	
	@RequestMapping(value="/tacos",method=RequestMethod.GET)
	public List<Tacos> getTacos(){
		return tacoService.getTacos();
	}
	
	@RequestMapping(value="/order",method=RequestMethod.POST)
	public OrderTotal postTacos(@RequestBody List<Tacos> tacoOrder){
		return tacoService.createOrder(tacoOrder);
	}
}
