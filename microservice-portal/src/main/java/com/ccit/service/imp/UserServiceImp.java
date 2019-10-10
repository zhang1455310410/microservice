package com.ccit.service.imp;

import java.util.List;

import com.ccit.dao.OrdersMapper;
import com.ccit.dao.UserMapper;
import com.ccit.pojo.Orders;
import com.ccit.pojo.User;
import com.ccit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private OrdersMapper ordersMapper;
	
	
	@Override
	public User getUser(User user ) {
		return userMapper.selectByUser(user);
	}
	@Override
	public boolean register(User user) {
		if(user!=null)
		if(user.getPassword().trim()!=null&&user.getUsername().trim()!=null) {
			userMapper.insert(user);
			
			return true;
		}
		
		return false;
	
		
	}

	@Override
	public User selectUser(Integer id) {
		
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> selectAll() {
		List<User> list=userMapper.selectAll();
		return list;
	}

	@Override
	public boolean updateUser(User user) {
		boolean flag=false;
		User oldUser=userMapper.selectByPrimaryKey(user.getId());
		if(oldUser!=null) {
			userMapper.updateByPrimaryKey(user);
			flag=true;
		}
		
		return flag;
	}

//	@Override
//	public List<Orders> getOrdersByUserId(Integer id) {
//		// TODO Auto-generated method stub
//		ordersMapper.selectByUserId(id);
//		return null;
//	}

	@Override
	public boolean deleteUser(Integer id) {
		if(id!=null) {
			userMapper.deleteByPrimaryKey(id);
			return true;
		}
		return false;
	}

	@Override
	public User checkUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.checkUser(user);
	}

	
	
	
}
