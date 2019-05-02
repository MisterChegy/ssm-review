package com.chegy122.minischool.service;

import java.util.List;

import com.chegy122.minischool.model.User;

public interface UserService {

	List<User> findAllUser();

	void createUser(User user);

}
