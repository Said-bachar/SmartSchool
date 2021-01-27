package com.ensa.SmartSchool.dao;


<<<<<<< HEAD
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import org.springframework.http.HttpEntity;
=======

import java.util.Arrays;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
>>>>>>> 100d7219ad1c7b1e87f7dd69a2158a45ee48a15a
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
<<<<<<< HEAD

import com.ensa.SmartSchool.entity.Admin;

=======



import com.ensa.SmartSchool.entity.Admin;
import com.ensa.SmartSchool.mappers.AdminMapper;




>>>>>>> 100d7219ad1c7b1e87f7dd69a2158a45ee48a15a

@Component
public class AdminDao {



<<<<<<< HEAD
	JdbcTemplate jdbcTemplate;
	@Autowired
	public AdminDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	
	public List<Admin> getAdmins() {
=======
    @Autowired
    private RestTemplate restTemplate;
    
    public List<Admin> getAdmins() {
			

>>>>>>> 100d7219ad1c7b1e87f7dd69a2158a45ee48a15a
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

	
	
	public Admin create(Admin admin) {
		String AdminResourceUrl = "http://localhost:8081/admin/create";
		 HttpEntity<Admin> request = new HttpEntity<>(admin);
		 return restTemplate.postForObject(AdminResourceUrl, request, Admin.class);
		

	}
	
	public Admin updateUsername(Admin admin, String username) {
		String AdminResourceUrl = "http://localhost:8081/admin/updateUsername/username="+username;
		System.out.println(username);
		HttpEntity<Admin> request =new HttpEntity<>(admin);
		return restTemplate.postForObject(AdminResourceUrl,request,Admin.class);

	}
<<<<<<< HEAD
	
	public Admin updatePassword(Admin admin, String password) {
		String AdminResourceUrl = "http://localhost:8081/admin/updateUsername/password="+password;
		System.out.println(password);
		HttpEntity<Admin> request =new HttpEntity<>(admin);
		return restTemplate.postForObject(AdminResourceUrl,request,Admin.class);

	}
	
=======
	public Admin updatePassword(Admin admin,String password) {
		String AdminResourceUrl = "http://localhost:8081/admin/updatePassword/password="+password;
		
		HttpEntity<Admin> request =new HttpEntity<>(admin);
		return restTemplate.postForObject(AdminResourceUrl,request,Admin.class);
	}

>>>>>>> 100d7219ad1c7b1e87f7dd69a2158a45ee48a15a
	public Admin delete(Admin admin) {
		String AdminResourceUrl = "http://localhost:8081/admin/delete";
		HttpEntity<Admin> request = new HttpEntity<>(admin);
		return restTemplate.postForObject(AdminResourceUrl, request, Admin.class);
<<<<<<< HEAD
	}	
=======

	}
	
>>>>>>> 100d7219ad1c7b1e87f7dd69a2158a45ee48a15a
}


