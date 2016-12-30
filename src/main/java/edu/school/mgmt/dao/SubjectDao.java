package edu.school.mgmt.dao;

import edu.school.mgmt.model.Subject;

public interface SubjectDao extends GenericDao<Integer, Subject> {

	 public Subject getSubjectByTitle(String title);
	
}
