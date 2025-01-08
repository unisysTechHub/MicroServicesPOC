package com.poc.banking.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.banking.UserService.UserManagementService;
import com.poc.banking.UserService.UserManagementServiceImpl;
import com.poc.banking.UserService.entity.UserDetails;
import com.poc.banking.UserService.response.NewUser;

@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerMockTest {
	@Autowired
	private MockMvc mockMvc;

		
	   @Autowired
	    private ObjectMapper objectMapper;
	    
	    private UserManagementService userManagementService = new UserManagementServiceImpl();
	    
	    @Test
	    public void testAddUser() {
	        // Arrange
	        UserDetails user = new UserDetails();
	        user.setUserId("12347");
	        user.setPassword("Test User");

	        NewUser newUser = new  NewUser();
	        newUser.setUserDetails(user);


	        try {
				mockMvc.perform(MockMvcRequestBuilders.post("/api/user/signup")
				        .contentType(MediaType.APPLICATION_JSON)
				        .content(objectMapper.writeValueAsString(user)))
				        .andExpect(status().isOk())
				        .andExpect(jsonPath("$.userDetails.userId").value("12347"))
				        .andExpect(jsonPath("$.userDetails.password").value("Test User"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    

	        // Assert
//	        assertEquals(HttpStatus.OK, response.getStatusCode());
//	        assertNotNull(response.getBody());
//	        assertEquals("12345", response.getBody().getUserDetails().getUserId());
//	        assertEquals("Test User", response.getBody().getUserDetails().getPassword());

	    }

	   
} 
	    

