package com.ensa.SmartSchool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.dao.LevelDao;
import com.ensa.SmartSchool.entity.Level;
import com.ensa.SmartSchool.entity.Professor;
import com.ensa.SmartSchool.entity.Module;

@Component
public class LevelService {

	private LevelDao levelDao;
@Autowired
	public LevelService(LevelDao levelDao) {
		super();
		this.levelDao = levelDao;
	}

	public List<Level> getLevels() {
		return this.levelDao.getLevels();
	}
	public List<Module> getModules(String levelName) {
		return this.levelDao.getModules(levelName);
	}
	
	public List<Professor> getProfessors(String levelName) {
		return this.levelDao.getProfessors(levelName);
	}

	public Level getLevel(String name) {
		return this.levelDao.getLevel(name);
	}
	public Level create(Level level) {
		return levelDao.create(level);
	}

	public Level updateLevelName(Level level, String name) {
		return levelDao.updateLevelName(level,name);
	}
	
	public Level delete(Level level) {
		return levelDao.delete(level);
	}


}