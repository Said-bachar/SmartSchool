package com.ensa.SmartSchool.entity;

import java.util.List;
import lombok.Data;

@Data
public class Level {

	private String levelName;
	private int levelId;
	List<Professor> professors;
	List<Module> modules;
}
