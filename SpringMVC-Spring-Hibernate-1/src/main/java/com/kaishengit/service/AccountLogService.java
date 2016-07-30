package com.kaishengit.service;

import com.kaishengit.dao.AccountLogDao;
import com.kaishengit.pojo.AccountLog;
import com.kaishengit.util.ShiroUtil;
import org.joda.time.DateTime;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by Administrator on 2016/7/30.
 */
@Named
@Transactional
public class AccountLogService {

    @Inject
    private AccountLogDao accountLogDao;


//    查询日志
    public List<AccountLog> findAllLog(){
        return accountLogDao.findAll();
    }



    //    保存日志
    public void saveLog(String ip) {
        AccountLog accountLog=new AccountLog();
        accountLog.setLoginip(ip);
//        accountLog.setLogintime(DateTime.now().toString("yyyy:MM:dd HH:mm"));
        accountLog.getAccount().setId(ShiroUtil.getCurrentUserId());

        accountLogDao.save(accountLog);
    }



}
