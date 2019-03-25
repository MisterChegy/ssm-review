package dao;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import exception.MyException;

@Repository("testExceptionDao")
public class TestExceptionDao {

	public void daodb() throws Exception{
		throw new SQLException("Dao 中数据库异常");
	}
	
	public void daomy() throws Exception{
		throw new MyException("Dao 中自定义异常");
	}
	
	public void daono() throws Exception{
		throw new Exception("Dao 中未知异常");
	}
}
