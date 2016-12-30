package edu.school.mgmt.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import edu.school.mgmt.model.Subject;

@Repository("subjectDao")
public class SubjectDaoImpl extends AbstractDao<Integer, Subject> implements SubjectDao {

	@Override
	public Subject getSubjectByTitle(String title) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("title", title));
        return (Subject) criteria.uniqueResult();
	}

}
