package br.com.necroterio.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.Valid;

import br.com.necroterio.dao.util.JpaUtil;

public abstract class GenericDao<T, I extends Serializable> {

	    EntityManager entityManager = JpaUtil.getEntityManager();

	    private Class<T> persistedClass;

	    protected GenericDao() {
	    }

	    protected GenericDao(Class<T> persistedClass) {
	        this();
	        this.persistedClass = persistedClass;
	    }

	    public T salvar(@Valid T entity) {
	        EntityTransaction t = entityManager.getTransaction();
	        t.begin();
	        entityManager.persist(entity);
	        entityManager.flush();
	        t.commit();
	        return entity;
	    }

	    public T atualizar(@Valid T entity) {
	        EntityTransaction t = entityManager.getTransaction();
	        t.begin();
	        entityManager.merge(entity);
	        entityManager.flush();
	        t.commit();
	        return entity;
	    }

	    public void remover(T entity) {
	        entityManager.getTransaction().begin();
	        entityManager.remove(entity);
	        entityManager.flush();
	        entityManager.getTransaction().commit();

	    }

	    public List<T> listar() {
	        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	        CriteriaQuery<T> query = builder.createQuery(persistedClass);
	        query.from(persistedClass);
	        return entityManager.createQuery(query).getResultList();
	    }

	    public T encontrar(I id) {
	        T result = entityManager.find(persistedClass, id);
	        entityManager.close();
	        return result;
	    }
	}