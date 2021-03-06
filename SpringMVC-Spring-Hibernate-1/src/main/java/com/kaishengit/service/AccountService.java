package com.kaishengit.service;

import com.kaishengit.dao.AccountDao;
import com.kaishengit.pojo.Account;
import com.kaishengit.util.ShiroUtil;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;


/**
 * Created by Administrator on 2016/7/29.
 */
@Named
@Transactional
public class AccountService {

    @Inject
    private AccountDao accountDao;

    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    //    按账户查询
    public Account findByUsername(String username) {
        return accountDao.findByUsername(username);
    }

    //    查询全部
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    //    新建
    public void save(Account account) {
        accountDao.save(account);
    }

//    按id删除
    public void del(Integer id){
        accountDao.deleteById(id);
    }


    /**
     * 修改密码
     * @param password
     */
    public void changePassword(String password) {

        Account account= ShiroUtil.getCurrentUser();
        account.setPassword(password);
        accountDao.save(account);

    }



}
