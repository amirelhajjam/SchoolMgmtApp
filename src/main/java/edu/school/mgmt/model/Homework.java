package edu.school.mgmt.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Homework {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHomework;
	
	private String title;
	
	private String description;
	
	private int duration;
	
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	@Column(name = "date", nullable = false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate date;
	
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	@Column(name = "dueDate", nullable = false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate dueDate;
	
	@OneToOne(cascade={  CascadeType.MERGE, CascadeType.DETACH })
	@LazyCollection(LazyCollectionOption.FALSE)
	private Subject subject;
	
	@OneToOne(cascade={  CascadeType.MERGE, CascadeType.DETACH })
	@LazyCollection(LazyCollectionOption.FALSE)
	private Teacher teacher;
	
	@OneToMany(mappedBy="homework")
	private List<HomeworkAssignement> homeworkAssignements = new ArrayList<HomeworkAssignement>();
	
	public Homework() {
		super();
	}

	public int getIdHomework() {
		return idHomework;
	}

	public void setIdHomework(int idHomework) {
		this.idHomework = idHomework;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<HomeworkAssignement> getHomeworkAssignements() {
		return homeworkAssignements;
	}

	public void setHomeworkAssignements(
			List<HomeworkAssignement> homeworkAssignements) {
		this.homeworkAssignements = homeworkAssignements;
	}
	
}
