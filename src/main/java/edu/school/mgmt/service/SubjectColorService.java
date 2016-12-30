package edu.school.mgmt.service;

import java.util.List;

import edu.school.mgmt.model.SubjectColor;

public interface SubjectColorService {

	public SubjectColor getBySubjectColorId(int key);
	
	public void updateSubjectColor(SubjectColor entity);
	
	public void createSubjectColor(SubjectColor entity);
	
	public void deleteSubjectColor(SubjectColor entity);
	
	public List<SubjectColor> getAllSubjectColors();
	
}
