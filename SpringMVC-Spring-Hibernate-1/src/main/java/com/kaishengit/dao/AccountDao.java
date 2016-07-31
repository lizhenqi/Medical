package com.kaishengit.dao;


import com.kaishengit.pojo.Account;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import javax.inject.Named;
import java.util.List;

/**
 * Created by Administrator on 2016/7/30.
 */
@Named
public class AccountDao extends BaseDao<Account,Integer> {




    //    按账户查询
    public Account findByUsername(String username) {

       Criteria criteria=getSession().createCriteria(Account.class);
        Account account= (Account) criteria.add(Restrictions.eq("username",username)).uniqueResult();
        return account;
    }

}
