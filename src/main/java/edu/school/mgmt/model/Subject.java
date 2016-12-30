package edu.school.mgmt.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Subject {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSubject;
	
	private String title;
	
	private String type;	
	
	@OneToMany(mappedBy="subject")
	private List<ScheduleAssoc> scheduleAssocs = new ArrayList<ScheduleAssoc>();
	
	public Subject() {
		super();
	}

	public int getIdSubject() {
		return idSubject;
	}

	public void setIdSubject(int idSubject) {
		this.idSubject = idSubject;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public List<ScheduleAssoc> getScheduleAssocs() {
		return scheduleAssocs;
	}

	public void setScheduleAssocs(List<ScheduleAssoc> scheduleAssocs) {
		this.scheduleAssocs = scheduleAssocs;
	}
}
