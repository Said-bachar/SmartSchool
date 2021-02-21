package com.ensa.SmartSchool.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.entity.Level;

@Component
public class LevelMapper implements RowMapper<Level> {

	@Override
	public Level mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Level level = new Level();
		level.setLevelId(rs.getInt("level_id"));
		level.setLevelName(rs.getString("level_name"));
		return level;
	}

}