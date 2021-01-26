package com.ensa.SmartSchool.dao;



import java.util.Arrays;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;



import com.ensa.SmartSchool.entity.Admin;
import com.ensa.SmartSchool.mappers.AdminMapper;





@Component
public class AdminDao {



    @Autowired
    private RestTemplate restTemplate;
    
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
	public Admin updatePassword(Admin admin,String password) {
		String AdminResourceUrl = "http://localhost:8081/admin/updatePassword/password="+password;
		
		HttpEntity<Admin> request =new HttpEntity<>(admin);
		return restTemplate.postForObject(AdminResourceUrl,request,Admin.class);
	}

	public Admin delete(Admin admin) {
		String AdminResourceUrl = "http://localhost:8081/admin/delete";
		HttpEntity<Admin> request = new HttpEntity<>(admin);
		return restTemplate.postForObject(AdminResourceUrl, request, Admin.class);

	}
	
}


