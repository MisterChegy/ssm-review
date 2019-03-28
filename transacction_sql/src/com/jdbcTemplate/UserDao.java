package com.jdbcTemplate;

import java.util.List;

public interface UserDao {

	public int update(String sql,Object[] param);
	public List<User> query(String sql,Object[] param);
}
