package edu.school.mgmt.dao;

import java.util.List;

import edu.school.mgmt.model.HomeworkAssignement;

public interface HomeworkAssignementDao extends GenericDao<Integer, HomeworkAssignement> {

	public List<HomeworkAssignement> getStudentHomeworks(int idStudent);
	
}
