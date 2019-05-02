package com.chegy122.minischool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.chegy122.minischool.model.User;
@Mapper
public interface UserDAO {
	/**
     * 新增用户
     * @param user
     */
    void createUser(User user);
    /**
     * 查询用户列表
     * @return
     */
    List<User> findAllUser();
    
}
