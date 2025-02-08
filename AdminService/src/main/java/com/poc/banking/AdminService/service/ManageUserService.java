package com.poc.banking.AdminService.service;

import com.poc.banking.AdminService.Response.LoginResponse;
import com.poc.banking.AdminService.Response.SignupResponse;
import com.poc.banking.AdminService.entity.AdminDetails;

public interface ManageUserService {
       LoginResponse login(AdminDetails admin);
       SignupResponse signup(AdminDetails admin);
       public void sendMessage(String message);
}
