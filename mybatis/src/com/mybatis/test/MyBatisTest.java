package com.mybatis.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.model.User;

public class MyBatisTest {

	public static void main(String[] args) {
		try {
			//读取配置文件mybatis-config.xml
			InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
			//根据配置文件构建SqlSessionFactory
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
			//通过SqlSessionFactory创建SqlSession
			SqlSession ss = ssf.openSession();
			//SqlSession执行映射文件中定义的SQL，并返回映射结果
			//查询一个用户,根据id
			User user = ss.selectOne("com.mybatis.mapper.UserMapper.selectUserById",1);
			System.out.println(user);
			
			//添加一个用户
			User addUser = new User();
			addUser.setUserName("chegy122");
			addUser.setUserPassword("男");
			ss.insert("com.mybatis.mapper.UserMapper.addUser",addUser);
			
			//修改一个用户
			User updateUser = new User();
			updateUser.setId(1);
			updateUser.setUserName("张三");
			updateUser.setUserPassword("女");
			ss.update("com.mybatis.mapper.UserMapper.updateUser",updateUser);
			
			//删除一个用户
			ss.delete("com.mybatis.mapper.UserMapper.deleteUser",3);
			//查询所有用户
			List<User> listUser = ss.selectList("com.mybatis.mapper.UserMapper.selectAllUser");
			for(User user1 : listUser){
				System.out.println(user1);
			}
			
			//提交事务
			ss.commit();
			//关闭SqlSession
			ss.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
