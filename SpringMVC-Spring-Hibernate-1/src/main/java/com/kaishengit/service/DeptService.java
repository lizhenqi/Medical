package com.kaishengit.service;

import com.kaishengit.dao.DeptDao;
import com.kaishengit.pojo.Account;
import com.kaishengit.pojo.Dept;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Administrator on 2016/7/30.
 */
@Named
@Transactional
public class DeptService {
    @Inject
    private DeptDao deptDao;

    public void saveDept(Dept dept){
        deptDao.save(dept);
    }

    public List<Dept> findAll(){
        return deptDao.findAll();
    }

}
