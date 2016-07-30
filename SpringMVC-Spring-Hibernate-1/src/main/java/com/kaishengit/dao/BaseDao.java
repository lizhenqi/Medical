package com.kaishengit.dao;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;

import javax.inject.Inject;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Administrator on 2016/7/28.
 */
//PK extends Serializable表示泛型PK是可序列号的
public class BaseDao<T,PK extends Serializable> {

    @Inject
    private SessionFactory sessionFactory;
    private Class<?> entityClass;

//获取fanxing.class
    public BaseDao(){
        ParameterizedType parameterizedType= (ParameterizedType) this.getClass().getGenericSuperclass();//获取泛型的数组
        entityClass= (Class<?>) parameterizedType.getActualTypeArguments()[0];

    }

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    //增、修改
    public void save(T entity){
        getSession().saveOrUpdate(entity);
    }

    //按对象删除
    public void delete(T entity){
        getSession().delete(entity);
    }

//查询全部
    public List<T> findAll(){
        Criteria criteria=getSession().createCriteria(entityClass);
        criteria.addOrder(Order.desc("id"));
        return criteria.list();
    }

//按id查（有的可能为uuid故这里整泛型）
    public T findById(PK id){
        return (T) getSession().get(entityClass,id);//id要求是可序列化的（故要把PK继承Serializable）
    }

    //    按id删除
    public void deleteById(PK id){
        getSession().delete(findById(id));
    }








}
