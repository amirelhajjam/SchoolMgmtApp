package edu.school.mgmt.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("TEACHER")
public class Teacher extends User {

	@OneToMany(mappedBy="teacher")
	private List<ScheduleAssoc> scheduleAssocs = new ArrayList<ScheduleAssoc>();    
	
	public Teacher() {
		super();
	}
	
	public Teacher(String login, String password) {
		super(login, password);
	}

	public List<ScheduleAssoc> getScheduleAssocs() {
		return scheduleAssocs;
	}

	public void setScheduleAssocs(List<ScheduleAssoc> scheduleAssocs) {
		this.scheduleAssocs = scheduleAssocs;
	}
	
}
