package edu.school.mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.school.mgmt.dao.UserDao;
import edu.school.mgmt.model.Teacher;
import edu.school.mgmt.model.User;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public User getUserById(int key) {
		return userDao.getById(key);
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}

	@Override
	public void createUser(User user) {
		userDao.create(user);
	}

	@Override
	public void deleteUser(User user) {
		userDao.delete(user);
	}

	@Override
	public List<User> getAllUser() {		
		return userDao.findAll();
	}

	@Override
	public User getUserByLogin(String login) {
		return userDao.getUserByLogin(login);
	}

	@Override
	public List<Teacher> getTeachers() {
		return userDao.getTeachers();
	}


}
