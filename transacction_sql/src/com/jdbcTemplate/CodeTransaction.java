package com.jdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * 数据访问类，使用编程方式进行数据库事务管理
 * @author Administrator
 *
 */
@Repository
public class CodeTransaction {

	//使用配置文件中的JDBC模板
	@Autowired(required=true)
	private JdbcTemplate jdbcTemplate;
	
	//DataSourceTransactionManger是PlatformTransactionManager接口的实现类
	@Autowired
	private DataSourceTransactionManager txManager;
	
	public String test(){
		//默认事务定义，例如隔离级别，传播行为等
		TransactionDefinition tf = new DefaultTransactionDefinition();
		//开启事务ts
		TransactionStatus ts = txManager.getTransaction(tf);
		String message = "执行成功，没有事务回滚!";
		try {
			//删除表中数据
			String sql = " delete from user ";
			//添加数据
			String addsql = " insert into user values(?,?,?) ";
			Object param[] = { 21, "chegy122","男"};
			//先删除数据
			jdbcTemplate.update(sql);
			//添加一条数据
			jdbcTemplate.update(addsql,param);
			//添加相同的一条数据，使主键重复
			jdbcTemplate.update(addsql,param);
			//提交事务
			txManager.commit(ts);
			
		} catch (Exception e) {
			//出现异常，事务回滚
			txManager.rollback(ts);
			message = "主键重复，事务回滚！";
			e.printStackTrace();
		}
		return message;
	}
}
