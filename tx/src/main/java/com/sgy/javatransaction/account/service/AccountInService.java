package com.sgy.javatransaction.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sgy.javatransaction.account.dao.AccountDao;
//转入
@Service
public class AccountInService {
	@Autowired
	private AccountDao dao;
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public int transforIn(final String in , Double money) throws Exception{
		
		int incount = dao.updateIn(in, money);
		if (incount==0) {
			throw new Exception("转入失败 。。。。");
		}
		return incount;
	}

}
