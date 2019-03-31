package com.mybatis.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.model.Orders;

public class MoreToMoreTest {
	public static void main(String[] args) {
		try {
			//读取配置文件mybatis-config.xml
			InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
			//根据配置文件构建SqlSessionFactory
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
			//通过SqlSessionFactory创建SqlSession
			SqlSession ss = ssf.openSession();
			List<Orders> ors = ss.selectList("selectallOrdersAndProducts");
			System.out.println(ors);
			
			//提交事务
			ss.commit();
			//关闭SqlSession
			ss.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
