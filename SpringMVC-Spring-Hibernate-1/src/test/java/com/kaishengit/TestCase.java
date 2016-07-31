package com.kaishengit;

import com.kaishengit.dao.AccountLogDao;
import com.kaishengit.pojo.*;
import com.kaishengit.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Administrator on 2016/7/30.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestCase {

    @Inject
    private AccountService accountService;

    @Inject
    private DeptService deptService;

    @Inject
    private DiseaseService diseaseService;

    @Inject
    private AccountLogDao accountLogDao;

    @Inject
    private AccountLogService accountLogService;

    //    测试Account通过id查询
    private InsuranceService insuranceService;

    @Inject
    private PatientService patientService;


    @Test
    public void test() {
        Account account = accountService.findById(1);
        System.out.println(account.getPassword());
    }


    @Test
    public void testFindByusername() {
        Account account=accountService.findByUsername("admin");
        System.out.println(account.getUsername());
    }

    @Test
    public void testFindAllDept(){
        List<Dept> deptList=deptService.findAll();
        for(Dept dept:deptList){
            System.out.println(dept.getPerson());
        }
    }

    @Test
    public void testSaveDisease(){
        Disease disease=new Disease();
        disease.setEntityname("口腔科");
        diseaseService.saveDiosease(disease);
    }

    //    查询角色
    @Test
    public void testFindRolename() {
        Account account=accountService.findByUsername("admin");
        System.out.println(account.getRole().getRolename());
    }

    @Test
    public void testSaveLog() {
        accountLogService.saveLog("1281313");
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
