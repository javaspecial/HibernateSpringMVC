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
import org.hibernate.criterion.Restrictions;
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
public class Delete {

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public String delete(ModelMap map, @RequestParam("name") String name) {
        StudentInfo st_info = new StudentInfo();

        SessionFactory ssnf = NewHibernateUtil.getSessionFactory();
        Session ssn = ssnf.openSession();
        ssn.beginTransaction();

        //database delete
        st_info = (StudentInfo) ssn.createCriteria(StudentInfo.class).add(Restrictions.eq("name", name)).uniqueResult();
        ssn.delete(st_info);
        ssn.getTransaction().commit();
        ssn.close();
        map.addAttribute("del", "Successfully deleted your name: " + name);
        return "index";
    }

}
