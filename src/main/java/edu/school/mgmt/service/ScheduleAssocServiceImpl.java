package edu.school.mgmt.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.school.mgmt.dao.ScheduleAssocDao;
import edu.school.mgmt.model.ScheduleAssoc;
import edu.school.mgmt.model.Student;
import edu.school.mgmt.model.Subject;

@Service
@Transactional
public class ScheduleAssocServiceImpl implements ScheduleAssocService {

	@Autowired
	ScheduleAssocDao scheduleAssocDao;
	
	@Override
	public void updateScheduleAssoc(ScheduleAssoc entity) {
		scheduleAssocDao.update(entity);
	}

	@Override
	public void createScheduleAssoc(ScheduleAssoc entity) {
		scheduleAssocDao.create(entity);
	}

	@Override
	public List<ScheduleAssoc> getAllScheduleAssocs() {
		return scheduleAssocDao.findAll();
	}

	@Override
	public List<ScheduleAssoc> getStudentSchedule(int idStudent) {
		return scheduleAssocDao.getStudentSchedule(idStudent);
	}

	@Override
	public List<ScheduleAssoc> getTeacherSchedule(int idTeacher) {
		return scheduleAssocDao.getTeacherSchedule(idTeacher);
	}

	@Override
	public Set<Student> getStudents(int idTeacher, int idSubject) {
		
		List<ScheduleAssoc> schedule = getAllScheduleAssocs();
		Set<Student> students = new HashSet<Student>();		
		
		for(ScheduleAssoc a : schedule){		
			if(a.getTeacher().getIdUser()==idTeacher && a.getSubject().getIdSubject()==idSubject){
				students.add(a.getStudent());
			}			
		}
		
		return students;
	}
	
	@Override
	public Set<Subject> getTeacherSubjects(int idTeacher) {
		
		List<ScheduleAssoc> schedule = getAllScheduleAssocs();
		Set<Subject> subjects = new HashSet<Subject>();		
		
		for(ScheduleAssoc a : schedule){		
			if(a.getTeacher().getIdUser()==idTeacher){
				subjects.add(a.getSubject());
			}			
		}		
		return subjects;
	}

	@Override
	public ScheduleAssoc getByScheduleAssocId(int key) {
		return scheduleAssocDao.getById(key);
	}

	@Override
	public void deleteScheduleAssoc(ScheduleAssoc entity) {
		scheduleAssocDao.delete(entity);
	}

	@Override
	public ScheduleAssoc getStudentSubjectColor(int idTeacher, int idStudent, int idSubject) {
		return scheduleAssocDao.getStudentSubjectColor(idTeacher, idStudent, idSubject);
	}

}
