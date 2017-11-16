package com.sgy.javatransaction.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sgy.javatransaction.account.service.AccountService;

@ContextConfiguration(locations = {"classpath*:application-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceTest {
	@Autowired
	AccountService  accountService;
	@Test
	public void testAccountService(){
		try {
			accountService.transfer("老普","三胖",100D);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
