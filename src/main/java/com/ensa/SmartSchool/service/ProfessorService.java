package com.ensa.SmartSchool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ensa.SmartSchool.dao.ProfessorDao;
import com.ensa.SmartSchool.entity.Professor;
import com.ensa.SmartSchool.entity.Student;

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
	
<<<<<<< HEAD
	public boolean delete(Professor professor) {
=======
	public Professor updatePassword(Professor professor, String password) {
		return professorDao.updatePassword(professor,password);
	}
	
	public Professor delete(Professor professor) {
>>>>>>> 84e10a6e6143963984a8c08ec3f4ad33979a5903
		return professorDao.delete(professor);
	}

	public boolean authenticate(String lastName, String password) {
		Professor professor = professorDao.getProfessorByLastName( lastName);
		if(professor.equals(null)) {
			return false;
		}
		return professor.getPassword().equals(password) ;
	}

}
