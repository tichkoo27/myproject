package com.example.project1;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.project1.payLoad.UserDetailsType;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.IOException;
import java.util.Date;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UserControllerTest{

	@Autowired
    private MockMvc mockMvc;
	
	protected String mapToJson(Object obj) throws JsonProcessingException {
	    ObjectMapper objectMapper = new ObjectMapper();
	    return objectMapper.writeValueAsString(obj);
	}
	
	protected <T> T mapFromJson(String json, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
	    ObjectMapper objectMapper = new ObjectMapper();
	    return objectMapper.readValue(json, clazz);
	}
	
    @Test
    public void GetTest() throws Exception {
        mockMvc.perform(get("/project1/user/getUserDetails"))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is("Yash Kumar")));
    }
    
    @Test
    public void TestCreateUser() throws Exception {

    	String uri = "/project1/user/createUser";
    	UserDetailsType mockUser = getUserDetailsType();
    	String inputJson = mapToJson(mockUser);
    	MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
    	   
    	int status = mvcResult.getResponse().getStatus();
    	assertEquals(200, status);
    	MockHttpServletResponse content = mvcResult.getResponse();
    	System.out.println(content.getContentAsString());
    }
    
    public UserDetailsType getUserDetailsType() {
    	UserDetailsType user=new UserDetailsType();
    	user.setUserId(3L);
    	user.setName("Lokesh");
    	user.setDob(new Date());
    	user.setAddress("Mauris Nagar");
    	user.setSalary(80000L);
    	user.setManagerId(300L);
    	user.setEmail("lokesh12@gmail.com");
    	user.setPhoneNumber(8905623410L);
    	
    	return user;
    }
}
