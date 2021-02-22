package com.ensa.SmartSchool.dao;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ensa.SmartSchool.entity.Admin;
import com.ensa.SmartSchool.mappers.AdminMapper;

@Component
public class AdminDao {

JdbcTemplate jdbcTemplate;
	
    @Autowired
    private RestTemplate restTemplate;
    
	@Autowired
	public AdminDao(JdbcTemplate jdbcTemplate) {
		
		this.jdbcTemplate = jdbcTemplate;
	}


	
	public List<Admin> getAdmins() {
			
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
	public boolean updatePassword(Admin admin,String password) {
		String sql="UPDATE ADMIN SET PASSWORD=? WHERE username=?";
		jdbcTemplate.update(sql,password,admin.getUsername());
		return true;
	}
	public Admin delete(Admin admin) {
		String AdminResourceUrl = "http://localhost:8081/admin/delete";
		HttpEntity<Admin> request = new HttpEntity<>(admin);
		return restTemplate.postForObject(AdminResourceUrl, request, Admin.class);
	}
	
}


