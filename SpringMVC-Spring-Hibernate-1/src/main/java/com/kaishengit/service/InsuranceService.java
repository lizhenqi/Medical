package com.kaishengit.service;

import com.kaishengit.dao.InsuranceDao;
import com.kaishengit.pojo.Insurance;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by Administrator on 2016/7/30.
 */
@Named
@Transactional
public class InsuranceService {
    @Inject
    private InsuranceDao insuranceDao;

//    查询所有
    public List<Insurance> findAll() {
        return insuranceDao.findAll();
    }

//    保存
    public void saveInsurance(Insurance insurance){
        insuranceDao.save(insurance);
    }

    //    按id删除
    public void del(Integer id){
        insuranceDao.deleteById(id);
    }

    //    按id查询
    public Insurance findById(Integer id){
        return insuranceDao.findById(id);
    }


}
