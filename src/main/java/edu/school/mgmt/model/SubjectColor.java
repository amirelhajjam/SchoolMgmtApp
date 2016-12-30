package edu.school.mgmt.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import edu.school.mgmt.rest.model.SubjectsRestModel;

@Entity
public class SubjectColor implements Comparable<SubjectColor> {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSubjectColor;
	
	private String day;
	
	private String color;
	
	private String week;
	
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalTime")
	private LocalTime startTime;
    
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalTime")
	private LocalTime finishTime;
    
    @OneToMany(mappedBy="student")
	private List<ScheduleAssoc> scheduleAssocs = new ArrayList<ScheduleAssoc>();
    
    public SubjectColor() {
		super();
	}

	public int getIdSubjectColor() {
		return idSubjectColor;
	}

	public void setIdSubjectColor(int idSubjectColor) {
		this.idSubjectColor = idSubjectColor;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(LocalTime finishTime) {
		this.finishTime = finishTime;
	}
	
	public List<ScheduleAssoc> getScheduleAssocs() {
		return scheduleAssocs;
	}

	public void setScheduleAssocs(List<ScheduleAssoc> scheduleAssocs) {
		this.scheduleAssocs = scheduleAssocs;
	}
	
	public String getFormattedStartTime() {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("HH:mm");
		return fmt.print(startTime);
	}
	
	public String getFormattedFinishTime() {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("HH:mm");
		return fmt.print(finishTime);
	}
	
	public SubjectsRestModel createSubjectsRestModel(){
		
		SubjectsRestModel model = new SubjectsRestModel();
		
		int startTime_ = startTime.getHourOfDay();		
		int finishTime_ = finishTime.getHourOfDay();
		int startTimeMinute_ = startTime.getMinuteOfHour();	
		int finishTimeMinute_ = finishTime.getMinuteOfHour();		
		
		model.setStartTime(startTime_);
		model.setFinishTime(finishTime_);
		model.setDay(getDay());			
		model.setColor(color);
		model.setStartTimeMinute(startTimeMinute_);
		model.setFinishTimeMinute(finishTimeMinute_);
		model.setWeek(week);
		model.setIdColor(idSubjectColor);
		
		return model;
	}

	@Override
	public int compareTo(SubjectColor arg0) {
		return startTime.compareTo(arg0.getStartTime());
	}
	
}
