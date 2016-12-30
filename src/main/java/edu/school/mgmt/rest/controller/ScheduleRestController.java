package edu.school.mgmt.rest.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.school.mgmt.model.ScheduleAssoc;
import edu.school.mgmt.model.SubjectColor;
import edu.school.mgmt.rest.model.SubjectsRestModel;
import edu.school.mgmt.service.ScheduleAssocService;
import edu.school.mgmt.service.SubjectColorService;
import edu.school.mgmt.service.UserService;

@RestController
public class ScheduleRestController {

	@Autowired
	UserService userService;
	
	@Autowired
	SubjectColorService colorService;
	
	@Autowired
	ScheduleAssocService scheduleService;
	
	@RequestMapping(value =  "/rest/global/schedule" , method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<SubjectsRestModel>> 
		getGlobalSchedule(@RequestParam String week) {
				
		List<SubjectColor> colors =  colorService.getAllSubjectColors();
		Collections.sort(colors);
		List<SubjectsRestModel> models = new ArrayList<SubjectsRestModel>();
		
		for(SubjectColor a : colors){
			if(a.getWeek().equals(week))
				models.add(a.createSubjectsRestModel());
		}
		
        return new ResponseEntity<List<SubjectsRestModel>>(models,HttpStatus.OK);
	}
	
	@RequestMapping(value =  "/rest/user/schedule" , method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<SubjectsRestModel>> 
		getUserSchedule(@RequestParam String week,@RequestParam int id) {
		
		List<SubjectColor> colors = new ArrayList<SubjectColor>();
		List<ScheduleAssoc> schedule = scheduleService.getStudentSchedule(id);
		String[] teachers = new String[schedule.size()];
		String[] subjects = new String[schedule.size()];
		int[] ids = new int[schedule.size()];
		int i = 0;
		
		for(ScheduleAssoc a: schedule){			
			if(a.getSubjectColor().getWeek().equals(week)){
				teachers[i] = a.getTeacher().getFullName();
				ids[i] = a.getTeacher().getIdUser();
				subjects[i] = a.getSubject().getTitle();
				colors.add(a.getSubjectColor());	
				i++;
			}			
		}		
		
		Collections.sort(colors);
		List<SubjectsRestModel> models = new ArrayList<SubjectsRestModel>();
		SubjectsRestModel restModel = null;
		i = 0;
		
		for(SubjectColor a : colors){
			restModel = a.createSubjectsRestModel();
			restModel.setTeacher(teachers[i]);
			restModel.setSubject(subjects[i]);
			restModel.setId(ids[i]);
			models.add(restModel);
			i++;
		}		
        return new ResponseEntity<List<SubjectsRestModel>>(models,HttpStatus.OK);
	}
	
	@RequestMapping(value =  "/rest/teacher/schedule" , method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<SubjectsRestModel>> 
		getTeacherSchedule(@RequestParam String week,@RequestParam int id) {
		
		List<SubjectColor> colors = new ArrayList<SubjectColor>();
		List<ScheduleAssoc> schedule = scheduleService.getTeacherSchedule(id);
		String[] subjects = new String[schedule.size()];
		int i = 0;
		
		for(ScheduleAssoc a: schedule){			
			if(a.getSubjectColor().getWeek().equals(week)){
				subjects[i] = a.getSubject().getTitle();
				colors.add(a.getSubjectColor());	
				i++;
			}			
		}		
		Collections.sort(colors);
		List<SubjectsRestModel> models = new ArrayList<SubjectsRestModel>();
		SubjectsRestModel restModel = null;
		i = 0;
		
		for(SubjectColor a : colors){
			restModel = a.createSubjectsRestModel();
			restModel.setSubject(subjects[i]);
			models.add(restModel);
			i++;
		}	
        return new ResponseEntity<List<SubjectsRestModel>>(models,HttpStatus.OK);
	}
	
}
