package edu.school.mgmt.service;

import java.util.List;

import org.joda.time.LocalDate;

import edu.school.mgmt.model.HomeworkAssignement;

public interface HomeworkAssignementService {

	public HomeworkAssignement getByHomeworkAssignementId(int key);
	
	public void updateHomeworkAssignement(HomeworkAssignement entity);
	
	public void createHomeworkAssignement(HomeworkAssignement entity);
	
	public void deleteHomeworkAssignement(HomeworkAssignement entity);
	
	public List<HomeworkAssignement> getAllHomeworkAssignements();	
	
	public List<HomeworkAssignement> getStudentHomeworks(int idStudent);
	
	public List<HomeworkAssignement> getTodayStudentHomeworks(int idStudent,LocalDate today);
	
	public List<HomeworkAssignement> getHomeworkAssignments(int idHomework);
	
	public HomeworkAssignement getHomeworkAssignmentofStudent(int idHomework,int idStudent);
	
}
