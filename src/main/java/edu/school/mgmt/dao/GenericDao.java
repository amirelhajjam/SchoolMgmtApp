package edu.school.mgmt.dao;

import java.io.Serializable;
import java.util.List;


public interface GenericDao<PK extends Serializable, T> {

	public T getById(PK key);
	
	public void update(T entity);
	
	public void create(T entity);
	
	public void delete(T entity);
	
	public List<T> findAll();
	
}
