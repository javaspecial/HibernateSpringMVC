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
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Dell
 */
@Controller
public class Insert {

    @RequestMapping(value = "/")
    public String display() {
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String insert(ModelMap map, @RequestParam("name") String name) {

        StudentInfo sti = new StudentInfo();
        sti.setName(name);

        SessionFactory ssnf = NewHibernateUtil.getSessionFactory();
        Session ssn = ssnf.openSession();
        ssn.beginTransaction();
        //insert into student_info
        ssn.save(sti);
        ssn.getTransaction().commit();
        ssn.close();

        map.addAttribute("inserted", "You are inserted your name as : " + name);
        return "index";

    }
}
