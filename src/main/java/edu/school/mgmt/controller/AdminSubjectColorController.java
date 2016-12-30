package edu.school.mgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.school.mgmt.model.SubjectColor;
import edu.school.mgmt.service.SubjectColorService;

@Controller
public class AdminSubjectColorController {

	@Autowired
	SubjectColorService colorService;
	
	@RequestMapping(value = "/admin/color", method = RequestMethod.GET)
    public String adminSubjectColorPage(ModelMap model) {
    	
		model.addAttribute("subjectColor", new SubjectColor());
		model.addAttribute("colors", colorService.getAllSubjectColors());
		model.addAttribute("action", "create");
		
        return "admin-subject-color";
    }
	
	@RequestMapping(value = "/admin/edit/color", method = RequestMethod.GET)
    public String adminSubjectColorEditPage(ModelMap model,@RequestParam int idSubjectColor) {
    	
		model.addAttribute("subjectColor", colorService.getBySubjectColorId(idSubjectColor));
		model.addAttribute("colors", colorService.getAllSubjectColors());
		model.addAttribute("action", "edit");
		
        return "admin-subject-color";
    }
	
	@RequestMapping(value = "/admin/create/color", method = RequestMethod.POST)
    public String addSubjectColorPage(String action,SubjectColor subjectColor) {
    	
		try {			
			if(action.equals("create")){
				colorService.createSubjectColor(subjectColor);
			}			
			if(action.equals("edit")){
				colorService.updateSubjectColor(subjectColor);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}		
        return "redirect:/admin/color";
    }
	
	@RequestMapping(value = "/admin/delete/color", method = RequestMethod.GET)
    public String deleteSubjectColor(ModelMap model,@RequestParam int idSubjectColor) {
    	
		SubjectColor color = colorService.getBySubjectColorId(idSubjectColor);
		
		if(color != null)
			colorService.deleteSubjectColor(color);
		
		return "redirect:/admin/color";
    }
	
	@RequestMapping(value = "/admin/schedule", method = RequestMethod.GET)
    public String adminSchedulePage(ModelMap model) {
    	
        return "admin-schedule";
    }
}
