package com.ccit.controller;

import com.ccit.pojo.Shoes;
import com.ccit.service.imp.ShoesServiceImp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@CrossOrigin(origins="*",maxAge=3600)
@RestController
public class ShoesController {
	@Autowired
	private ShoesServiceImp shoesServiceImp;
	/**
	 * 页
	 * @param page
	 * @return
	 */

	@GetMapping("/shoes/page/{page}")
	public PageInfo selectAll(@PathVariable(value = "page")  Integer page) {
		
		PageHelper.startPage(page, 8);
		
		List<Shoes> list=shoesServiceImp.selectAll();
		PageInfo pageInfo = new PageInfo(list, 5);
		return pageInfo;
	}
	
	
	
	/**
	 * 添加
	 * @param shoes
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */

	@PostMapping("/shoes")
	public void addShoes(@RequestBody Shoes shoes) throws IllegalStateException, IOException {
		
		
		shoesServiceImp.addShoes(shoes);
		
	}
	/**
	 * 更新
	 * @param shoes
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */

	@PutMapping("/shoes")
	public void updateShoes(@RequestBody Shoes shoes)  {
		
		
			shoesServiceImp.updateShoes(shoes);
			
				
		 
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */

	@DeleteMapping("/shoes/{id}")
	public boolean deleteShoes(@PathVariable("id")Integer id) {
	
		return shoesServiceImp.deleteShoes(id);
	}
	/**
	 * 根据id
	 * @param id
	 * @return
	 */
	
	@GetMapping("/shoes/{id}")
	public Shoes getShoes(@PathVariable("id")Integer id) {
		return shoesServiceImp.getOneShoes(id);
	}
	/**
	 * 随机十条数据
	 * @return
	 */
	
	@GetMapping("/shoes/rand")
	public List<Shoes> getShoesRand() {
		return shoesServiceImp.selectRand();
	}
}
