package edu.school.mgmt.controller;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.school.mgmt.model.Activity;
import edu.school.mgmt.model.Homework;
import edu.school.mgmt.model.Teacher;
import edu.school.mgmt.model.User;
import edu.school.mgmt.service.ActivityService;
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
	
	@Autowired
	ActivityService activityService;
	
	@RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public String teacherPage(ModelMap model) {
    	
		Teacher teacher = (Teacher) userService.getUserByLogin(helper.getPrincipal());
		model.addAttribute("userId", teacher.getIdUser());      
        
        return "teacher";
    }
	
	@RequestMapping(value="/teacher/profile" , method = RequestMethod.GET)
	public String teacherProfile(Model model){		
		
		User user = userService.getUserByLogin(helper.getPrincipal());
		model.addAttribute("user", user);
		model.addAttribute("userId", user.getIdUser());
		model.addAttribute("action", "create");
		model.addAttribute("userContext", "teacher");
		return "user-profile-page";
	}
	
	@RequestMapping(value="/teacher/create/activity" , method = RequestMethod.GET)
	public String teacherActivityPage(Model model){		
		
		User user = userService.getUserByLogin(helper.getPrincipal());
		model.addAttribute("activity", new Activity());
		model.addAttribute("userId", user.getIdUser());
		model.addAttribute("action", "create");
		model.addAttribute("activities", activityService.getUserActivities(user.getIdUser()));
		model.addAttribute("userContext", "teacher");
		return "user-activity-page";
	}
	
	@RequestMapping(value="/teacher/edit/activity" , method = RequestMethod.GET)
	public String teacherEditActivityPage(Model model,@RequestParam int idActivity){		
		
		User user = userService.getUserByLogin(helper.getPrincipal());
		model.addAttribute("activity", activityService.getById(idActivity));
		model.addAttribute("userId", user.getIdUser());
		model.addAttribute("action", "update");
		model.addAttribute("activities", activityService.getUserActivities(user.getIdUser()));
		model.addAttribute("userContext", "teacher");
		return "user-activity-page";
	}
	
	@RequestMapping(value = "/teacher/homework", method = RequestMethod.GET)
    public String assignHomworkPage(ModelMap model) {
    	
		Teacher teacher = (Teacher) userService.getUserByLogin(helper.getPrincipal());
		int idTeacher = teacher.getIdUser();
		model.addAttribute("subjects", scheduleService.getTeacherSubjects(idTeacher));
		Homework homework = new Homework();
		homework.setCreationDate(new LocalDate());
		homework.setDate(null);
        model.addAttribute("homework", homework);
        model.addAttribute("action", "create");
        model.addAttribute("homeworks", homeworkService.getTeacherHomeworks(idTeacher));
        
        return "teacher-homework";
    }
	
	@RequestMapping(value = "/teacher/update/homework", method = RequestMethod.GET)
    public String updateHomworkPage(ModelMap model,int idHomework) {
    	
		Teacher teacher = (Teacher) userService.getUserByLogin(helper.getPrincipal());
		int idTeacher = teacher.getIdUser();
		model.addAttribute("subjects", scheduleService.getTeacherSubjects(idTeacher));
		Homework homework = homeworkService.getByHomeworkId(idHomework);
        model.addAttribute("homework", homework);
        model.addAttribute("action", "update");
        model.addAttribute("idSub", homework.getSubject().getIdSubject());
        model.addAttribute("homeworks", homeworkService.getTeacherHomeworks(idTeacher));
        
        return "teacher-homework";
    }
}
