package com.kaishengit.service;


import com.kaishengit.dao.InsuranceDao;
import com.kaishengit.dao.PatientDao;
import com.kaishengit.pojo.Insurance;
import com.kaishengit.pojo.Patient;
import org.hibernate.Criteria;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by Administrator on 2016/7/30.
 */
@Named
@Transactional
public class PatientService {
    @Inject
    private PatientDao patientDao;
    @Inject
    private InsuranceDao insuranceDao;

    public List<Patient> findAll() {
        return patientDao.findAll();
    }


    public void save(Patient patient) {
        patientDao.save(patient);
    }

    public Patient findById(Integer id) {
        return patientDao.findById(id);
    }

}
