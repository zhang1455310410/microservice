package com.ccit.service;

import com.ccit.pojo.Orders;
import com.ccit.pojo.User;

import java.util.List;


public interface UserService {
	
	
	public User checkUser(User user);
	public boolean register(User user);
	
	public User selectUser(Integer id);
	
	public List<User> selectAll();
	
	public boolean updateUser(User user);

//	public List<Orders> getOrdersByUserId(Integer id);
	
	public User getUser(User user);
	public boolean deleteUser(Integer id);
}
