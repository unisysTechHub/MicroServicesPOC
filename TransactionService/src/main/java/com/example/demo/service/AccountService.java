package com.example.demo.service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;

@Service
public class AccountService {
	public static String ACCOUNTS = "ACCOUNTS";
	 private final Log log = LogFactory.getLog(getClass()); 
	 @Autowired
	  private RedisTemplate<String, Object> redisTemplate;
     String accountId;
    

    // Save account to Redis
	@KafkaListener(id = "accountAddedEventsListener",topics = "ACCOUNT_ADDED", groupId = "group_id")
    public void saveAccount(Account account) {
		   log.info("ocess message: " + account.getAccountId() );
		if (account != null) {
		this.accountId = String.valueOf(account.getAccountId());
		redisTemplate.opsForHash().put(ACCOUNTS,this.accountId, account);
         log.info("Acccount cached in Account redis in transaction serivce");
        
        log.info("Acccount cached " + getAccountById().getAccountId() );
		}
        
    }

    // Find account by accountId
    public Account getAccountById() {
        return (Account) redisTemplate.opsForHash().get(ACCOUNTS, this.accountId);
    }

    // Delete account by accountId
    public void deleteAccount(String accountId) {
    }
}
