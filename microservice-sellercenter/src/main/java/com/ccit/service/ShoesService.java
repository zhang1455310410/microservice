package com.ccit.service;

import com.ccit.pojo.Shoes;

import java.util.List;

;


public interface ShoesService {
	public List<Shoes> selectAll();
	
	public boolean addShoes(Shoes shoes);
	
	public boolean updateShoes(Shoes shoes);
	
	public boolean deleteShoes(Integer id);
	
	public Shoes getOneShoes(Integer id);
	
	public List<Shoes> selectRand();
	
}
