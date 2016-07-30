package com.kaishengit.service;

import com.kaishengit.dao.DiseaseDao;
import com.kaishengit.pojo.Disease;

import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by Administrator on 2016/7/30.
 */

@Named
@Transactional
public class DiseaseService {
    @Inject
    private DiseaseDao diseaseDao;

//   查询
    public List<Disease> findAllDisease(){
        diseaseDao.findAll();
        return null;
    }

//保存病种
    public void saveDiosease(Disease disease){
         diseaseDao.save(disease);
    }
}
