package edu.school.mgmt.rest.model;

public class SubjectsRestModel implements Comparable<SubjectsRestModel> {

	private int idColor;
	
	private int startTime;
	
	private int id;
	
	private int finishTime;
	
	private int startTimeMinute;
	
	private int finishTimeMinute;
	
	private String day;
	
	private String week;
	
	private String subjectTitle;
	
	private String color;
	
	private String teacher;
	
	private String subject;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getStartTime() {
		return startTime;
	}

	public SubjectsRestModel() {
		super();
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getSubjectTitle() {
		return subjectTitle;
	}

	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}

	public int getStartTimeMinute() {
		return startTimeMinute;
	}

	public void setStartTimeMinute(int startTimeMinute) {
		this.startTimeMinute = startTimeMinute;
	}

	public int getFinishTimeMinute() {
		return finishTimeMinute;
	}

	public void setFinishTimeMinute(int finishTimeMinute) {
		this.finishTimeMinute = finishTimeMinute;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}
	
	public int getIdColor() {
		return idColor;
	}

	public void setIdColor(int idColor) {
		this.idColor = idColor;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public int compareTo(SubjectsRestModel a) {
		if (this.startTime <= a.getStartTime())
			return 1;
		else
			return 0;
	}
	
}
