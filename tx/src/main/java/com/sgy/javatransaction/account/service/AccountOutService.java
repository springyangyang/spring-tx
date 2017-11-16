package com.sgy.javatransaction.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sgy.javatransaction.account.dao.AccountDao;
//转出
@Service
public class AccountOutService {
	@Autowired
	private AccountDao dao;
	@Transactional(propagation=Propagation.REQUIRED,noRollbackFor=Exception.class)
	public int transforOut(final String out , Double money) throws Exception{
		
		int outcount = dao.updateOut(out, money);
		if (outcount==0) {
			throw new Exception("转出失败。。。");
		}
		return outcount;
	}
}
