package com.ccit.controller;

import com.ccit.pojo.Admin;
import com.ccit.pojo.User;
import com.ccit.service.imp.AdminServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
//import feign.Param;


@CrossOrigin(origins="*",maxAge=3600)
@RestController
public class LoginController {
	
//	@Autowired
//	private UserServiceImp userServiceImp;
//
	@Autowired
	private AdminServiceImp adminServiceImp;
////	@Autowired
////	private AdminMapper adminMapper;
//	/**
//	 * 参数：username，password
//	 * session属性  ：user
//	 * 返回值：true/false
//	 *
//	 */
//	@GetMapping("/loging")
//	public User login(User user) {
//
//		User userNew=userServiceImp.getUser(user);
//		if(userNew!=null) {
//			return userNew;
//		}
//		return null;
//
//	}
	
	
	@GetMapping("/logingAdmin")
	public Admin loginAdmin(Admin admin) {
	Admin adminNew=adminServiceImp.getAdmin(admin);
	
	if(adminNew!=null) {
		return adminNew;
	}
		return null;
		
	}
	/**
	 * 参数：name，password
	 * session属性  ：user
	 * 返回值：true/false
	 *
	 */
//	
//	@ResponseBody
//	@RequestMapping("/loginAdmin")
//	public  String login(HttpSession session,String name,String password) {
//		Admin admin=new Admin();
//		admin.setName(name);
//		admin.setPassword(password);
//		Admin admin2=adminMapper.getAdmin(admin);
//		if(admin2!=null) {
//			session.setAttribute("admin", admin2);
//			
//			return "true";
//		}
//		return "false";
//	
//	}
	/**
	 * 
	 * @param session
	 * @return 返回值    重定向网页
	 * @throws Exception
	 */
	// 退出
	@GetMapping("/logout")
		public String logout(HttpServletRequest session) throws Exception {
		

			
			return "redirect:index";
		}
}
