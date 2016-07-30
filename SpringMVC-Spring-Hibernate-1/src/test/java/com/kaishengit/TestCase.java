package com.kaishengit;

import com.kaishengit.pojo.Account;
import com.kaishengit.service.AccountService;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestCase {

    @Inject
    private AccountService accountService;

    @Test
    public void test(){
       Account account=accountService.findById(1);
        System.out.println(account.getPassword());
    }
}
