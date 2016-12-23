package edu.school.mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.school.mgmt.dao.UserRoleDao;
import edu.school.mgmt.model.UserRole;

@Transactional
@Service("roleService")
public class UserRoleServiceImpl implements UserRoleService {

	private UserRoleDao userRoleDao;
	
	@Autowired
	public void setUserRole(UserRoleDao userRoleDao){
		this.userRoleDao = userRoleDao;
	}
	
	@Override
	public void updateUserRole(UserRole userRole) {
		userRoleDao.update(userRole);
	}

	@Override
	public void createUserRole(UserRole userRole) {
		userRoleDao.create(userRole);
	}

	@Override
	public void deleteUserRole(UserRole userRole) {
		userRoleDao.delete(userRole);
	}

	@Override
	public List<UserRole> getAllUserRoles() {
		return userRoleDao.findAll();
	}

	@Override
	public UserRole getUserRoleServiceByRole(String role) {
		return userRoleDao.getUserRoleServiceByRole(role);
	}

}
