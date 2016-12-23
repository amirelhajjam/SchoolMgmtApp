package edu.school.mgmt.service;

import java.util.List;

import edu.school.mgmt.model.UserRole;

public interface UserRoleService {
	
	public void updateUserRole(UserRole userRole);
	
	public void createUserRole(UserRole userRole);
	
	public void deleteUserRole(UserRole userRole);
	
	public List<UserRole> getAllUserRoles();
	
	public UserRole getUserRoleServiceByRole(String role);

}
