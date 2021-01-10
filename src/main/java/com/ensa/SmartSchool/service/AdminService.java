package com.ensa.SmartSchool.service;

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
	public Admin getAdmin () {
		return this.adminDao.getAdmin();
	}
}
