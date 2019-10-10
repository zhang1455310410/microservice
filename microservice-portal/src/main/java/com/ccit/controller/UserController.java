package com.ccit.controller;

import java.util.List;

import com.ccit.pojo.User;
import com.ccit.service.imp.UserServiceImp;
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
//import feign.Param;


@CrossOrigin(origins="*",maxAge=3600)
@RestController
public class UserController {
	@Autowired
	private UserServiceImp userServiceImp;
	
	/**
	 * 注册账号
	 * @param user
	 * @return	true/false
	 */
	
	@PostMapping("/user")
	public boolean registerUser(@RequestBody User user) {
		if(userServiceImp.checkUser(user)==null) {
			if(userServiceImp.register(user)==true) {
				return true;
			}
		}
		
		return false;
	}
	/**
	 * 根据id查询用户
	 * @param id
	 * @return User
	 */
	@GetMapping("/user/{id}")
	public User selectUser(@PathVariable("id")Integer id) {
		return userServiceImp.selectUser(id);
		
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
		
		PageHelper.startPage(page, 5);
		
		List<User> list=userServiceImp.selectAll();
		PageInfo pageInfo = new PageInfo(list, 5);
		return pageInfo;
	}
	
	
	/**
	 * 根据id删除用户
	 * @param id
	 * @return User
	 */
	
	@DeleteMapping("/user/{id}")
	public boolean deleteUser(@PathVariable("id")Integer id) {
		return userServiceImp.deleteUser(id);
		
	}
	
	/**这个方法也可以用来 			充值钱包
	 * 修改用户
	 * @param user
	 * @return true/false
	 */
	@PutMapping("/user")
	public boolean updateUser(User user) {
		if(userServiceImp.updateUser(user)==true) {
			return true;
		}
		
		
		return false;
	}
	
}
