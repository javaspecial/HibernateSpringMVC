/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernate.controller;

import com.mycompany.hibernate.model.StudentInfo;
import com.mycompany.hibernate.util.NewHibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Dell
 */
@Controller
public class Retrive {

    @RequestMapping(value = "/display", method = RequestMethod.POST)
    public String display(ModelMap map) {
        StudentInfo st_info = new StudentInfo();

        SessionFactory ssnf = NewHibernateUtil.getSessionFactory();
        Session ssn = ssnf.openSession();
        ssn.beginTransaction();
        //display database
        st_info = (StudentInfo) ssn.get(StudentInfo.class, 4);
        ssn.getTransaction().commit();
        ssn.close();
        map.addAttribute("display", "Displayed your expected name:  " + st_info.getName());
        return "index";
    }
}
