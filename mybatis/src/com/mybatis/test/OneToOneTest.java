package com.mybatis.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.model.Person;
import com.mybatis.model.SelectPersonById;

public class OneToOneTest {
	public static void main(String[] args) {
		try {
			//读取配置文件mybatis-config.xml
			InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
			//根据配置文件构建SqlSessionFactory
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
			//通过SqlSessionFactory创建SqlSession
			SqlSession ss = ssf.openSession();
			
			Person p1 = ss.selectOne("com.mybatis.mapper.PersonMapper.selectPersonById1",1);
			System.out.println("==================");
			Person p2 = ss.selectOne("com.mybatis.mapper.PersonMapper.selectPersonById2",1);
			System.out.println("==================");
			SelectPersonById p3 = ss.selectOne("com.mybatis.mapper.PersonMapper.selectPersonById3",1);
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
