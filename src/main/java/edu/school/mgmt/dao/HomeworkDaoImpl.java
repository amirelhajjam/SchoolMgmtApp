package edu.school.mgmt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import edu.school.mgmt.model.Homework;

@Repository("homworkDao")
public class HomeworkDaoImpl extends AbstractDao<Integer, Homework> implements HomeworkDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Homework> getTeacherHomeworks(int idTeacher) {
		Criteria criteria = createEntityCriteria();
		criteria.createAlias("teacher", "t");
		criteria.add(Restrictions.eq("t.idUser", idTeacher));
		criteria.addOrder(Order.desc("dueDate"));
		return (List<Homework>) criteria.list();
	}
	
}
