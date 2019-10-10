package com.ccit.service.imp;



import com.ccit.dao.OrdersMapper;
import com.ccit.pojo.Orders;
import com.ccit.pojo.OrdersExample;
import com.ccit.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrdersServiceImp implements OrdersService {
	@Autowired
	private OrdersMapper orderMapper;
	
	@Override
	public List<Orders> getAll() {
		// TODO Auto-generated method stub
		return orderMapper.selectAll();
	}

	@Override
	public boolean addOrder( Orders orders) {
		

		if(orders.getShoesId()!=null&&orders.getUserId()!=null) {
			orderMapper.insertSelective(orders);
			return true;
		}
			
		return false;
	}

	@Override
	public boolean updateOrder(Orders order) {
		if(order.getId()!=null) {
			orderMapper.updateByPrimaryKey(order);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteOrder(Integer id) {
		if(id!=null) {
			orderMapper.deleteByPrimaryKey(id);
			return true;
		}
		return false;
	}

	@Override
	public Orders getOneOrder(Integer id) {
		// TODO Auto-generated method stub
		return orderMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<OrdersExample> getUserId(Integer user_id) {
		// TODO Auto-generated method stub
		return orderMapper.selectByUserId(user_id);
		
	}

	

}
