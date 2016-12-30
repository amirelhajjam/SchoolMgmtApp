package edu.school.mgmt.dao;

import java.util.List;

import edu.school.mgmt.model.Homework;

public interface HomeworkDao extends GenericDao<Integer, Homework> {

	public List<Homework> getTeacherHomeworks(int idTeacher);
	
}
