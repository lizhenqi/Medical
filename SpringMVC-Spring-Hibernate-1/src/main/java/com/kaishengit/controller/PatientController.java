package com.kaishengit.controller;

import com.kaishengit.dao.PatientDao;
import com.kaishengit.pojo.Insurance;
import com.kaishengit.pojo.Patient;
import com.kaishengit.service.InsuranceService;
import com.kaishengit.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import java.util.List;

/**
 * Created by Administrator on 2016/7/30.
 */
@Controller
@RequestMapping("/patient")
public class PatientController {
    @Inject
    private PatientService patientService;
    @Inject
    private InsuranceService insuranceService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<Patient> patients = patientService.findAll();
        model.addAttribute("patients", patients);
        return "patient/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String add(Model model) {
        List<Insurance> insurances = insuranceService.findAll();
        model.addAttribute("insurances", insurances);
        return "/patient/newpatient";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addPatient(Patient patient) {

        patientService.save(patient);
        return "redirect:/patient";
    }

    @RequestMapping(value = "/edit/{id:\\d+}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model) {
        Patient patient = patientService.findById(id);
        if (patient == null) {
            throw new RuntimeException("找不到信息");
        } else {
            model.addAttribute("patients", patient);
            return "/patient/edit";
        }
    }

}
