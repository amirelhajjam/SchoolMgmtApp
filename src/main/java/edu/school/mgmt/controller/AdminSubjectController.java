package edu.school.mgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.school.mgmt.model.Subject;
import edu.school.mgmt.service.SubjectService;

@Controller
public class AdminSubjectController {

	@Autowired
	SubjectService subjectService;
	
	@RequestMapping(value = "/admin/subject", method = RequestMethod.GET)
    public String adminSubjectPage(ModelMap model) {
    	
		model.addAttribute("subject", new Subject());
		model.addAttribute("subjects", subjectService.getAllSubjects());
		model.addAttribute("action", "create");
		
        return "admin-subject";
    }
	
	@RequestMapping(value = "/admin/edit/subject", method = RequestMethod.GET)
    public String adminSubjectEditPage(ModelMap model,@RequestParam int idSubject) {
    	
		model.addAttribute("subject", subjectService.getBySubjectId(idSubject));
		model.addAttribute("subjects", subjectService.getAllSubjects());
		model.addAttribute("action", "edit");
		
        return "admin-subject";
    }
	
	@RequestMapping(value = "/admin/create/subject", method = RequestMethod.POST)
    public String addSubject(String action,Subject subject) {
    	
		try {			
			if(action.equals("create")){
				subjectService.createSubject(subject);
			}			
			if(action.equals("edit")){
				subjectService.updateSubject(subject);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}		
        return "redirect:/admin/subject";
    }
	
	@RequestMapping(value = "/admin/delete/subject", method = RequestMethod.GET)
    public String deleteSubject(@RequestParam int idSubject) {
    	
		Subject subject = subjectService.getBySubjectId(idSubject);
		
		if(subject != null)
			subjectService.deleteSubject(subject);
		
		return "redirect:/admin/subject";
    }
	
}
