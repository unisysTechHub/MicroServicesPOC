package com.poc.banking.AdminService.url;

public class URL {
	public static class UserService {
		public static  String baseURL = "http://localhost:8082/api/user";
		public static  String valiadateUser =  URL.UserService.baseURL + "/validateUser";
	}
	
	public static class AccountService {
		public static  String baseURL = "http://localhost:8083/api/admin";
		public static  String valiadateUser =  URL.AccountService.baseURL + "/addaccount";
	}

}
