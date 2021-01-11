package com.ensa.SmartSchool.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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
	public LevelDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List<Level> getLevels() {	
		return jdbcTemplate.query("select * from level", new LevelMapper());
	}
	
	public List<Module> getModules(String levelName){
		return jdbcTemplate.query("select * from module,level where module.level_name=level.level_name and level.level_name=?", new ModuleMapper(),levelName);
	}
	public List<Professor> getProfessors(String levelName){
		return jdbcTemplate.query("select * from professor,level where professor.level_name=level.level_name and level.level_name=?", new ProfessorMapper(),levelName);
	}
	public boolean create(Level level) {
		String sql="INSERT INTO level (level_name) VALUES (?)";
		jdbcTemplate.update(sql,level.getLevelName());
		return true;	
	}
	
	public boolean updateLevelName(Level level,String name) {
		String sql="UPDATE level SET LEVEL_NAME=? WHERE LEVEL_ID=?";
		jdbcTemplate.update(sql,name,level.getLevelId());
		return true;
	}
	public boolean delete(Level level) {
		String sql="DELETE FROM LEVEL WHERE LEVEL_ID=?";
		jdbcTemplate.update(sql,level.getLevelId());
		return true;
	}
	public Level getLevel(String name) {
			
			return jdbcTemplate.queryForObject("select * from level where level_name=? ",new LevelMapper(),name);	
		}
	
}
	
	
	
	
	
	
	
	
	
	
	