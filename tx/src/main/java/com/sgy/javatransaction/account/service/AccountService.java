package com.sgy.javatransaction.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sgy.javatransaction.account.dao.AccountDao;

@Service
public class AccountService {
	
	@Autowired AccountDao accountDao;
	@Autowired AccountOutService outService;
	@Autowired AccountInService inService;
	//转账逻辑
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void transfer(final String out ,final String in, final Double money) throws Exception{
		
		if (out==in) {
			throw new Exception("自己不能给自己转账。。。");
		}
		inService.transforIn(in, money);
		outService.transforOut(out, money);
	}

}
