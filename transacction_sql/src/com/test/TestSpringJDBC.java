package com.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbcTemplate.User;
import com.jdbcTemplate.UserDao;
/**
 * Spring JdbcTemplate普通测试
 * @author Administrator
 *
 */
public class TestSpringJDBC {
	public static void main(String[] args) throws Exception{
		ClassPathXmlApplicationContext appCon = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
		//从容器中获取增强后的目标对象
		UserDao userDao = (UserDao) appCon.getBean("userDao");
		String insertSql = "insert into user values(null,?,?)";
		//数组param的值与insertSql语句中的？一一对应
		Object param1[] = {"chenheng1","男"};
		Object param2[] = {"chenheng2","女"};
		Object param3[] = {"chenheng3","男"};
		Object param4[] = {"chenheng4","女"};
		
		//添加用户
		userDao.update(insertSql, param1);
		userDao.update(insertSql, param2);
		userDao.update(insertSql, param3);
		userDao.update(insertSql, param4);
		
		//查询用户
		String selectSql = "select * from user";
		List<User> list = userDao.query(selectSql, null);
		for(User user : list){
			System.out.println(user);
		}
	}
}
