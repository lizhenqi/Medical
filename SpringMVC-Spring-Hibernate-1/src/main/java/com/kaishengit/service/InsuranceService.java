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

    public List<Insurance> findAll() {
        return insuranceDao.findAll();
    }


}
