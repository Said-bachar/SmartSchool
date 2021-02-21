package com.ensa.SmartSchool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.dao.ProfessorDao;
import com.ensa.SmartSchool.entity.Professor;

@Component
public class ProfessorService {

	private ProfessorDao professorDao;

	@Autowired
	public ProfessorService(ProfessorDao professorDao) {
		super();
		this.professorDao = professorDao;
	}
	public List<Professor> getProfessors() {
		return this.professorDao.getProfessors();
	}

	public Professor getProfessor(String firstName,String lastName) {
		return this.professorDao.getProfessor(firstName,lastName);
	}

	public boolean create(Professor professor) {
		return professorDao.create(professor);
	}
	public boolean updateProfessorFirstName(Professor professor, String firstName) {
		return professorDao.updateProfessorFirstName(professor,firstName);
	}
	
	public boolean updateProfessorLastName(Professor professor, String lastName) {
		return professorDao.updateProfessorLastName(professor,lastName);
	}
	
	public boolean delete(Professor professor) {
		return professorDao.delete(professor);
	}


}
