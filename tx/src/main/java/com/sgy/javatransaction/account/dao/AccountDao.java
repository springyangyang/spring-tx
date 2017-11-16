package com.sgy.javatransaction.account.dao;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class AccountDao {
	
	private JdbcTemplate template;
	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource){
		template = new JdbcTemplate(dataSource);
	}
	//查询余额
	public Double selectAccount(final String name){
		String sql = "select money from t_account where name = /?";
		Double money = template.queryForObject(sql, new Object[]{name}, Double.class);
		return money;
	}
	//转出
	public int updateOut(final String out ,final Double money){
		String sql = "update t_account set money = money-? where name = ? and money >=?";
		int count = template.update(sql, money,out,money);
		return count;
	}
	//转出
	public int updateIn(final String in ,final Double money){
		
		String sql = "update t_account set money = money+? where name =?";
		int count = template.update(sql, money,in);
		return count;
		
	}
}











