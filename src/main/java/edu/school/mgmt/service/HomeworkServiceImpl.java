package edu.school.mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.school.mgmt.dao.HomeworkDao;
import edu.school.mgmt.model.Homework;

@Transactional
@Service("homeworkService")
public class HomeworkServiceImpl implements HomeworkService {

	@Autowired
	HomeworkDao homeworkDao;
	
	@Override
	public Homework getByHomeworkId(int key) {
		return homeworkDao.getById(key);
	}

	@Override
	public void updateHomework(Homework entity) {
		homeworkDao.update(entity);
	}

	@Override
	public void createHomework(Homework entity) {
		homeworkDao.create(entity);
	}

	@Override
	public void deleteHomework(Homework entity) {
		homeworkDao.delete(entity);
	}

	@Override
	public List<Homework> getAllHomeworks() {
		return homeworkDao.findAll();
	}

	@Override
	public List<Homework> getTeacherHomeworks(int idTeacher) {
		return homeworkDao.getTeacherHomeworks(idTeacher);
	}

}
