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
<<<<<<< HEAD
<<<<<<< HEAD
	public boolean create(Admin admin) {

		return adminDao.create(admin);
	}

=======
=======

>>>>>>> 84e10a6e6143963984a8c08ec3f4ad33979a5903
=======
>>>>>>> parent of fd1f4fc... some modifications
	public Admin create(Admin admin) {

		return adminDao.create(admin);
	}
	
<<<<<<< HEAD
<<<<<<< HEAD
=======

	
	
public Admin delete(Admin admin) {
		return adminDao.delete(admin);
	}

>>>>>>> 84e10a6e6143963984a8c08ec3f4ad33979a5903
=======
	public Admin delete(Admin admin) {
		return adminDao.delete(admin);
	}
    
>>>>>>> parent of fd1f4fc... some modifications
	public Admin updateUsername(Admin admin, String username) {

		return adminDao.updateUsername(admin, username);
	}
	
<<<<<<< HEAD
<<<<<<< HEAD
	public Admin delete(Admin admin) {
		return adminDao.delete(admin);
	}
>>>>>>> c10a2a4... Add restTemplate and connection to server
	
=======
>>>>>>> parent of fd1f4fc... some modifications
	public boolean updatePassword(Admin admin, String password) {
=======
	public Admin updatePassword(Admin admin, String password) {
>>>>>>> 84e10a6e6143963984a8c08ec3f4ad33979a5903

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