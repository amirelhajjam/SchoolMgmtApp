package edu.school.mgmt.service;

import java.util.List;

import edu.school.mgmt.model.User;

public interface UserService {
	
	public User getUserById(int key);
	
	public void updateUser(User user);
	
	public void createUser(User user);
	
	public void deleteUser(User user);
	
	public List<User> getAllUser();

	public User getUserByLogin(String login);
	
}
