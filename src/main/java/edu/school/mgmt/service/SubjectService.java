package edu.school.mgmt.service;

import java.util.List;

import edu.school.mgmt.model.Subject;

public interface SubjectService {

	public Subject getBySubjectId(int key);
	
	public void updateSubject(Subject entity);
	
	public void createSubject(Subject entity);
	
	public void deleteSubject(Subject entity);
	
	public List<Subject> getAllSubjects();
	
	public Subject getSubjectByTitle(String title);
	
}
