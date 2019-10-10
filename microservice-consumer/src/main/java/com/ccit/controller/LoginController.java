package com.ccit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ccit.pojo.Admin;
import com.ccit.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@CrossOrigin(origins="*",maxAge=3600)
@Controller
public class LoginController {
private static final String REST_URL_PREFIX = "http://server-portal";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/loging")
	public String login(HttpServletRequest request, User user) {
		if (user.getUsername() != null && user.getPassword() != null&&user.getUsername().equals("")==false&&user.getPassword().equals("")==false) {
			User usero = restTemplate.getForObject(
					REST_URL_PREFIX+ "/loging?username=" + user.getUsername() + "&password=" + user.getPassword(),
					User.class);

			HttpSession session = request.getSession();
			  if (usero != null) {
				 if (usero.getId() != null) {
					session.setAttribute("usero", usero);
					return "redirect:/index";
				}
			} else {
				
				request.setAttribute("msg", "账号或密码不正确	");
			
				return "login";
			 }
		} 
		 
			request.setAttribute("msg", "账号密码不能为空	");
		

		return "login";

	}

	@PostMapping("/logingAdmin")
	public String loginAdmin(HttpServletRequest request, Admin admin) {
		if (admin.getUsername() != null && admin.getPassword() != null&&admin.getUsername().equals("")==false&&admin.getPassword().equals("")==false) {
			Admin admino = restTemplate.getForObject(
					"http://server-sellercenter" + "/logingAdmin?username=" + admin.getUsername() + "&password=" + admin.getPassword(),
					Admin.class);

			HttpSession session = request.getSession();
			  if (admino != null) {
				 if (admino.getId() != null) {
					session.setAttribute("admin", admino);
					return "redirect:/manageAbout";
				}
			} else {
				
				request.setAttribute("msg", "账号或密码不正确");
			
				return "admin/login";
			 }
		} 
		 
			request.setAttribute("msg", "账号密码不能为空	");
		

		return "admin/login";

	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session= request.getSession();
		
		session.invalidate();
		return restTemplate.getForObject(REST_URL_PREFIX+"/logout", String.class);
		
	}
}
