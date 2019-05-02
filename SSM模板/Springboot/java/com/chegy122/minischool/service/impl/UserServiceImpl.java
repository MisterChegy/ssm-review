package com.chegy122.minischool.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chegy122.minischool.dao.UserDAO;
import com.chegy122.minischool.model.User;
import com.chegy122.minischool.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDAO dao;
	
	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return dao.findAllUser();
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		dao.createUser(user);
	}

}
