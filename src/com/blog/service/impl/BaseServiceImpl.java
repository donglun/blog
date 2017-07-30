package com.blog.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.blog.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {

	private Class clazz;
	private SessionFactory sessionFactory;
	
	public BaseServiceImpl(){
		 ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();  
	        clazz = (Class)type.getActualTypeArguments()[0];
	}
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	public void save(T t){
		getSession().save(t);
	}
	public void update(T t){
		getSession().update(t);
	}
	public void delete(int id){
		  String hql = "delete " + clazz.getSimpleName() + " as c where c.id=:id";
		  getSession().createQuery(hql).setInteger("id", id).executeUpdate();  
	}
	public T get(int id){
		return (T)getSession().get(clazz,id);
		
	}
	public List<T> query(){
		String hql="from" + clazz.getSimpleName();
		return getSession().createQuery(hql).list();
	}
	
	
	
	
	
	
	
}
