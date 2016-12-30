package edu.school.mgmt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import edu.school.mgmt.model.HomeworkAssignement;

@Repository("homeworkAssignementDao")
public class HomeworkAssignementDaoImpl extends AbstractDao<Integer, HomeworkAssignement> implements HomeworkAssignementDao {

	
	@SuppressWarnings("unchecked")
	@Override
	public List<HomeworkAssignement> getStudentHomeworks(int idStudent) {
		Criteria criteria = createEntityCriteria();
		criteria.createAlias("student", "t");
		criteria.add(Restrictions.eq("t.idUser", idStudent));
		return (List<HomeworkAssignement>) criteria.list();
	}
	
}
