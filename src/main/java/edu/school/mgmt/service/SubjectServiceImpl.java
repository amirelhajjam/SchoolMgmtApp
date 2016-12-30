package edu.school.mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.school.mgmt.dao.SubjectDao;
import edu.school.mgmt.model.Subject;

@Transactional
@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {

	private SubjectDao subjectDao;
	
	@Autowired	
	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}

	@Override
	public Subject getBySubjectId(int key) {
		return subjectDao.getById(key);
	}

	@Override
	public void updateSubject(Subject entity) {
		subjectDao.update(entity);
	}

	@Override
	public void createSubject(Subject entity) {
		subjectDao.create(entity);
	}

	@Override
	public void deleteSubject(Subject entity) {
		subjectDao.delete(entity);
	}

	@Override
	public List<Subject> getAllSubjects() {
		return subjectDao.findAll();
	}

	@Override
	public Subject getSubjectByTitle(String title) {
		return subjectDao.getSubjectByTitle(title);
	}

}
