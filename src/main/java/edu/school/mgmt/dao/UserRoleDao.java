package edu.school.mgmt.dao;

import edu.school.mgmt.model.UserRole;

public interface UserRoleDao extends GenericDao<Integer, UserRole> {

	public UserRole getUserRoleServiceByRole(String role);
	
}
