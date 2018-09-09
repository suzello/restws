package com.sushanth.restws;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sushanth.restws.model.Tacos;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment  =SpringBootTest.WebEnvironment.MOCK,
		  classes = RestwsApplication.class)
@AutoConfigureMockMvc
public class RestwsApplicationIntegrationTests {
	@Autowired
    private MockMvc mvc;
 
    @Autowired
    private TacoService tacoService;
    
   
    
    @Test
    public void testGetTacos() throws Exception{
    	 mvc.perform(get("/path/tacos")
    		      .contentType(MediaType.APPLICATION_JSON))
    		      .andExpect(status().isOk())
    		      .andExpect(content()
    		      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
    		      .andExpect(jsonPath("$[0].item", is("Veggie Taco")))
    	          .andExpect(jsonPath("$[0].price", is(new Double("2.50"))));
    }
    
    @Test
    public void testPostTacos() throws Exception{
    	List<Tacos> tacos= new ArrayList<>();
    	Tacos testTaco = new Tacos();
        testTaco.setItem("Veggie Taco");
        testTaco.setQuantity(4);
        tacos.add(testTaco);     
        mvc.perform(post("/path/order")
  		      .contentType(MediaType.APPLICATION_JSON)
        	  .content(asJsonString(tacos)))
  		      .andExpect(status().isOk())
  		      .andExpect(content()
  		      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
  		      .andExpect(jsonPath("$.totalOrder",is("8.0 $")));
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


