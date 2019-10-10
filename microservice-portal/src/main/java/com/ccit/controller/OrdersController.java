package com.ccit.controller;

import java.util.List;

import com.ccit.pojo.Orders;
import com.ccit.pojo.OrdersExample;
import com.ccit.service.imp.OrdersServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@CrossOrigin(origins="*",maxAge=3600)
@RestController
public class OrdersController {
	@Autowired
	private OrdersServiceImp orderServiceImp;
	/**分页
	 * 查询所有用户
	 * 显示的页码 5
	 * 显示的数量 5
	 * @param page 页码
	 * @return PageInfo
	 */
	
	@GetMapping("/orders/page/{page}")
	public PageInfo selectAll(@RequestParam(value = "page", defaultValue = "1") Integer page) {
		PageHelper.startPage(page, 5);
		
		List<Orders> list=orderServiceImp.getAll();
		PageInfo pageInfo = new PageInfo(list, 5);
		return pageInfo;
	}
	/**
	 * 添加订单
	 * @param  orders
	 * @return true/false
	 */
	
	@PostMapping("/orders")
	public boolean addOrder(@RequestBody Orders orders) {
		
		return orderServiceImp.addOrder(orders);
	}
	/**
	 * 更新订单
	 * @param order
	 * @return  true/false
	 */ 

	@PutMapping("/orders")
	public boolean updateOrder(Orders order) {
		
		return orderServiceImp.updateOrder(order);
	}
	/**
	 * 删除订单
	 * @param id
	 * @return  true/false
	 */

	@DeleteMapping("/orders/{id}")
	public boolean deleteOrder(@PathVariable("id")Integer id) {
		return orderServiceImp.deleteOrder(id);
	}
	/**
	 * 根据id得到单个订单
	 * @param id
	 * @return  true/false
	 */

	@GetMapping("/orders/{id}")
	public Orders getOrder(@PathVariable("id")Integer id) {
		return orderServiceImp.getOneOrder(id);
	}
	/**
	 * 根据用户订单得到订单集
	 * @param user_id
	 * @return  true/false
	 */

	@GetMapping("/orders/user/{user_id}")
	public List<OrdersExample> getUserId(@PathVariable("user_id")Integer user_id) {
		return orderServiceImp.getUserId(user_id);
	}
}
