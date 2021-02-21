package com.ensa.SmartSchool.dao;


<<<<<<< HEAD
<<<<<<< HEAD
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
=======
import java.util.Arrays;
import java.util.HashMap;
=======

>>>>>>> 84e10a6e6143963984a8c08ec3f4ad33979a5903
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import org.springframework.http.HttpEntity;
<<<<<<< HEAD
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
>>>>>>> c10a2a4... Add restTemplate and connection to server

=======


import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
>>>>>>> 84e10a6e6143963984a8c08ec3f4ad33979a5903
import com.ensa.SmartSchool.entity.Admin;

<<<<<<< HEAD
@Component
public class AdminDao {

<<<<<<< HEAD
JdbcTemplate jdbcTemplate;
	
=======

@Component
public class AdminDao {


	@Autowired
	private RestTemplate restTemplate;

	JdbcTemplate jdbcTemplate;
>>>>>>> c10a2a4... Add restTemplate and connection to server
	@Autowired
	public AdminDao(JdbcTemplate jdbcTemplate) {
		
		this.jdbcTemplate = jdbcTemplate;
	}


	
	public List<Admin> getAdmins() {
<<<<<<< HEAD
			
		return jdbcTemplate.query("select * from ADMIN", new AdminMapper());
	}
	
	public Admin getAdmin(String username) {
		String sql = "SELECT * FROM ADMIN WHERE USERNAME=?";
		return jdbcTemplate.queryForObject(sql, new AdminMapper(),username);
		
		
	}
	public boolean create(Admin admin) {
		String sql="INSERT INTO ADMIN(username,password)VALUES (?,?)";
		jdbcTemplate.update(sql,admin.getUsername(),admin.getPassword());
		return true;
		
	}
	
	public boolean updateUsername(Admin admin, String username) {
		String sql="UPDATE Admin SET Username=? WHERE Username=?";
		jdbcTemplate.update(sql,username,admin.getUsername());
		return true;

=======
=======
    @Autowired
    private RestTemplate restTemplate;
    
    public List<Admin> getAdmins() {
>>>>>>> 84e10a6e6143963984a8c08ec3f4ad33979a5903
		String AdminResourceUrl = "http://localhost:8081/admin/getAdmins";
		ResponseEntity<Admin[]> response = restTemplate.getForEntity(AdminResourceUrl, Admin[].class);
		Admin[] adminsTab=response.getBody();
		List<Admin> admins=Arrays.asList(adminsTab);
		return admins;
	}
	
	public Admin getAdmin(String username) {
		 String AdminResourceUrl = "http://localhost:8081/admin/getAdmin/username="+username;
		 HttpEntity<String> request = new HttpEntity<>(username);
		 return restTemplate.postForObject(AdminResourceUrl, request, Admin.class);
		
	}
<<<<<<< HEAD
=======

	
>>>>>>> 84e10a6e6143963984a8c08ec3f4ad33979a5903
	
	public Admin create(Admin admin) {
		 String AdminResourceUrl = "http://localhost:8081/admin/create";
		 HttpEntity<Admin> request = new HttpEntity<>(admin);
		 return restTemplate.postForObject(AdminResourceUrl, request, Admin.class);
<<<<<<< HEAD
=======
		

>>>>>>> 84e10a6e6143963984a8c08ec3f4ad33979a5903
	}
	
	public Admin updateUsername(Admin admin, String username) {
		String AdminResourceUrl = "http://localhost:8081/admin/updateUsername/username="+username;
		System.out.println(username);
		HttpEntity<Admin> request =new HttpEntity<>(admin);
		return restTemplate.postForObject(AdminResourceUrl,request,Admin.class);
>>>>>>> c10a2a4... Add restTemplate and connection to server
	}
	
	public Admin updatePassword(Admin admin, String password) {
		String AdminResourceUrl = "http://localhost:8081/admin/updateUsername/password="+password;
		System.out.println(password);
		HttpEntity<Admin> request =new HttpEntity<>(admin);
		return restTemplate.postForObject(AdminResourceUrl,request,Admin.class);

	}
<<<<<<< HEAD
<<<<<<< HEAD
	public boolean delete(Admin admin) {
		String sql="DELETE FROM ADMIN WHERE Username=?";
		jdbcTemplate.update(sql,admin.getUsername());
		return true;
=======
=======
	
>>>>>>> 84e10a6e6143963984a8c08ec3f4ad33979a5903
	public Admin delete(Admin admin) {
		String AdminResourceUrl = "http://localhost:8081/admin/delete";
		HttpEntity<Admin> request = new HttpEntity<>(admin);
		return restTemplate.postForObject(AdminResourceUrl, request, Admin.class);
<<<<<<< HEAD
>>>>>>> c10a2a4... Add restTemplate and connection to server
	}
	
=======

	}	

>>>>>>> 84e10a6e6143963984a8c08ec3f4ad33979a5903
}


