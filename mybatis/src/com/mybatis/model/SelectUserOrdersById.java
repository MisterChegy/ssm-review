package com.mybatis.model;

public class SelectUserOrdersById {
	
	private Integer id;//用户id
	private String userName;
	private String userPassword;
	private String ordersn;
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
	public String getOrdersn() {
		return ordersn;
	}
	public void setOrdersn(String ordersn) {
		this.ordersn = ordersn;
	}
	@Override
	public String toString() {
		return "SelectUserOrdersById [id=" + id + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", ordersn=" + ordersn + "]";
	}
	
	
}
