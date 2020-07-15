package com.humanresource.core.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public interface GenericDAO<T, ID> extends Serializable {
	
	public Class<T> getClassEntity();

	public void setClassEntity(Class<T> classEntity);
	
    public Query createQuery(String sql);
    
    public TypedQuery<T> createQuery(String sql,Class<T> classEntity);
    
    public Query createNativeQuery(String sql);
    
    public List<T> findAll();

    public T save(T entity);

    public T update(T entity);

    public void delete(T entity);
    
    public void deleteById(ID id);
    
    public T findById(ID id);
    
    public EntityManager getEntityManager();
}
