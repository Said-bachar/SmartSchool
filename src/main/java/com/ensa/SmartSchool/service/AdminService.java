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

<<<<<<< HEAD
=======

>>>>>>> 100d7219ad1c7b1e87f7dd69a2158a45ee48a15a
	public Admin create(Admin admin) {

		return adminDao.create(admin);
	}
	

	
	
public Admin delete(Admin admin) {
		return adminDao.delete(admin);
	}
<<<<<<< HEAD
=======
    
	public Admin updateUsername(Admin admin, String username) {

		return adminDao.updateUsername(admin, username);
	}
>>>>>>> 100d7219ad1c7b1e87f7dd69a2158a45ee48a15a
	
	public Admin updatePassword(Admin admin, String password) {

		return adminDao.updatePassword(admin, password);
	}
   
    public boolean authenticate(String username, String password) {
		
		
		Admin admin = adminDao.getAdmin(username);
		if(admin.equals(null)) {
			return false;
		}
		return admin.getPassword().equals(password) ;
	}
}