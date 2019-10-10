package com.ccit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ccit.pojo.*;



@CrossOrigin(origins="*",maxAge=3600)
@RestController
public class UserController {
	private static final String REST_URL_PREFIX = "http://server-portal";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/user")
	public Boolean registerUser(@RequestBody User user) {
	
		return restTemplate.postForObject(REST_URL_PREFIX+"/user",user,Boolean.class);
		
	}
	/**
	 * 根据id查询用户
	 * @param id
	 * @return User
	 */
	@GetMapping("/user/{id}")
	public User selectUser(Integer id) {
		return restTemplate.getForObject(REST_URL_PREFIX+"/user/"+id, User.class);
	
		
	}
	/**分页
	 * 查询所有用户
	 * 显示的页码 5
	 * 显示的数量 5
	 * @param page 页码
	 * @return PageInfo
	 */
	
	@GetMapping("/user/page/{page}")
	public PageInfo selectAll(@RequestParam(value = "page", defaultValue = "1") Integer page) {
		return restTemplate.getForObject(REST_URL_PREFIX+"/user/page/"+page, PageInfo.class);
	}
	
	
	/**
	 * 根据id删除用户
	 * @param id
	 * @return User
	 */
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(Integer id) {
		 restTemplate.delete(REST_URL_PREFIX+"/user/"+id,id);
		
	}
	
	/**这个方法也可以用来 			充值钱包
	 * 修改用户
	 * @param user
	 * @return true/false
	 */
	@PutMapping("/user")
	public void updateUser(User user) {
		
		 restTemplate.put(REST_URL_PREFIX+"/user", user);
	}
}
