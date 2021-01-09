package com.ensa.SmartSchool.entity;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Level {

	private String levelName;
	private int levelId;
	Map<Professor, Module> professorModules;
}
