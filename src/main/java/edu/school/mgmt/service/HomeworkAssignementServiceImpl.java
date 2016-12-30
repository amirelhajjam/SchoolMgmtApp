package edu.school.mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.school.mgmt.dao.HomeworkAssignementDao;
import edu.school.mgmt.model.HomeworkAssignement;

@Transactional
@Service("homeworkAssignementService")
public class HomeworkAssignementServiceImpl implements HomeworkAssignementService {

	@Autowired
	HomeworkAssignementDao homeworkAssignementdao;

	@Override
	public HomeworkAssignement getByHomeworkAssignementId(int key) {
		return homeworkAssignementdao.getById(key);
	}

	@Override
	public void updateHomeworkAssignement(HomeworkAssignement entity) {
		homeworkAssignementdao.update(entity);
	}

	@Override
	public void createHomeworkAssignement(HomeworkAssignement entity) {
		homeworkAssignementdao.create(entity);
	}

	@Override
	public void deleteHomeworkAssignement(HomeworkAssignement entity) {
		homeworkAssignementdao.delete(entity);
	}

	@Override
	public List<HomeworkAssignement> getAllHomeworkAssignements() {
		return homeworkAssignementdao.findAll();
	}

	@Override
	public List<HomeworkAssignement> getStudentHomeworks(int idStudent) {
		return homeworkAssignementdao.getStudentHomeworks(idStudent);
	}
	
}
