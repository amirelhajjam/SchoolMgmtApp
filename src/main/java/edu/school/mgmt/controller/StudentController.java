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
import edu.school.mgmt.model.HomeworkAssignement;
import edu.school.mgmt.model.ScheduleAssoc;
import edu.school.mgmt.model.Student;
import edu.school.mgmt.model.Subject;
import edu.school.mgmt.model.SubjectColor;
import edu.school.mgmt.model.Teacher;
import edu.school.mgmt.model.User;
import edu.school.mgmt.service.ActivityService;
import edu.school.mgmt.service.HomeworkAssignementService;
import edu.school.mgmt.service.ScheduleAssocService;
import edu.school.mgmt.service.SubjectColorService;
import edu.school.mgmt.service.SubjectService;
import edu.school.mgmt.service.UserService;
import edu.school.mgmt.util.GetWeekAssignement;
import edu.school.mgmt.util.HelperUtils;

@Controller
public class StudentController {

	@Autowired
	HelperUtils helper;
	
	@Autowired
	GetWeekAssignement getWeekAssignement;
	
	@Autowired
	SubjectService subjectService;
	
	@Autowired
	SubjectColorService colorService;
	
	@Autowired
	HomeworkAssignementService assignementService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ScheduleAssocService scheduleService;
	
	@Autowired
	ActivityService activityService;
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
    public String studentPage(ModelMap model) {
		
		Student student = (Student) userService.getUserByLogin(helper.getPrincipal());
		model.addAttribute("userId", student.getIdUser()); 
        model.addAttribute("user", helper.getPrincipal());        
        return "student";
    }
	
	@RequestMapping(value="/student/profile" , method = RequestMethod.GET)
	public String studentProfilePage(Model model){		
		
		Student user = (Student)userService.getUserByLogin(helper.getPrincipal());
		model.addAttribute("user", user);
		model.addAttribute("userId", user.getIdUser());
		model.addAttribute("userContext", "student");
		return "user-profile-page";
	}
	
	@RequestMapping(value="/student/create/activity" , method = RequestMethod.GET)
	public String studentActivityPage(Model model){		
		
		User user = userService.getUserByLogin(helper.getPrincipal());
		model.addAttribute("activity", new Activity());
		model.addAttribute("userId", user.getIdUser());
		model.addAttribute("action", "create");
		model.addAttribute("activities", activityService.getUserActivities(user.getIdUser()) );
		model.addAttribute("userContext", "student");
		return "user-activity-page";
	}
	
	@RequestMapping(value="/student/edit/activity" , method = RequestMethod.GET)
	public String studentEditActivityPage(Model model,@RequestParam int idActivity){		
		
		User user = userService.getUserByLogin(helper.getPrincipal());
		model.addAttribute("activity", activityService.getById(idActivity));
		model.addAttribute("userId", user.getIdUser());
		model.addAttribute("action", "update");
		model.addAttribute("activities", activityService.getUserActivities(user.getIdUser()));
		model.addAttribute("userContext", "student");
		return "user-activity-page";
	}
	
	@RequestMapping(value = "/student/set/schedule", method = RequestMethod.GET)
    public String studentSetSchedulePage(ModelMap model) {
    	
		Student student = (Student) userService.getUserByLogin(helper.getPrincipal());
		
		model.addAttribute("schedule", scheduleService.getStudentSchedule(student.getIdUser()));
		
		model.addAttribute("subjects", subjectService.getAllSubjects());
		model.addAttribute("colors", colorService.getAllSubjectColors());
		model.addAttribute("teachers", userService.getTeachers());
		
        return "student-set-schedule";
    }
	
	@RequestMapping(value = "/student/update/schedule", method = RequestMethod.POST)
    public String studentSetSchedule(@RequestParam int idTeacher,@RequestParam int idSubject,@RequestParam int idColor) {
    	
		try{
			
			Student student = (Student) userService.getUserByLogin(helper.getPrincipal());
			
			Subject subject = subjectService.getBySubjectId(idSubject);
			SubjectColor color = colorService.getBySubjectColorId(idColor);
			Teacher teacher = (Teacher) userService.getUserById(idTeacher);
			
			ScheduleAssoc assoc = new ScheduleAssoc();
			
			assoc.setStudent(student);
			assoc.setSubject(subject);
			assoc.setTeacher(teacher);
			assoc.setSubjectColor(color);
			
			scheduleService.createScheduleAssoc(assoc);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
        return "redirect:/student/set/schedule";
    }
	
	@RequestMapping(value = "/student/delete/schedule", method = RequestMethod.GET)
    public String deleteSubjectColor(@RequestParam int idScheduleAssoc) {
    	
		ScheduleAssoc part = scheduleService.getByScheduleAssocId(idScheduleAssoc);
		
		if(part != null)
			scheduleService.deleteScheduleAssoc(part);
		
		return "redirect:/student/set/schedule";
    }
	
	@RequestMapping(value = "/student/homeworks", method = RequestMethod.GET)
    public String getHomeworksPage(ModelMap model) {
		
		Student student = (Student) userService.getUserByLogin(helper.getPrincipal());
		model.addAttribute("homeworks", assignementService.getStudentHomeworks(student.getIdUser()));
		
        return "student-homeworks";
    }
	
	@RequestMapping(value = "/student/set-done", method = RequestMethod.GET)
    public String setHomeworkAsDone(@RequestParam int idHomework) {
		
		Student student = (Student) userService.getUserByLogin(helper.getPrincipal());
		HomeworkAssignement assignement = assignementService.getHomeworkAssignmentofStudent(idHomework, student.getIdUser());
		assignement.setDone(true);
		assignementService.updateHomeworkAssignement(assignement);
		
        return "redirect:/student/homeworks";
    }
	
	@RequestMapping(value = "/student/dashboard", method = RequestMethod.GET)
    public String getDashboardPage(ModelMap model,@RequestParam int day) {
		
		Student student = (Student) userService.getUserByLogin(helper.getPrincipal());
		int idStudent = student.getIdUser();
		
		if(day == 0) 
			day = LocalDate.now().getDayOfWeek();
		
		model.addAttribute("toDayWeek", day);		
		model.addAttribute("idStudent", idStudent);
		
		return "student-dashboard";
    }
	
}
