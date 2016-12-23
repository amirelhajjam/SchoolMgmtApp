package edu.school.mgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.school.mgmt.forms.RegistrationForm;
import edu.school.mgmt.model.User;
import edu.school.mgmt.model.UserRole;
import edu.school.mgmt.service.UserRoleService;
import edu.school.mgmt.service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	UserRoleService roleService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/register" , method = RequestMethod.POST)
	public String register(RegistrationForm registrationForm,Model model,
			MultipartFile file,final RedirectAttributes redirectAttributes){
		
		try {
			
			UserRole role = null;
			
			User user = registrationForm.createUser();
			
			if( !file.isEmpty() ) { 
				user.setImage( file.getBytes() ); 
			}
			
			if(registrationForm.getProfession().equals("STUDENT")){	
				role = roleService.getUserRoleServiceByRole("STUDENT");				
			} else if(registrationForm.getProfession().equals("TEACHER")){
				role = roleService.getUserRoleServiceByRole("TEACHER");					
			}
			
			userService.createUser(user);								
			
			user.getUserRoles().add(role);
			
			userService.updateUser(user);
			
			redirectAttributes.addFlashAttribute("message", "you've been registered to SCHOOLAPP successfully please check your email to complete ");
			redirectAttributes.addFlashAttribute("template","success");
						
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message", "error please sign up with valid information ");
			redirectAttributes.addFlashAttribute("template","error");
		}
		
		return "redirect:/login";
	}
	
}
