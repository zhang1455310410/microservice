package com.ccit.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.ccit.pojo.Shoes;
import com.ccit.util.FastDFSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;




@CrossOrigin(origins="*",maxAge=3600)
@Controller
public class ShoesController {
	
	private static final String REST_URL_PREFIX = "http://server-sellercenter";
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private FastDFSClientUtil fastDFSClientUtil;
	/**
	 * 页
	 * @param page
	 * @return
	 */
	@ResponseBody
	@GetMapping("/shoes/page/{page}")
	public PageInfo selectAll(@PathVariable(value = "page")  Integer page) {
		return restTemplate.getForObject(REST_URL_PREFIX+"/shoes/page/"+page, PageInfo.class);
		
	}

	/**
	 * 添加
	 * @param shoes
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@PostMapping("/shoes")
	public String addShoes(Shoes shoes, MultipartFile image){

		try {
			String  url = fastDFSClientUtil.uploadFile(image);
			shoes.setImg(url);

			restTemplate.postForObject(REST_URL_PREFIX+"/shoes", shoes, Boolean.class);


		} catch (IOException e) {
			e.printStackTrace();
		}


		return "redirect:/manageProducts";
		
	}
	
	/**
	 * 更新
	 * @param shoes
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@PutMapping("/shoes")
	public String updateShoes( Shoes shoes,MultipartFile image) throws IllegalStateException{


		try {
			if (image != null) {
				String url = fastDFSClientUtil.uploadFile(image);
				shoes.setImg(url);
			}
			restTemplate.put(REST_URL_PREFIX + "/shoes", shoes);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "redirect:/manageProducts";
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@DeleteMapping("/shoes/{id}")
	public void deleteShoes(@PathVariable("id")Integer id) {
		 String url=restTemplate.getForObject(REST_URL_PREFIX+"/shoes/"+id, Shoes.class).getImg();
		 fastDFSClientUtil.delFile(url);
		 restTemplate.delete(REST_URL_PREFIX+"/shoes/{id}",id);

	}
	/**
	 * 根据id
	 * @param id
	 * @return
	 */
	@ResponseBody
	@GetMapping("/shoes/{id}")
	public Shoes getShoes(@PathVariable("id")  Integer id) {

		return restTemplate.getForObject(REST_URL_PREFIX+"/shoes/"+id, Shoes.class);

	}
	/**
	 * 随机十条数据
	 * @return
	 */
	@ResponseBody
	@GetMapping("/shoes/rand")
	public List<Shoes> getShoesRand() {
		return restTemplate.getForObject(REST_URL_PREFIX+"/shoes/rand", List.class);
	}
	
	
}
