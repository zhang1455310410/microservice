package com.ccit.service.imp;

import java.util.List;

import com.ccit.dao.AdminMapper;
import com.ccit.pojo.Admin;
import com.ccit.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImp implements AdminService {
	@Autowired
	private AdminMapper adminMapper;
	@Override
	public Admin checkAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminMapper.checkAdmin(admin);
	}

	@Override
	public boolean register(Admin admin) {
		if(admin!=null) {
			 adminMapper.insert(admin);
			 return true;
		}
		return false;
	}

	@Override
	public Admin selectByAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminMapper.selectByAdmin(admin);
	}

	@Override
	public List<Admin> selectAll() {
		// TODO Auto-generated method stub
		return adminMapper.selectAll();
	}

	@Override
	public boolean updateUser(Admin admin) {
		// TODO Auto-generated method stub
		if(admin!=null) {
			adminMapper.updateByPrimaryKey(admin);
			return true;
		}
		return false;
	}

	@Override
	public Admin getAdmin(Admin admin) {
		// TODO Auto-generated method stub
	
		return adminMapper.selectByAdmin(admin);
	}

	@Override
	public boolean deleteUser(Integer id) {
		if(id!=null) {
			adminMapper.deleteByPrimaryKey(id);
			return true;
		}
		return false;
	}

}
