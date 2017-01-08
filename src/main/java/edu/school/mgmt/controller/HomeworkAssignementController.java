package edu.school.mgmt.controller;

import java.util.List;
import java.util.Set;

import org.joda.time.LocalDate;
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
    public String assignHomework(Homework homework,@RequestParam int idSubject,@RequestParam String action) {
    	
		try{
			LocalDate date = homework.getDueDate().minusDays(1);
			Teacher teacher = null;
			Subject subject = null;
			
			if( action.equals("create") ){
				homework.setDate(date);
				homework.setCreationDate(new LocalDate());
				homeworkService.createHomework(homework);				
			}			
			
			teacher = (Teacher) userService.getUserByLogin(helper.getPrincipal());
			subject = subjectService.getBySubjectId(idSubject);
			homework.setTeacher(teacher);
			homework.setSubject(subject);
			homeworkService.updateHomework(homework);
			
			if( action.equals("create") ){
				Set<Student> students = scheduleService.getStudents(teacher.getIdUser(),subject.getIdSubject());
				HomeworkAssignement assignement;
				
				for(Student s : students){
					
					assignement = new HomeworkAssignement();
					assignement.setHomework(homework);
					assignement.setStudent(s);
					
					assignementService.createHomeworkAssignement(assignement);
				}			
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}       
        
        return "redirect:/teacher/homework";
    }

	@RequestMapping(value = "/teacher/delete/homework", method = RequestMethod.GET)
    public String deleteHomework(@RequestParam int idHomework) {
    	
		try{
			
			List<HomeworkAssignement> assignements = assignementService.getHomeworkAssignments(idHomework);
			for(HomeworkAssignement a : assignements)
				assignementService.deleteHomeworkAssignement(a);
			
			Homework homework = homeworkService.getByHomeworkId(idHomework);
			homework.setSubject(null);
			homework.setTeacher(null);
			
			homeworkService.deleteHomework(homework);
			
		}catch(Exception e){
			e.printStackTrace();
		}       
        
        return "redirect:/teacher/homework";
    }
	
	
}
