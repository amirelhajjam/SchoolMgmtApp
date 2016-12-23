package edu.school.mgmt.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TEACHER")
public class Teacher extends User {

	public Teacher() {
		super();
	}
	
	public Teacher(String login, String password) {
		super(login, password);
	}

}
