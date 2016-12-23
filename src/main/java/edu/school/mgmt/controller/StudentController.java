package edu.school.mgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.school.mgmt.util.HelperUtils;

@Controller
public class StudentController {

	@Autowired
	HelperUtils helper;
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
    public String studentPage(ModelMap model) {
    	
        model.addAttribute("user", helper.getPrincipal());
        
        return "student";
    }
}
