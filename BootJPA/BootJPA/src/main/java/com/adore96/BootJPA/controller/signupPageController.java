package com.adore96.BootJPA.controller;

import com.adore96.BootJPA.dao.StudentRepo;
import com.adore96.BootJPA.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class signupPageController {

    @Autowired
    StudentRepo studentRepo;

    @RequestMapping("/")
    public String home() {
//        System.out.println("Test --> "+studentRepo.getOne(1).getUsername());
        return "signupPage.jsp";
    }

    @RequestMapping("/Signup")
    public String Signup(Users users) {
        studentRepo.save(users);
        System.out.println("Data Added Successfully.");
        return "signupPage.jsp";
    }

    @RequestMapping("/Search")
    public ModelAndView Search(@RequestParam int id) {

        ModelAndView mv = new ModelAndView("showStudent.jsp");
        System.out.println("Test2 --> " + studentRepo.getOne(id).getUsername());
        Users users = studentRepo.findById(id).orElse(new Users());
        mv.addObject(users);
        return mv;
    }

    @RequestMapping("/fnameSearch")
    public ModelAndView fnameSearch(@RequestParam String fname) {
        ModelAndView mv = new ModelAndView("showfnameStudent.jsp");
        List<Users> users = studentRepo.findByFname(fname);
        System.out.println("----> " + users);
        return mv;
    }

//    @RequestMapping("/students")
//    @ResponseBody
//    public String GetAll() {
//        return studentRepo.findAll().toString();
//    }

    @RequestMapping("/Delete")
    public ModelAndView Delete(@RequestParam String fname) {
        System.out.println(fname);
        ModelAndView mv = new ModelAndView("showfnameStudent.jsp");
//        List<Users> users = studentRepo.findByFname(fname);
        studentRepo.deleteByFname(fname);
        return mv;
    }

    @RequestMapping("/users")

    public String getCustomers(Model model) {
//      ModelAndView mv = new ModelAndView("showStudent.jsp");
        
        List<Users> users = studentRepo.findAll();
        for(int i=0;i<users.size();i++){
            (users.get(i).getId();

        }
        model.addAttribute("users", users);
        System.out.println(users);
//        mv.addObject(users);
        return "showStudent.jsp";
    }

}

