package com.springmvc.service;

import java.util.ArrayList;

import com.springmvc.model.User;

public interface UserService {
	boolean addUser(User u);
	ArrayList<User> getUsers();
}
