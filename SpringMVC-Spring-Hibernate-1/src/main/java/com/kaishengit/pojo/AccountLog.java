package com.kaishengit.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/7/30.
 */
@Entity
@Table(name = "t_appcount_log")
public class AccountLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp logintime;
    private String loginip;

    @ManyToOne
    @JoinColumn(name = "accountid")
    private Account account;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip;
    }

    public Timestamp getLogintime() {
        return logintime;
    }

    public void setLogintime(Timestamp logintime) {
        this.logintime = logintime;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
