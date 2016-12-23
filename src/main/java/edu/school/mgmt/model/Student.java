package edu.school.mgmt.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends User {
	
	private int year;
	
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

	
}
