package com.kaishengit.dao;

import com.kaishengit.pojo.Account;
import com.kaishengit.pojo.Dept;
import com.kaishengit.pojo.Role;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import javax.inject.Named;

/**
 * Created by Administrator on 2016/7/29.
 */
@Named
public class AccountDao extends BaseDao<Account,Integer> {

    //    按账户查询
    public Account findByUsername(String username) {
        Criteria criteria=getSession().createCriteria(Account.class);
        criteria.add(Restrictions.eq("username",username));
        Account account= (Account) criteria.uniqueResult();
        return account;
    }



}
