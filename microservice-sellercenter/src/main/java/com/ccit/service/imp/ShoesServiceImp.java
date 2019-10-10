package com.ccit.service.imp;

import com.ccit.dao.ShoesMapper;
import com.ccit.pojo.Shoes;
import com.ccit.service.ShoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShoesServiceImp implements ShoesService {
	
	@Autowired
	private ShoesMapper shoesMapper;
	@Override
	public List<Shoes> selectAll() {
		// TODO Auto-generated method stub
		return shoesMapper.selectAll();
	}

	@Override
	public boolean addShoes(Shoes shoes) {
		if(shoes!=null) {
			shoesMapper.insertSelective(shoes);
			return true;
		}
			
		return false;
	}

	@Override
	public boolean updateShoes(Shoes shoes) {
		if(shoes.getId()!=null) {
			shoesMapper.updateByPrimaryKeySelective(shoes);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteShoes(Integer id) {
		if(id!=null) {
			shoesMapper.deleteByPrimaryKey(id);
			return true;
		}
		return false;
	}

	@Override
	public Shoes getOneShoes(Integer id) {
		// TODO Auto-generated method stub
		return shoesMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Shoes> selectRand() {
		// TODO Auto-generated method stub
		return shoesMapper.selectRand();
	}

}
