package edu.school.mgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.school.mgmt.model.Homework;
import edu.school.mgmt.model.Teacher;
import edu.school.mgmt.service.HomeworkService;
import edu.school.mgmt.service.ScheduleAssocService;
import edu.school.mgmt.service.SubjectService;
import edu.school.mgmt.service.UserService;
import edu.school.mgmt.util.HelperUtils;

@Controller
public class TeacherController {

	@Autowired
	HelperUtils helper;
	
	@Autowired
	SubjectService subjectService;
	
	@Autowired
	ScheduleAssocService scheduleService;
	
	@Autowired
	UserService userService;	
	
	@Autowired
	HomeworkService homeworkService;
	
	@RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public String teacherPage(ModelMap model) {
    	
		Teacher teacher = (Teacher) userService.getUserByLogin(helper.getPrincipal());
		model.addAttribute("userId", teacher.getIdUser());      
        
        return "teacher";
    }
	
	@RequestMapping(value = "/teacher/homework", method = RequestMethod.GET)
    public String assignHomworkPage(ModelMap model) {
    	
		Teacher teacher = (Teacher) userService.getUserByLogin(helper.getPrincipal());
		int idTeacher = teacher.getIdUser();
		model.addAttribute("subjects", scheduleService.getTeacherSubjects(idTeacher));
        model.addAttribute("homework", new Homework());
        model.addAttribute("homeworks", homeworkService.getTeacherHomeworks(idTeacher));
        
        return "teacher-homework";
    }
}
