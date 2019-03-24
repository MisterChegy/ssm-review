package com.springmvc.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.springmvc.model.User;
@Service
public class UserServiceImpl implements UserService{

	//使用静态集合变量users模拟数据库
	private static ArrayList<User> users = new ArrayList<User>();
	
	@Override
	public boolean addUser(User u) {
		if(!"IT民工".equals(u.getCarrer())){ //不允许添加TI民工
			users.add(u);
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<User> getUsers() {
		
		return users;
	}

}
