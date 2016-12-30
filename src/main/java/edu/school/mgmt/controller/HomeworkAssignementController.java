package edu.school.mgmt.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.school.mgmt.model.Homework;
import edu.school.mgmt.model.HomeworkAssignement;
import edu.school.mgmt.model.Student;
import edu.school.mgmt.model.Subject;
import edu.school.mgmt.model.Teacher;
import edu.school.mgmt.service.HomeworkAssignementService;
import edu.school.mgmt.service.HomeworkService;
import edu.school.mgmt.service.ScheduleAssocService;
import edu.school.mgmt.service.SubjectService;
import edu.school.mgmt.service.UserService;
import edu.school.mgmt.util.HelperUtils;

@Controller
public class HomeworkAssignementController {

	@Autowired
	HelperUtils helper;
	
	@Autowired
	HomeworkService homeworkService;
	
	@Autowired
	HomeworkAssignementService assignementService;
	
	@Autowired
	SubjectService subjectService;
	
	@Autowired
	ScheduleAssocService scheduleService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/teacher/assign/homework", method = RequestMethod.POST)
    public String assignHomework(Homework homework,@RequestParam int idSubject) {
    	
		try{
			homeworkService.createHomework(homework);
			
			Teacher teacher = (Teacher) userService.getUserByLogin(helper.getPrincipal());
			Subject subject = subjectService.getBySubjectId(idSubject);
			homework.setTeacher(teacher);
			homework.setSubject(subject);
			
			homeworkService.updateHomework(homework);
			
			Set<Student> students = scheduleService.getStudents(teacher.getIdUser(),subject.getIdSubject());
			HomeworkAssignement assignement;
			
			for(Student s : students){
				
				assignement = new HomeworkAssignement();
				assignement.setHomework(homework);
				assignement.setStudent(s);
				
				assignementService.createHomeworkAssignement(assignement);
			}			
			
		}catch(Exception e){
			e.printStackTrace();
		}       
        
        return "redirect:/teacher/homework";
    }
	
}
