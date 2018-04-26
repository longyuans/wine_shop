package com.wine_shop.dao.Hibernate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import com.wine_shop.dao.IBaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Description TODO（公共模块的抽取）
 *
 */
@SuppressWarnings("unchecked")
@Repository("baseDao")
@Lazy(true)
public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {

	private Class clazz; //clazz中存储了当前操作的类型，即泛型T

	@Resource //放在属性上面，就不会调用set方法，使用反射注进来，所以可以把set方法干掉了
	private SessionFactory sessionFactory;

	@Resource
	public void setSessionFactory0(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}


	public BaseDaoImpl() {
		System.out.println("this代表的是当前调用构造方法的对象" + this);
		System.out.println("获取当前this对象的父类信息" + this.getClass().getSuperclass());
		System.out.println("获取当前this对象的父类信息(包括泛型信息)" + this.getClass().getGenericSuperclass());
		//拿到泛型的参数类型
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class)type.getActualTypeArguments()[0];
	}

	protected Session getSession() {
		//从当前线程获取session，如果没有则创建一个新的session
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
		//getSession().save(t);
	}

	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);
		//getSession().update(t);
	}

	@Override
	public void delete(int id) {
		System.out.println(clazz.getSimpleName());
		String hql = "delete " + clazz.getSimpleName() + " as c where c.id="+id+"";
		this.getHibernateTemplate().delete(hql);
		//getSession().createQuery(hql) //.setInteger("id", id) //.executeUpdate();
	}

	@Override
	public T get(int id) {
		return (T) this.getHibernateTemplate().get(clazz, id);
	}

	@Override
	public List<T> query() {
		String hql = "from " + clazz.getSimpleName();
		return (List<T>) this.getHibernateTemplate().find(hql);
	}

}
