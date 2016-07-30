package com.kaishengit;

import com.kaishengit.dao.AccountLogDao;
import com.kaishengit.pojo.Account;
import com.kaishengit.pojo.Dept;
import com.kaishengit.service.AccountLogService;
import com.kaishengit.service.AccountService;
import com.kaishengit.service.DeptService;
import com.kaishengit.service.DiseaseService;
import com.kaishengit.util.ShiroUtil;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.naming.ldap.PagedResultsControl;
import java.util.List;

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
    @Test
    public void test() {
        Account account = accountService.findById(1);
        System.out.println(account.getPassword());
    }

//    测试Account通过username查询
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


}
