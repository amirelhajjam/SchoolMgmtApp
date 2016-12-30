package edu.school.mgmt.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class ScheduleAssoc {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int idScheduleAssoc;
	
	@ManyToOne(cascade={  CascadeType.MERGE, CascadeType.DETACH })
	@LazyCollection(LazyCollectionOption.FALSE)
	private Subject subject;
	
	@ManyToOne(cascade={  CascadeType.MERGE, CascadeType.DETACH })
	@LazyCollection(LazyCollectionOption.FALSE)
	private SubjectColor subjectColor;
	
	@ManyToOne(cascade={  CascadeType.MERGE, CascadeType.DETACH })
	@LazyCollection(LazyCollectionOption.FALSE)
	private Student student;
	
	@ManyToOne(cascade={  CascadeType.MERGE, CascadeType.DETACH })
	@LazyCollection(LazyCollectionOption.FALSE)
	private Teacher teacher;

	public Subject getSubject() {
		return subject;
	}
	
	public int getIdScheduleAssoc() {
		return idScheduleAssoc;
	}

	public void setIdScheduleAssoc(int idScheduleAssoc) {
		this.idScheduleAssoc = idScheduleAssoc;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public SubjectColor getSubjectColor() {
		return subjectColor;
	}

	public void setSubjectColor(SubjectColor subjectColor) {
		this.subjectColor = subjectColor;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}	
	
}
