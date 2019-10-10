package com.ccit.service;

import com.ccit.pojo.Admin;
import org.springframework.stereotype.Service;

import java.util.List;



public interface AdminService {
	public Admin checkAdmin(Admin admin);
	public boolean register(Admin admin);
	
	public Admin selectByAdmin(Admin admin);
	
	public List<Admin> selectAll();
	
	public boolean updateUser(Admin admin);
	
	
	
	public Admin getAdmin(Admin admin);
	public boolean deleteUser(Integer id);
}
