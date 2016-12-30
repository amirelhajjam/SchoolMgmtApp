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
public class HomeworkAssignement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHomeworkAssignement;
	
	@ManyToOne(cascade={  CascadeType.MERGE, CascadeType.DETACH })
	@LazyCollection(LazyCollectionOption.FALSE)
	private Student student;
	
	@ManyToOne(cascade={  CascadeType.MERGE, CascadeType.DETACH })
	@LazyCollection(LazyCollectionOption.FALSE)
	private Homework homework;
	
	public HomeworkAssignement() {
		super();
	}

	private boolean done = false;

	public int getIdHomeworkAssignement() {
		return idHomeworkAssignement;
	}

	public void setIdHomeworkAssignement(int idHomeworkAssignement) {
		this.idHomeworkAssignement = idHomeworkAssignement;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Homework getHomework() {
		return homework;
	}

	public void setHomework(Homework homework) {
		this.homework = homework;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
	
}
