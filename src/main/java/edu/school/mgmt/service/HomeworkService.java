package edu.school.mgmt.service;

import java.util.List;

import edu.school.mgmt.model.Homework;

public interface HomeworkService {

	public Homework getByHomeworkId(int key);
	
	public void updateHomework(Homework entity);
	
	public void createHomework(Homework entity);
	
	public void deleteHomework(Homework entity);
	
	public List<Homework> getAllHomeworks();
	
	public List<Homework> getTeacherHomeworks(int idTeacher);
}
