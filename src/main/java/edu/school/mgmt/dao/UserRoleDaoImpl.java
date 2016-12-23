package edu.school.mgmt.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import edu.school.mgmt.model.UserRole;

@Repository("userRoleDao")
public class UserRoleDaoImpl extends AbstractDao<Integer, UserRole> implements UserRoleDao {

	@Override
	public UserRole getUserRoleServiceByRole(String role) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("role", role));
		return (UserRole)  criteria.uniqueResult();
	}

}
