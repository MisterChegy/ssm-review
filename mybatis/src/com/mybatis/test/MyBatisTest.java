package com.mybatis.test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//			User user = ss.selectOne("com.mybatis.mapper.UserMapper.selectUserById",1);
//			System.out.println(user);
			
			//添加一个用户
//			User addUser = new User();
//			addUser.setUserName("chegy122");
//			addUser.setUserPassword("男");
//			ss.insert("com.mybatis.mapper.UserMapper.addUser",addUser);
//			
			//修改一个用户
//			User updateUser = new User();
//			updateUser.setId(1);
//			updateUser.setUserName("张三");
//			updateUser.setUserPassword("女");
//			ss.update("com.mybatis.mapper.UserMapper.updateUser",updateUser);
//			
			//删除一个用户
//			ss.delete("com.mybatis.mapper.UserMapper.deleteUser",3);
			//查询所有用户
//			List<User> listUser = ss.selectList("com.mybatis.mapper.UserMapper.selectAllUser");
//			for(User user1 : listUser){
//				System.out.println(user1);
//			}
			
			//查询多个用户,使用Map接口传递多个参数
//			Map<String,Object> map = new HashMap<>();
//			map.put("userName","i");
//			map.put("userPassword","男");
//			List<User> list = ss.selectList("com.mybatis.mapper.UserMapper.selectSomeUser", map);
//			for(User user1 : list){
//				System.out.println(user1);
//			}
			
			//查询多个用户,使用Java Bean传递多个参数
//			User user = new User();
//			user.setUserName("ch");
//			user.setUserPassword("男");
//			List<User> list = ss.selectList("com.mybatis.mapper.UserMapper.selectManyUser", user);
//			for(User user1 : list){
//				System.out.println(user1);
//			}
			
			//主键（自动递增）回填
			User user = new User();
			user.setUserName("chereree");
			user.setUserPassword("男");
			int add = ss.insert("com.mybatis.mapper.UserMapper.addUserReturnId",user);
			System.out.println("添加了"+ add + "条记录");
			System.out.println("添加记录的主键是" + user.getId());
			
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
