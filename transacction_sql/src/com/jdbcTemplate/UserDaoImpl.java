package com.jdbcTemplate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	//使用配置文件中的JDBC模板
	private JdbcTemplate JdbcTemplate;
	
	/**
	 * 更新方法，包括添加，修改，删除
	 */
	@Override
	public int update(String sql, Object[] param) {
		
		return JdbcTemplate.update(sql,param);
	}

	/**
	 * 查询方法
	 */
	@Override
	public List<User> query(String sql, Object[] param) {
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		
		return JdbcTemplate.query(sql, rowMapper,param);
	}

}
