package edu.school.mgmt.service;

import java.util.List;
import java.util.Set;

import edu.school.mgmt.model.ScheduleAssoc;
import edu.school.mgmt.model.Student;
import edu.school.mgmt.model.Subject;

public interface ScheduleAssocService {

	public ScheduleAssoc getByScheduleAssocId(int key);
	
	public void updateScheduleAssoc(ScheduleAssoc entity);
	
	public void createScheduleAssoc(ScheduleAssoc entity);
	
	public void deleteScheduleAssoc(ScheduleAssoc entity);
	
	public List<ScheduleAssoc> getAllScheduleAssocs();
	
	public List<ScheduleAssoc> getStudentSchedule(int idStudent);
	
	public List<ScheduleAssoc> getTeacherSchedule(int idTeacher);
	
	public Set<Student> getStudents(int idTeacher,int idSubject);
	
	public Set<Subject> getTeacherSubjects(int idTeacher);
	
	public ScheduleAssoc getStudentSubjectColor(int idTeacher, int idStudent, int idSubject);
}
