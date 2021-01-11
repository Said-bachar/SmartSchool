package com.ensa.SmartSchool.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ensa.SmartSchool.dao.AdminDao;
import com.ensa.SmartSchool.entity.Admin;


@Component
public class AdminService {

	private AdminDao adminDao;

	@Autowired
	public AdminService(AdminDao adminDao) {
		super();
		this.adminDao = adminDao;
	}

	public List<Admin> getAdmins() {

		return this.adminDao.getAdmins();
	}
public Admin getAdmin(String username) {
		return this.adminDao.getAdmin(username);
	}

	public boolean create(Admin admin) {

		return adminDao.create(admin);
	}

	
	public boolean updatePassword(Admin admin, String password) {

		return adminDao.updatePassword(admin, password);
	}

}