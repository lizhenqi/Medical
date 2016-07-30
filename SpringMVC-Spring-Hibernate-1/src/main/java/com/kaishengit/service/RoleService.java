package com.kaishengit.service;

import com.kaishengit.dao.RoleDao;
import com.kaishengit.pojo.Account;
import com.kaishengit.pojo.Role;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.transaction.Transactional;

/**
 * Created by Administrator on 2016/7/30.
 */

@Named
@Transactional
public class RoleService {
    @Inject
    private RoleDao roleDao;


    //    按账户查询
    public Role findByUsername(String rolename){
        return roleDao.findByRolename(rolename);
    }

    //    按id查询
    public Role findById(Integer id){
        return roleDao.findById(id);
    }



}
