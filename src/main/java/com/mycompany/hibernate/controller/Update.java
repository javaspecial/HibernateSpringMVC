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
public class Update {

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(ModelMap map, @RequestParam("name") String name) {
        StudentInfo st_info = new StudentInfo();

        SessionFactory ssnf = NewHibernateUtil.getSessionFactory();
        Session ssn = ssnf.openSession();
        ssn.beginTransaction();
        // update database
        st_info = (StudentInfo) ssn.get(StudentInfo.class, 3);
        st_info.setName(name);
        ssn.update(st_info);
        ssn.getTransaction().commit();
        ssn.close();
        map.addAttribute("updated", "Successfully updated your name with " + name);
        return "index";
    }
}
