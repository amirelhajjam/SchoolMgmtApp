package edu.school.mgmt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Repository;

import edu.school.mgmt.model.HomeworkAssignement;
import edu.school.mgmt.model.ScheduleAssoc;

@Repository("homeworkAssignementDao")
public class HomeworkAssignementDaoImpl extends AbstractDao<Integer, HomeworkAssignement> implements HomeworkAssignementDao {

	
	@SuppressWarnings("unchecked")
	@Override
	public List<HomeworkAssignement> getStudentHomeworks(int idStudent) {
		Criteria criteria = createEntityCriteria();
		criteria.createAlias("student", "t");
		criteria.createAlias("homework", "h");
		criteria.add(Restrictions.eq("t.idUser", idStudent));
		criteria.addOrder(Order.desc("h.dueDate"));
		return (List<HomeworkAssignement>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HomeworkAssignement> getHomeworkAssignments(int idHomework) {
		Criteria criteria = createEntityCriteria();
		criteria.createAlias("homework", "t");
		criteria.add(Restrictions.eq("t.idHomework", idHomework));
		criteria.addOrder(Order.desc("t.dueDate"));
		return (List<HomeworkAssignement>) criteria.list();
	}
	
	@Override
	public HomeworkAssignement getHomeworkAssignmentofStudent(int idHomework,int idStudent) {
		Criteria criteria = createEntityCriteria();
		criteria.createAlias("homework", "t");
		criteria.createAlias("student", "s");
		criteria.add(Restrictions.eq("t.idHomework", idHomework));
		criteria.add(Restrictions.eq("s.idUser", idStudent));
		criteria.addOrder(Order.desc("t.dueDate"));
		List<HomeworkAssignement> list =  (List<HomeworkAssignement>) criteria.list();
		if(list.size() == 1)
			return (HomeworkAssignement) criteria.uniqueResult();
		else
			return (HomeworkAssignement) criteria.list().get(0);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HomeworkAssignement> getTodayStudentHomeworks(int idStudent,LocalDate today) {
		Criteria criteria = createEntityCriteria();
		criteria.createAlias("student", "t");
		criteria.createAlias("homework", "h");
		criteria.add(Restrictions.eq("h.date", today));
		criteria.add(Restrictions.eq("t.idUser", idStudent));
		criteria.add(Restrictions.eq("done", false));
		return (List<HomeworkAssignement>) criteria.list();
	}
	
}
