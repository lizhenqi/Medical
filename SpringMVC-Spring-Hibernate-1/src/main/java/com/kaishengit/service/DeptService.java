package com.kaishengit.service;

import com.kaishengit.dao.DeptDao;
import com.kaishengit.pojo.Account;
import com.kaishengit.pojo.Dept;

import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by Administrator on 2016/7/30.
 */
@Named
@Transactional
public class DeptService {
    @Inject
    private DeptDao deptDao;

//    保存
    public void saveDept(Dept dept){
        deptDao.save(dept);
    }

//查询全部科室
    public List<Dept> findAll(){
        return deptDao.findAll();
    }

//    按id查询
    public Dept findById(Integer id){
        return deptDao.findById(id);
    }

//    按id删除
    public void deleteById(Integer id){
         deptDao.deleteById(id);
    }



}
