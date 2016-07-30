package com.kaishengit.dao;

import com.kaishengit.pojo.Account;
import com.kaishengit.pojo.Dept;
import com.kaishengit.pojo.Role;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Administrator on 2016/7/30.
 */
@Named
public class RoleDao extends BaseDao<Role, Integer> {

    //    按角色查询
    public Role findByRolename(String rolename) {
        Criteria criteria=getSession().createCriteria(Role.class);
        criteria.add(Restrictions.eq("rolename",rolename));
        Role role= (Role) criteria.uniqueResult();
        return role;
    }

}
