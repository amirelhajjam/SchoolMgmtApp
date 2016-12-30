package edu.school.mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.school.mgmt.dao.SubjectColorDao;
import edu.school.mgmt.model.SubjectColor;

@Transactional
@Service("subjectColorService")
public class SubjectColorServiceImpl implements SubjectColorService {

	@Autowired
	SubjectColorDao subjectColorDao;

	@Override
	public SubjectColor getBySubjectColorId(int key) {
		return subjectColorDao.getById(key);
	}

	@Override
	public void updateSubjectColor(SubjectColor entity) {
		subjectColorDao.update(entity);
	}

	@Override
	public void createSubjectColor(SubjectColor entity) {
		subjectColorDao.create(entity);
	}

	@Override
	public void deleteSubjectColor(SubjectColor entity) {
		subjectColorDao.delete(entity);
	}

	@Override
	public List<SubjectColor> getAllSubjectColors() {
		return subjectColorDao.findAll();
	}
	

}
