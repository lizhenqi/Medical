package com.kaishengit;

import com.kaishengit.pojo.Account;
import com.kaishengit.pojo.Insurance;
import com.kaishengit.pojo.Patient;
import com.kaishengit.service.AccountService;
import com.kaishengit.service.InsuranceService;
import com.kaishengit.service.PatientService;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestCase {

    @Inject
    private AccountService accountService;

    @Inject
    private InsuranceService insuranceService;

    @Inject
    private PatientService patientService;

    @Test
    public void test() {
        Account account = accountService.findById(1);
        System.out.println(account.getPassword());
    }

    @Test
    public void test1() {
        List<Insurance> insurances = insuranceService.findAll();
        for (Insurance insurance : insurances) {
            System.out.println(insurance.getInsurancename());
        }
    }

    @Test
    public void tet2() {
        List<Patient> patients = patientService.findAll();
        for (Patient patients1 : patients) {
            System.out.println(patients1);
        }
    }
}
