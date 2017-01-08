package edu.school.mgmt.dao;

import java.util.List;

import org.joda.time.LocalDate;

import edu.school.mgmt.model.HomeworkAssignement;

public interface HomeworkAssignementDao extends GenericDao<Integer, HomeworkAssignement> {

	public List<HomeworkAssignement> getStudentHomeworks(int idStudent);

	public List<HomeworkAssignement> getTodayStudentHomeworks(int idStudent,LocalDate today);

	public List<HomeworkAssignement> getHomeworkAssignments(int idHomework);

	public HomeworkAssignement getHomeworkAssignmentofStudent(int idHomework,int idStudent);
	
}
