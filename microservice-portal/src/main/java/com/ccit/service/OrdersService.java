package com.ccit.service;

import com.ccit.pojo.Orders;
import com.ccit.pojo.OrdersExample;
import org.springframework.stereotype.Service;

import java.util.List;





public interface OrdersService {
	
	
	public List<Orders> getAll();
	
	public boolean addOrder(Orders order);
	
	public boolean updateOrder(Orders order);
	
	public boolean deleteOrder(Integer id);
	
	public Orders getOneOrder(Integer id);
	
	public List<OrdersExample> getUserId(Integer user_id);
	
	
}
