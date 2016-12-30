package edu.school.mgmt.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends User {
	
	private int year;
	
	@OneToMany(mappedBy="student")
	private List<ScheduleAssoc> scheduleAssocs = new ArrayList<ScheduleAssoc>();
	
	@OneToMany(mappedBy="student")
	private List<HomeworkAssignement> homeworkAssignements = new ArrayList<HomeworkAssignement>();
	
	public Student() {
		super();
	}

	public Student(String login, String password) {
		super(login, password);
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public List<ScheduleAssoc> getScheduleAssocs() {
		return scheduleAssocs;
	}

	public void setScheduleAssocs(List<ScheduleAssoc> scheduleAssocs) {
		this.scheduleAssocs = scheduleAssocs;
	}

	public List<HomeworkAssignement> getHomeworkAssignements() {
		return homeworkAssignements;
	}

	public void setHomeworkAssignements(
			List<HomeworkAssignement> homeworkAssignements) {
		this.homeworkAssignements = homeworkAssignements;
	}
	
}
