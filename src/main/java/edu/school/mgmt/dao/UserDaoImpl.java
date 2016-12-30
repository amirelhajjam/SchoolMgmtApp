package edu.school.mgmt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import edu.school.mgmt.model.Teacher;
import edu.school.mgmt.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	@Override
	public User getUserByLogin(String login) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("login", login));
        return (User) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> getTeachers() {
		Criteria criteria = createEntityCriteria();
		criteria.add( Restrictions.and( Property.forName("class").eq(Teacher.class) ) );
        return (List<Teacher>) criteria.list();
	}
	
}
