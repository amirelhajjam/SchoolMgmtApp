package edu.school.mgmt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import edu.school.mgmt.model.ScheduleAssoc;

@Repository("scheduleAssocDaoImpl")
public class ScheduleAssocDaoImpl extends AbstractDao<Integer,ScheduleAssoc> implements ScheduleAssocDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ScheduleAssoc> getStudentSchedule(int idStudent) {
		Criteria criteria = createEntityCriteria();
		criteria.createAlias("student", "s");
		criteria.add(Restrictions.eq("s.idUser", idStudent));
		return (List<ScheduleAssoc>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ScheduleAssoc> getTeacherSchedule(int idTeacher) {
		Criteria criteria = createEntityCriteria();
		criteria.createAlias("teacher", "t");
		criteria.add(Restrictions.eq("t.idUser", idTeacher));
		return (List<ScheduleAssoc>) criteria.list();
	}
	
	
}
