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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.school.mgmt.model.User;
import edu.school.mgmt.service.UserService;


@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user/profile/update" , method = RequestMethod.POST)
	public String adminProfile(User user,String userContext,int userId,Model model,MultipartFile file){		
		
		try{
			
			if( !file.isEmpty() ) { 
				user.setImage(file.getBytes());
			}
			User u = userService.getUserById(userId);
			u.setFullName(user.getFullName());
			u.setSchoolEmail(user.getSchoolEmail());
			u.setImage(user.getImage());
			u.setPassword(user.getPassword());
			u.setPosition(user.getPosition());
			userService.updateUser(u);
			
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
