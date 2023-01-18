package com.poc.banking.AccountService.service;

import com.poc.banking.AccountService.entity.Account;
import com.poc.banking.AccountService.response.AddAccount;

public interface ManageAccountService {
  AddAccount addAccount(Account account);
}
