package com.poc.banking.UserService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.banking.UserService.entity.UserDetails;
import com.poc.banking.UserService.model.Beneficiary;
import com.poc.banking.UserService.response.NewUser;

@SpringBootTest
@AutoConfigureMockMvc
public class TransferMainController {
	@Autowired
	private MockMvc mockMvc;

		
	   @Autowired
	    private ObjectMapper objectMapper;
	   
	   @Test
	    public void testBeneficiaryList() {
	        // Arrange
	        UserDetails user = new UserDetails();
	        user.setUserId("user12345");
	        
	        try {
	            // Act & Assert
	            mockMvc.perform(MockMvcRequestBuilders.post("/api/transfer/beneficiaries")
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .content(objectMapper.writeValueAsString(user)))
	                    .andExpect(status().isOk())
	                    .andExpect(jsonPath("$.responseCode").value("200"))
	                    .andExpect(jsonPath("$.message").value("List beneficiaries successful"))
	                    .andExpect(jsonPath("$.beneficiarylist").isArray())
	                    .andExpect(jsonPath("$.beneficiarylist[0].accountType").value("Checking"))
	                    .andExpect(jsonPath("$.beneficiarylist[0].transferType").value("DOMESTIC_WIRE"))
	                    .andExpect(jsonPath("$.beneficiarylist[0].country").value("US"))
	                    .andExpect(jsonPath("$.beneficiarylist[0].currency").value("usd"))
	                    .andExpect(jsonPath("$.beneficiarylist[0].accountNumber").value(987654321))
	                    .andExpect(jsonPath("$.beneficiarylist[0].bankName").value("ABC Bank"))
	                    .andExpect(jsonPath("$.beneficiarylist[0].beneficiaryName").value("John Doe"))
	                    .andExpect(jsonPath("$.beneficiarylist[0].email").value("johndoe@example.com"))
	                    .andExpect(jsonPath("$.beneficiarylist[0].phoneNumber").value("123-456-7890"))
	                    .andExpect(jsonPath("$.beneficiarylist[1].accountNumber").value(987654322));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        // Assert
//	        assertEquals(HttpStatus.OK, response.getStatusCode());
//	        assertNotNull(response.getBody());
//	        assertEquals("12345", response.getBody().getUserDetails().getUserId());
//	        assertEquals("Test User", response.getBody().getUserDetails().getPassword());

	    }
	   
	   @Test
	   public void testAddBeneficiary() {
	       // Arrange
	       Beneficiary beneficiary = new Beneficiary();
	       beneficiary.setUserId("user12345");
	       beneficiary.setAccountNumber(987654321L);
	       beneficiary.setBankName("ABC Bank");
	       beneficiary.setAccountType("Checking");
	       beneficiary.setTransferType("DOMESTIC_WIRE");
	       beneficiary.setPhoneNumber("123-456-7890");
	       beneficiary.setEmail("johndoe@example.com");
	       beneficiary.setBeneficiaryName("John Doe");
	       // BeneficiaryName is intentionally left null to trigger validation error

	       

	       try {
	           // Act & Assert
	           mockMvc.perform(MockMvcRequestBuilders.post("/api/transfer/addBeneficiary")
	                   .contentType(MediaType.APPLICATION_JSON)
	                   .content(objectMapper.writeValueAsString(beneficiary)))
	                   .andExpect(status().isBadRequest())
	                   .andExpect(jsonPath("$.responseCode").value("450"))
	                   .andExpect(jsonPath("$.message").value("Beneficiaryname must not be null; "))
	                   .andExpect(jsonPath("$.beneficiary.userId").value("user12345"))
	                   .andExpect(jsonPath("$.beneficiary.accountType").value("Checking"))
	                   .andExpect(jsonPath("$.beneficiary.transferType").value("DOMESTIC_WIRE"))
	                   .andExpect(jsonPath("$.beneficiary.accountNumber").value(987654321))
	                   .andExpect(jsonPath("$.beneficiary.bankName").value("ABC Bank"))
	                   .andExpect(jsonPath("$.beneficiary.beneficiaryName").value("John Doe"))
	                   .andExpect(jsonPath("$.beneficiary.email").value("johndoe@example.com"))
	                   .andExpect(jsonPath("$.beneficiary.phoneNumber").value("123-456-7890"));
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	   }
	 
	   
}
