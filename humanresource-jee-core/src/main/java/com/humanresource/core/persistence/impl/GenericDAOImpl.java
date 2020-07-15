package com.humanresource.core.persistence.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.humanresource.core.persistence.GenericDAO;

public class GenericDAOImpl<T, ID> implements GenericDAO<T, ID> {

	private static final long serialVersionUID = -3863342710369633201L;

	protected Class<T> classEntity;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Class<T> getClassEntity() {
	 if (classEntity == null) {
            try {
                classEntity = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            } catch (Exception e) {
                throw new RuntimeException("EntityClass deve ser informado !");
            }
        }
        return classEntity;
	}

	@Override
	public void setClassEntity(Class<T> classEntity) {
		this.classEntity = classEntity;
	}

	@Override
	public Query createQuery(String sql) {
		return this.getEntityManager().createQuery(sql);
	}

	@Override
	public TypedQuery<T> createQuery(String sql, Class<T> classEntity) {
		return this.getEntityManager().createQuery(sql, classEntity);
	}

	@Override
	public Query createNativeQuery(String sql) {
		return this.getEntityManager().createNativeQuery(sql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return this.getEntityManager().createQuery("Select entidade FROM " + getClassEntity().getSimpleName() + " entidade").getResultList();
	}

	@Override
	public T save(T entity) {
		this.getEntityManager().persist(entity);
		this.getEntityManager().flush();
		return entity;
	}

	@Override
	public T update(T entity) {
		return this.getEntityManager().merge(entity);
	}

	@Override
	public void delete(T entity) {
		this.getEntityManager().remove(
				this.getEntityManager().contains(entity) ? 
						entity 
						:
						this.entityManager.merge(entity));
	}

	@Override
	public void deleteById(ID id) {
		this.getEntityManager().remove(findById(id));
	}

	@Override
	public T findById(ID id) {
		return this.getEntityManager().find(getClassEntity(), id);
	}

}
