package com.mybatis.model;

import java.util.List;

/**
 * 数据库中user表的持久化类
 * @author Administrator
 *
 */
public class User {

	private Integer id;//主键
	private String userName;
	private String userPassword;
	//一对多级联查询，用户关联的订单
	private List<Orders> ordersList;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
	public List<Orders> getOrdersList() {
		return ordersList;
	}
	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userPassword=" + userPassword + ", ordersList="
				+ ordersList + "]";
	}
	
}
