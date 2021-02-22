package com.ensa.SmartSchool.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.entity.Module;
import com.ensa.SmartSchool.mappers.ModuleMapper;

@Component
public class ModuleDao {
	
JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ModuleDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate; 
		}
	public List<Module> getModules() {
		
		return jdbcTemplate.query("select * from module", new ModuleMapper());
	}
	
	public Module getModule(String name) {
		
		return jdbcTemplate.queryForObject("select * from module where module_name=? ",new ModuleMapper(),name);	
	}
	
	public boolean create(Module module) {
		String sql="INSERT INTO module (module_name,level_name) VALUES (?,?)";
		jdbcTemplate.update(sql,module.getModuleName(),module.getLevelName());
		return true;	
	}
	public boolean updateModuleName(Module module,String name) {
		String sql="UPDATE MODULE SET MODULE_NAME=? WHERE MODULE_ID=?";
		jdbcTemplate.update(sql,name,module.getModuleId());
		return true;
	}
	
	public boolean delete(Module module) {
		String sql="DELETE FROM MODULE WHERE MODULE_ID=?";
		jdbcTemplate.update(sql,module.getModuleId());
		return true;
	}
	
}
	
