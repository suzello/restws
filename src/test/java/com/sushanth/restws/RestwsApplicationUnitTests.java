/*package com.sushanth.restws;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sushanth.restws.model.OrderTotal;
import com.sushanth.restws.model.Tacos;
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(TacoController.class)
@WebAppConfiguration
public class RestwsApplicationUnitTests {
	    @Autowired
		private MockMvc mockMvc;
	    @Autowired
	    private WebApplicationContext wac;
	    @Autowired
	    TacoController tacoController;
	    @MockBean
	    TacoService tacoService;
	    
	    private MediaType contentType =  new MediaType(MediaType.APPLICATION_JSON.getType(),MediaType.APPLICATION_JSON.getSubtype(),Charset.forName("utf8"));
	    @Before
	    public void setup(){
	    	mockMvc= MockMvcBuilders.webAppContextSetup(wac).build();
	    }
	    
	    @Test
	    public void testGetTacos() throws Exception{
	    	List<Tacos> tacos= new ArrayList<>();
	    	Tacos testTaco = new Tacos();
	        testTaco.setItem("Veggie Taco");
	        testTaco.setQuantity(2);
	        tacos.add(testTaco);
	        given(tacoService.getTacos()).willReturn(tacos);
	    	this.mockMvc.perform(get("/path/tacos")).andExpect(status().isOk())
	    	.andExpect(jsonPath("$",hasSize(1)));
	    }
	    
	    @Test
	    public void testPostTacos() throws Exception{
	    	List<Tacos> tacos= new ArrayList<>();
	    	Tacos testTaco = new Tacos();
	        testTaco.setItem("Veggie Taco");
	        testTaco.setQuantity(2);
	        tacos.add(testTaco);
	        given(tacoService.createOrder(tacos)).willReturn(new OrderTotal("2"));
	        this.mockMvc.perform(post("/path/order").contentType(contentType).content(asJsonString(tacos))).andExpect(status().isOk())
	        .andExpect(jsonPath("$.totalOrder",is("2")));
	        
	    }
	    
	    public static String asJsonString(final Object obj){
	    	try{
	    		return new ObjectMapper().writeValueAsString(obj);
	    	}
	    	catch(Exception e){
	    		throw new RuntimeException(e);
	    	}
	    }
}
	    
	
	*/