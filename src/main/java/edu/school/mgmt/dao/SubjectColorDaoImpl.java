package edu.school.mgmt.dao;
import org.springframework.stereotype.Repository;

import edu.school.mgmt.model.SubjectColor;

@Repository("subjectColorDao")
public class SubjectColorDaoImpl extends AbstractDao<Integer, SubjectColor> implements SubjectColorDao {

}
