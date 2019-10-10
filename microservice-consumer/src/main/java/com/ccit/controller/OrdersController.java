package com.ccit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ccit.pojo.Orders;
import com.ccit.pojo.OrdersExample;
import com.ccit.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;



@CrossOrigin(origins="*",maxAge=3600)
@RestController
public class OrdersController {
	
	private static final String REST_URL_PREFIX = "http://server-cart";
	
	@Autowired
	private RestTemplate restTemplate;
	/**分页
	 * 查询所有用户
	 * 显示的页码 5
	 * 显示的数量 5
	 * @param page 页码
	 * @return PageInfo
	 */
	
	@GetMapping("/orders/page/{page}")
	public PageInfo selectAll(@RequestParam(value = "page", defaultValue = "1") Integer page) {
	
		return restTemplate.getForObject(REST_URL_PREFIX+"/orders/page/"+page, PageInfo.class);
		
	}
	/**
	 * 添加订单
	 * @param orders
	 * @return true/false
	 */
	@ResponseBody
	@PostMapping("/orders")
	public boolean addOrder(@RequestBody Orders orders, HttpServletRequest request) {
		HttpSession session= request.getSession();
		User user=(User) session.getAttribute("usero");
		
		if(user!=null) {
			orders.setUserId(user.getId());
		
		return restTemplate.postForObject(REST_URL_PREFIX+"/orders",  orders, Boolean.class);
		
		}
		request.setAttribute("msg","请先登陆");
		return false;
	
	}
	@PostMapping("/orders/default")
	public boolean addOrderDefault(@RequestBody Orders orders,HttpServletRequest request) {
		HttpSession session= request.getSession();
		User user=(User) session.getAttribute("usero");
		System.out.println(orders);
		if(user!=null) {
			orders.setUserId(user.getId());
			orders.setNum(1);
			orders.setShoesSize(40);
		return restTemplate.postForObject(REST_URL_PREFIX+"/orders",  orders, Boolean.class);
		
		}
		request.setAttribute("msg","请先登陆");
		return false;
		
	}
	/**
	 * 更新订单
	 * @param order
	 * @return  true/false
	 */ 

	@PutMapping("/orders")
	public void updateOrder(Orders order) {
		 restTemplate.put(REST_URL_PREFIX+"/orders", order);
	}
	/**
	 * 删除订单
	 * @param id
	 * @return  true/false
	 */

	@DeleteMapping("/orders/{id}")
	public boolean deleteOrder(@PathVariable("id") Integer id) {
		if(id!=null) {
		 restTemplate.delete(REST_URL_PREFIX+"/orders/{1}",id);
		 return true;
		}
		return false;
	}
	/**
	 * 根据id得到单个订单
	 * @param id
	 * @return  true/false
	 */

	@GetMapping("/orders/{id}")
	public Orders getOrder(Integer id) {
		return restTemplate.getForObject(REST_URL_PREFIX+"/orders/"+id, Orders.class);
	}
	/**
	 * 根据用户订单得到订单集
	 * @param user_id
	 * @return  true/false
	 */

	@GetMapping("/orders/user/{user_id}")
	public List<OrdersExample> getUserId(@PathVariable("user_id") Integer user_id) {
		return restTemplate.getForObject(REST_URL_PREFIX+"/orders/user/"+user_id,List.class);
	}
}
