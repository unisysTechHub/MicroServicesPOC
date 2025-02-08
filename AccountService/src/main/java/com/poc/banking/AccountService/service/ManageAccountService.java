package com.poc.banking.AccountService.service;

import com.poc.banking.AccountService.entity.Account;
import com.poc.banking.AccountService.model.Transaction;
import com.poc.banking.AccountService.response.AddAccount;

public interface ManageAccountService {
  AddAccount addAccount(Account account);
  String prepare(Transaction transaction);
  public String commit(Transaction transaction);
  public String rollback(Transaction transaction);
}
