package com.mybatis.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.model.SelectUserOrdersById;
import com.mybatis.model.User;

public class OneToMoreTest {
	public static void main(String[] args) {
		try {
			//读取配置文件mybatis-config.xml
			InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
			//根据配置文件构建SqlSessionFactory
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
			//通过SqlSessionFactory创建SqlSession
			SqlSession ss = ssf.openSession();
			
			User u1 = ss.selectOne("com.mybatis.mapper.UserMapper.selectUserOrdersById1",10);
			System.out.println("==================");
			User u2 = ss.selectOne("com.mybatis.mapper.UserMapper.selectUserOrdersById2",10);
			System.out.println("==================");
			SelectUserOrdersById s3 = ss.selectOne("com.mybatis.mapper.UserMapper.selectUserOrdersById3",10);
			System.out.println("==================");
			//提交事务
			ss.commit();
			//关闭SqlSession
			ss.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
