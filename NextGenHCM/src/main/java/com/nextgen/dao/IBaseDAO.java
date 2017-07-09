package com.nextgen.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;

/**
 * This is a Generic Dao interface ,it is used to perform the basic
 * operation on entity
 * 
 * @author umamaheswarar
 * NextGenHCM 
 * July 12, 2016
 */

public interface IBaseDAO<T> {
	
	/**
     * Find unique object using param query and parameter
     * @author umamaheswarar
     * @param     paramString A String object contain
     * @param     paramMap A Map<String, Object> object contain
     * @exception HibernateException
     * @return   Object
     */
	
    <X> X findById(final Class<T> clazz, final Long id) throws HibernateException;
    
    /**
     * Find and retrieve list of object as per provided sql param string and
     * parameter with maximum records size define
     * @author umamaheswarar
     * @param     paramString A String object contain
     * @param     paramMap A Map<String, Object> object contain
     * @param     maxResults A integer type variable contain
     * @exception HibernateException
     * @return   List of type object
     */
    
    <X> List<X> findById(final Class<T> clazz, final Long...id) throws HibernateException;
    
    /**
     * Find and retrieve list of object as per provided sql param string and
     * parameter with maximum records size define
     * @author umamaheswarar
     * @param     paramString A String object contain
     * @param     paramMap A Map<String, Object> object contain
     * @param     maxResults A integer type variable contain
     * @exception HibernateException
     * @return   List of type object
     */
    
    <X> List<X> findByColumn(final Class<T> clazz, String column, Object value) throws HibernateException;
    
    /**
     * Find and retrieve list of object as per provided sql param string and
     * parameter with maximum records size define
     * @author umamaheswarar
     * @param     paramString A String object contain
     * @param     paramMap A Map<String, Object> object contain
     * @param     maxResults A integer type variable contain
     * @exception HibernateException
     * @return   List of type object
     */
    
    <X> X findUniqueByColumn(final Class<T> clazz, String column, Object value) throws HibernateException;
    
    /**
     * Find and retrieve list of object as per provided sql param string and
     * parameter with maximum records size define
     * @author umamaheswarar
     * @param     paramString A String object contain
     * @param     paramMap A Map<String, Object> object contain
     * @param     maxResults A integer type variable contain
     * @exception HibernateException
     * @return   List of type object
     */
    
    <X> List<X> findAll(final Class<T> clazz) throws HibernateException;
    
    /**
     * Save entity object related to specified bean object passed as method argument
     * @author umamaheswarar
     * @param     paramT A Object type
     * @exception HibernateException
     * @return   Serializable
     */
    Serializable save(T paramT) throws HibernateException;
    
    /**
     * Save entity object related to specified bean object passed as method argument
     * @author umamaheswarar
     * @param     paramT A Object type
     * @exception HibernateException
     * @return   Serializable
     */
    void delete(T paramT) throws HibernateException;

    /**
     * Save if not persit or update if already persist entity object in db
     * @author umamaheswarar
     * @param     paramT A Object type
     * @exception HibernateException
     * @return   void
     */
    void saveOrUpdate(T paramT) throws HibernateException;
    
    /**
     * Save if not persit or update if already persist entity object in db
     * @author umamaheswarar
     * @param     paramT A Object type
     * @exception HibernateException
     * @return   void
     */
    void merge(T paramT) throws HibernateException;

}
