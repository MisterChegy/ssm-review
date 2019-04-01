package com.mybatis.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.model.User;
/**
 * 动态SQL
 * @author Administrator
 *
 */
public class DynamicSQLTest {
	public static void main(String[] args) {
		try {
			//读取配置文件mybatis-config.xml
			InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
			//根据配置文件构建SqlSessionFactory
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
			//通过SqlSessionFactory创建SqlSession
			SqlSession ss = ssf.openSession();
			
			//<if>元素的使用
			User ifu = new User();
			ifu.setUserName("che");
			ifu.setUserPassword("男");
			List<User> us = ss.selectList("com.mybatis.mapper.UserMapper.selectUserByIf",ifu);
			System.out.println(us);
			System.out.println("====================1");
			
			//使用choose元素查询用户信息
			User chooseus = new User();
			chooseus.setUserName("");
			chooseus.setUserPassword("男");
			List<User> listByChoose = ss.selectList("com.mybatis.mapper.UserMapper.selectUserByChoose", chooseus);
			System.out.println(listByChoose);
			System.out.println("===================choose");
			
			//<trim>元素的使用
//			List<User> us2 = ss.selectList("com.mybatis.mapper.UserMapper.selectUserByTrim",ifu);
//			System.out.println(us2);
//			System.out.println("====================2");
//			
//			//<where>元素的使用
//			List<User> us3 = ss.selectList("com.mybatis.mapper.UserMapper.selectUserByWhere",ifu);
//			System.out.println(us3);
//			System.out.println("====================3");
//			
//			//<set>元素的使用
//			User setuse = new User();
//			setuse.setId(10);
//			setuse.setUserName("张三");
////			setuse.setUserPassword("男");
//			int setup = ss.update("com.mybatis.mapper.UserMapper.updateUserBySet", setuse);
//			System.out.println("set元素修改了" + setup + "条记录");
//			System.out.println("===================4");
//			
//			//使用foreach元素查询用户信息
//			List<Integer> listId = new ArrayList<Integer>();
//			listId.add(11);
//			listId.add(12);
//			List<User> listByForeach = ss.selectList("com.mybatis.mapper.UserMapper.selectUserByForeach", listId);
//			for(User user1 : listByForeach){
//				System.out.println(user1);
//			}
//			System.out.println("foreach元素=============");
//			
//			//使用bind元素查询用户信息
//			User use = new User();
//			use.setUserName("che");
//			List<User> listByBind = ss.selectList("com.mybatis.mapper.UserMapper.selectUserByBind", use);
//			System.out.println(listByBind);
//			System.out.println("===================listByBind");
			
			//提交事务
			ss.commit();
			//关闭SqlSession
			ss.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
