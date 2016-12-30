package edu.school.mgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.school.mgmt.model.ScheduleAssoc;
import edu.school.mgmt.model.Student;
import edu.school.mgmt.model.Subject;
import edu.school.mgmt.model.SubjectColor;
import edu.school.mgmt.model.Teacher;
import edu.school.mgmt.service.HomeworkAssignementService;
import edu.school.mgmt.service.ScheduleAssocService;
import edu.school.mgmt.service.SubjectColorService;
import edu.school.mgmt.service.SubjectService;
import edu.school.mgmt.service.UserService;
import edu.school.mgmt.util.HelperUtils;

@Controller
public class StudentController {

	@Autowired
	HelperUtils helper;
	
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
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
    public String studentPage(ModelMap model) {
		
		Student student = (Student) userService.getUserByLogin(helper.getPrincipal());
		model.addAttribute("userId", student.getIdUser()); 
        model.addAttribute("user", helper.getPrincipal());        
        return "student";
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
	
}
