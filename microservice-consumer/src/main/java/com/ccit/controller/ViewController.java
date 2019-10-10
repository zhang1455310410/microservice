package com.ccit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.ccit.pojo.*;




@CrossOrigin(origins="*",maxAge=3600)
@Controller
public class ViewController {
	private static final String REST_URL_PREFIX = "http://server-cart";
	
	@Autowired
	private RestTemplate restTemplate;
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	@SuppressWarnings("unchecked")
	@RequestMapping("/cart/{id}")
	public String cart(@PathVariable("id")Integer id,Model model,HttpServletRequest request) {
		
	
		if(id!=null) {
			List<OrdersExample> list=restTemplate.getForObject(REST_URL_PREFIX+"/orders/user/"+id, List.class);
//			List<OrdersExample> list=restTemplate.getForObject(REST_URL_PREFIX+"/orders/user/"+1, List.class);
			model.addAttribute("list",list);
	
			return "cart";
		}
		request.setAttribute("msg","请登陆");
		return "login";
		
	}
	

	
	@RequestMapping("/products")
	public String products() {
		return "products";
	}
	@RequestMapping("/product/shoes/{id}")
	public String product(@PathVariable("id") Integer id,Model model) {
		
	
		Shoes shoes=restTemplate.getForObject("http://server-sellercenter"+"/shoes/"+id, Shoes.class);
		model.addAttribute("shoes",shoes);
				return "single";
		
	
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/loginAdmin")
	public String loginAdmin() {
		return "admin/login";
	}
	@RequestMapping("/manageAdd")
	public String manageAdd() {
		return "admin/add";
	}
	
	@RequestMapping("/manageProducts")
	public String manageProducts() {
		return "admin/products";
	}
	@RequestMapping("/manageAbout")
	public String manageAbouts() {
		return "admin/about";
	}
	@RequestMapping("/test")
	public String 	test(){ return  "test"; }
}
