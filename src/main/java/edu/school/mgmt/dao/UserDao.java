package edu.school.mgmt.dao;

import java.util.List;

import edu.school.mgmt.model.Teacher;
import edu.school.mgmt.model.User;

public interface UserDao extends GenericDao<Integer, User> {

	public User getUserByLogin(String login);
	public List<Teacher> getTeachers();
}
