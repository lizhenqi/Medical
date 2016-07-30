package com.kaishengit.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/30.
 */
@Entity
@Table(name = "t_disease")
public class Disease implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String entityname;
    @ManyToOne
    @JoinColumn(name = "deptid")
    private Dept dept;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEntityname() {
        return entityname;
    }

    public void setEntityname(String entityname) {
        this.entityname = entityname;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
