package com.sushanth.restws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.sushanth.restws.model.Tacos;

@Consumes("application/xml,application/json")
@Produces("application/xml,application/json")
@Path("/tacoservice")
public interface TacoService {

	@Path("/tacos")
	@GET
	List<Tacos> getTacos();

	@Path("/order")
	@POST
	Response createOrder(List<Tacos> tacoOrder);

}
