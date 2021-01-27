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
import com.ensa.SmartSchool.entity.Level;
import com.ensa.SmartSchool.entity.Module;
import com.ensa.SmartSchool.entity.Professor;
import com.ensa.SmartSchool.mappers.LevelMapper;
import com.ensa.SmartSchool.mappers.ModuleMapper;
import com.ensa.SmartSchool.mappers.ProfessorMapper;

@Component
public class LevelDao {
	
    JdbcTemplate jdbcTemplate;
    
    @Autowired
	private RestTemplate restTemplate;
	
	public List<Level> getLevels() {
		String LevelResourceUrl = "http://localhost:8081/level/getLevels";
		ResponseEntity<Level[]> response = restTemplate.getForEntity(LevelResourceUrl, Level[].class);
		Level[] levelsTab=response.getBody();
		List<Level> levels=Arrays.asList(levelsTab);
		return levels;
	}
	
	public List<Module> getModules(String levelname) {
		 String LevelResourceUrl = "http://localhost:8081/level/getModules/levelname="+levelname;
		 ResponseEntity<Module[]> response = restTemplate.getForEntity(LevelResourceUrl, Module[].class);
		 Module[] modulesTab=response.getBody();
		List<Module> modules=Arrays.asList(modulesTab);
		return modules;
		
	}
	
	public List<Professor> getProfessors(String levelname) {
		 String LevelResourceUrl = "http://localhost:8081/level/getProfessors/levelname="+levelname;
		 ResponseEntity<Professor[]> response = restTemplate.getForEntity(LevelResourceUrl, Professor[].class);
		 Professor[] professorsTab=response.getBody();
		List<Professor> professors=Arrays.asList(professorsTab);
		return professors;
		
	}
	
	public Level create(Level level) {
		 String LevelResourceUrl = "http://localhost:8081/level/create";
		 HttpEntity<Level> request = new HttpEntity<>(level);
		 return restTemplate.postForObject(LevelResourceUrl, request, Level.class);
	}
	
	public Level updateLevelName(Level level, String levelname) {
		String LevelResourceUrl = "http://localhost:8081/level/update/levelname="+levelname;
		HttpEntity<Level> request =new HttpEntity<>(level);
		return restTemplate.postForObject(LevelResourceUrl,request,Level.class);

	}
	
	public Level delete(Level level) {
		String LevelResourceUrl = "http://localhost:8081/level/delete";
		HttpEntity<Level> request = new HttpEntity<>(level);
		return restTemplate.postForObject(LevelResourceUrl, request, Level.class);
	}	
	
	public Level getLevel(String levelname) {
		 String LevelResourceUrl = "http://localhost:8081/level/getLevel/levelname="+levelname;
		 HttpEntity<String> request = new HttpEntity<>(levelname);
		 return restTemplate.postForObject(LevelResourceUrl, request, Level.class);
		
	}
	
}
	
	
	
	
	
	
	
	
	
	
	