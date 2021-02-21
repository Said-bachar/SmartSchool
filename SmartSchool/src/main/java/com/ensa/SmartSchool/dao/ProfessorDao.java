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
import com.ensa.SmartSchool.entity.Professor;
import com.ensa.SmartSchool.mappers.ProfessorMapper;

@Component
public class ProfessorDao {
	
JdbcTemplate jdbcTemplate;

    @Autowired
    private RestTemplate restTemplate;
	
	@Autowired
	public ProfessorDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Professor> getProfessors() {
		
		String ProfessorResourceUrl = "http://localhost:8081/professor/getProfessors";
		ResponseEntity<Professor[]> response = restTemplate.getForEntity(ProfessorResourceUrl, Professor[].class);
		Professor[] professorsTab=response.getBody();
		List<Professor> professors=Arrays.asList(professorsTab);
		return professors;
	}
	
	public Professor getProfessorByFirstName(String firstName) {
		String ProfessorResourceUrl = "http://localhost:8081/professor/getProfessorByFirstName/firstname="+ firstName;
		 HttpEntity<String> request = new HttpEntity<>(firstName);
		 return restTemplate.postForObject(ProfessorResourceUrl, request, Professor.class);
	}
	
	public Professor getProfessorByLastName(String lastName) {
		String ProfessorResourceUrl = "http://localhost:8081/professor/getProfessorByLastName/lastname="+ lastName;
		 HttpEntity<String> request = new HttpEntity<>(lastName);
		 return restTemplate.postForObject(ProfessorResourceUrl, request, Professor.class);
	}
	
    public Professor updateProfessorFirstName(Professor professor,String firstName) {
	   String ProfessorResourceUrl = "http://localhost:8081/professor/updateProfessorFirstName/firstname=" + firstName;
	   System.out.println(firstName);
	   HttpEntity<Professor> request =new HttpEntity<>(professor);
	   return restTemplate.postForObject(ProfessorResourceUrl,request,Professor.class);
	}
	
	public Professor updateProfessorLastName(Professor professor,String lastName) {
		    String ProfessorResourceUrl = "http://localhost:8081/professor/updateProfessorLastName/lastname=" + lastName;
		   System.out.println(lastName);
		   HttpEntity<Professor> request =new HttpEntity<>(professor);
		   return restTemplate.postForObject(ProfessorResourceUrl,request,Professor.class);  
	}
	public Professor delete(Professor professor) {
		String ProfessorResourceUrl = "http://localhost:8081/professor/delete";
		HttpEntity<Professor> request = new HttpEntity<>(professor);
		return restTemplate.postForObject(ProfessorResourceUrl, request, Professor.class);
	}
	public Professor create(Professor professor) {
		String ProfessorResourceUrl = "http://localhost:8081/professor/create";
		 HttpEntity<Professor> request = new HttpEntity<>(professor);
		 return restTemplate.postForObject(ProfessorResourceUrl, request, Professor.class);
	}
}
	
