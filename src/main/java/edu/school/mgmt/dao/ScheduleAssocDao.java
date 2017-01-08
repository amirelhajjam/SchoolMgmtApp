package edu.school.mgmt.dao;

import java.util.List;

import edu.school.mgmt.model.ScheduleAssoc;

public interface ScheduleAssocDao extends GenericDao<Integer, ScheduleAssoc> {

	public List<ScheduleAssoc> getStudentSchedule(int idStudent);
	
	public List<ScheduleAssoc> getTeacherSchedule(int idTeacher);

	public ScheduleAssoc getStudentSubjectColor(int idTeacher, int idStudent, int idSubject);
	
}
