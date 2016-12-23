package edu.school.mgmt.forms;

import edu.school.mgmt.model.Student;
import edu.school.mgmt.model.Teacher;
import edu.school.mgmt.model.User;

public class RegistrationForm {
	
	protected String login;
	
	protected String password;
	
	protected String fullName;
	
	protected String schoolEmail;
	
	protected String position;
	
	protected String profession;
	
	protected String classRoomName;
	
	protected int year;

	public RegistrationForm() {
		super();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSchoolEmail() {
		return schoolEmail;
	}

	public void setSchoolEmail(String schoolEmail) {
		this.schoolEmail = schoolEmail;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String getClassRoomName() {
		return classRoomName;
	}

	public void setClassRoomName(String classRoomName) {
		this.classRoomName = classRoomName;
	}

	public User createUser(){
		
		
		User user = null;		
		
		if(profession.equals("STUDENT")){
		
			user = new Student();
			user.setFullName(fullName);
			user.setLogin(login);
			user.setPassword(password);
			user.setPosition(position);
			user.setSchoolEmail(schoolEmail);
			((Student) user).setYear(year);			
		
		}else if(profession.equals("TEACHER")){
		
			user = new Teacher();
			user.setFullName(fullName);
			user.setLogin(login);
			user.setPassword(password);
			user.setPosition(position);
			user.setSchoolEmail(schoolEmail);
					
		}
		return user;
	}
	
}
