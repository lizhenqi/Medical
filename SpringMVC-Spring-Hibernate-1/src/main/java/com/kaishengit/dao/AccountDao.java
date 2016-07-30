package com.kaishengit.dao;

import com.kaishengit.pojo.Account;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;

import javax.inject.Named;

/**
 * Created by Administrator on 2016/7/29.
 */
@Named
public class AccountDao extends BaseDao<Account, Integer> {


}

