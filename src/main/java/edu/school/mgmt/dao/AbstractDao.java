package edu.school.mgmt.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDao<PK extends Serializable, T> {

	private final Class<T> persistentClass;
    
	@Autowired
    private SessionFactory sessionFactory;
	
    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
	
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    @SuppressWarnings("unchecked")
    public T getById(PK key) {
        return (T) getSession().get(persistentClass, key);
    }
 
    public void create(T entity) {
        getSession().persist(entity);
    }
    
    public void update(T entity) {
        getSession().update(entity);
    }
 
    public void delete(T entity) {
        getSession().delete(entity);
    }
    
    @SuppressWarnings("unchecked")
	public List<T> findAll(){
    	
    	Criteria criteria = createEntityCriteria();
		return (List<T>) criteria.list();    	
    }
     
    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }
}
