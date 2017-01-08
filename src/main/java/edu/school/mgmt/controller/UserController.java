package edu.school.mgmt.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.school.mgmt.model.Activity;
import edu.school.mgmt.model.Student;
import edu.school.mgmt.model.User;
import edu.school.mgmt.service.ActivityService;
import edu.school.mgmt.service.UserService;
import edu.school.mgmt.util.HelperUtils;


@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	HelperUtils helper;
	
	@Autowired
	ActivityService activityService;
	
	@RequestMapping(value="/admin/profile" , method = RequestMethod.GET)
	public String teacherProfile(Model model){		
		
		User user = userService.getUserByLogin(helper.getPrincipal());
		model.addAttribute("user", user);
		model.addAttribute("userId", user.getIdUser());
		model.addAttribute("userContext", "admin");
		return "user-profile-page";
	}
	
	@RequestMapping(value="/admin/create/activity" , method = RequestMethod.GET)
	public String adminActivityPage(Model model){		
		
		User user = userService.getUserByLogin(helper.getPrincipal());
		model.addAttribute("activity", new Activity());
		model.addAttribute("userId", user.getIdUser());
		model.addAttribute("action", "create");
		model.addAttribute("activities", activityService.getUserActivities(user.getIdUser()));
		model.addAttribute("userContext", "admin");
		return "user-activity-page";
	}
	
	@RequestMapping(value="/admin/edit/activity" , method = RequestMethod.GET)
	public String adminEditActivityPage(Model model,@RequestParam int idActivity){		
		
		User user = userService.getUserByLogin(helper.getPrincipal());
		model.addAttribute("activity", activityService.getById(idActivity));
		model.addAttribute("userId", user.getIdUser());
		model.addAttribute("action", "update");
		model.addAttribute("activities", activityService.getUserActivities(user.getIdUser()));
		model.addAttribute("userContext", "admin");
		return "user-activity-page";
	}
	
	@RequestMapping(value="/user/profile/update" , method = RequestMethod.POST)
	public String adminProfile(User user,String userContext,int userId,int year,MultipartFile file){		
		
		try{			
			
			if(userContext.equals("student")){
				Student s = (Student)userService.getUserById(userId);
				s.setFullName(user.getFullName());
				s.setSchoolEmail(user.getSchoolEmail());
				if( !file.isEmpty() ) { 
					s.setImage(file.getBytes());
				}
				s.setPassword(user.getPassword());
				s.setPosition(user.getPosition());
				s.setYear(year);
				userService.updateUser(s);
			}else{
				User u = userService.getUserById(userId);
				u.setFullName(user.getFullName());
				u.setSchoolEmail(user.getSchoolEmail());
				if( !file.isEmpty() ) { 
					u.setImage(file.getBytes());
				}
				u.setPassword(user.getPassword());
				u.setPosition(user.getPosition());
				userService.updateUser(u);
			}		
			
		}catch(Exception e){
			e.printStackTrace();
		}		
		
		return "redirect:/"+userContext+"/profile";
	}
	
	@RequestMapping(value="/image",produces={MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
	@ResponseBody
	public byte[] getImage(int id) throws IOException{
		
		User u = userService.getUserById(id);
		if(u != null){
			if(u.getImage() == null) 
				return new byte[0];
			return IOUtils.toByteArray(new ByteArrayInputStream(u.getImage()));
		}else
			return null;
	}
	
	
}
