package com.ensa.SmartSchool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.dao.ModuleDao;
import com.ensa.SmartSchool.entity.Module;

@Component
public class ModuleService {

	private ModuleDao moduleDao;

	@Autowired
	public ModuleService(ModuleDao moduleDao) {
		super();
		this.moduleDao = moduleDao;
	}
	public List<Module> getModules() {

		return this.moduleDao.getModules();
	}

	public Module getModule(String name) {
		return this.moduleDao.getModule(name);
	}

	public boolean create(Module module) {

		return moduleDao.create(module);
	}

	public boolean updateModuleName(Module module, String name) {
		return moduleDao.updateModuleName(module,name);
	}
	
	public boolean delete(Module module) {
		return moduleDao.delete(module);
	}


}