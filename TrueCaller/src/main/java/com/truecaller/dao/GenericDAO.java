package com.truecaller.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

/**
 * 
 * @author rajkumar
 *
 * @param <T>
 */
public interface GenericDAO<T> {

    public Session getSession();
    
    public void update(T entity);

    public void delete(Object obj);

    public List<T> getAll();
    
    public List<T> getAll(boolean isActive);
    
    public Serializable save(T entity);
    
    public void saveOrUpdate(T entity);
    
    public T getEntity(Class<T> clazz, Long id);
    public T getEntity(Class<T> clazz, Integer id);
    
    public void replicate(T entity);
   
}
