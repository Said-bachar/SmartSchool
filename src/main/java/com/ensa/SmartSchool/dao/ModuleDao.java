package com.ensa.SmartSchool.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ensa.SmartSchool.entity.Module;
import com.ensa.SmartSchool.mappers.ModuleMapper;

@Component
public class ModuleDao {
	

	@Autowired
	private RestTemplate restTemplate;
		
		public List<Module> getModules() {
			
			String ModuleResourceUrl = "http://localhost:8081/module/getModules";
			ResponseEntity<Module[]> response = restTemplate.getForEntity(ModuleResourceUrl, Module[].class);
			Module[] modulesTab=response.getBody();
			List<Module> modules=Arrays.asList(modulesTab);
			return modules;
		}
		
		public Module getModuleByName(String moduleName) {
			
			 String ModuleResourceUrl = "http://localhost:8081/module/getModule/moduleName="+moduleName;
			 HttpEntity<String> request = new HttpEntity<>(moduleName);
			 return restTemplate.postForObject(ModuleResourceUrl, request, Module.class);	
		}
		
		public Module create(Module module) {
			 String ModuleResourceUrl= "http://localhost:8081/module/create";
			 HttpEntity<Module> request = new HttpEntity<>(module);
			 return restTemplate.postForObject(ModuleResourceUrl, request, Module.class);
		}
		public Module updateModuleName(Module module,String moduleName) {
			 String ModuleResourceUrl = "http://localhost:8081/module/update/moduleName="+moduleName;
			 HttpEntity<Module> request = new HttpEntity<>(module);
			 return restTemplate.postForObject(ModuleResourceUrl, request, Module.class);
		}
		
		public Module delete(Module module) {
			String AdminResourceUrl = "http://localhost:8081/module/delete";
			HttpEntity<Module> request = new HttpEntity<>(module);
			return restTemplate.postForObject(AdminResourceUrl, request, Module.class);
		}
		
	}

	
