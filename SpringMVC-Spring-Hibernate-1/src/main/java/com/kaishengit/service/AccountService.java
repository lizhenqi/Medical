package com.kaishengit.service;

import com.kaishengit.dao.AccountDao;
import com.kaishengit.pojo.Account;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;


/**
 * Created by Administrator on 2016/7/29.
 */
@Named
@Transactional
public class AccountService {

    @Inject
    private AccountDao accountDao;

    public Account findById(Integer id){
        return accountDao.findById(id);
    }

    //    按账户查询
    public Account findByUsername(String username){
        return accountDao.findByUsername(username);
    }




}
