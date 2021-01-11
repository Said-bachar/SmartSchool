package com.ensa.SmartSchool.entity;

import java.util.List;
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
	List<Professor> professors;
	List<Module> modules;
}
