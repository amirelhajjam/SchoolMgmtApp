package edu.school.mgmt.dao;

import edu.school.mgmt.model.User;

public interface UserDao extends GenericDao<Integer, User> {

	public User getUserByLogin(String login);
	
}
