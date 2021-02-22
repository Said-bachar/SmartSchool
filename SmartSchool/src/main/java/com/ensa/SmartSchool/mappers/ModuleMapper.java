package com.ensa.SmartSchool.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.entity.Module;

@Component
public class ModuleMapper implements RowMapper<Module> {

	@Override
	public Module mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Module module = new Module();
		module.setModuleId(rs.getInt("module_id"));
		module.setModuleName(rs.getString("module_name"));
	    module.setLevelName(rs.getString("level_name"));
		return module;
	}

}