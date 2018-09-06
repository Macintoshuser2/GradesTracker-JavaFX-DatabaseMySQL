package com.macintoshuser2.tracker;

import javafx.beans.property.SimpleStringProperty;

public class Grade {
	SimpleStringProperty className;
	SimpleStringProperty classGrade;
	SimpleStringProperty teacherFirstName;
	SimpleStringProperty teacherLastName;
	SimpleStringProperty dateGradesChecked;
	
	public Grade() {
		className = new SimpleStringProperty();
		classGrade = new SimpleStringProperty();
		teacherFirstName = new SimpleStringProperty();
		teacherLastName = new SimpleStringProperty();
		dateGradesChecked = new SimpleStringProperty();
	}
	
	public String getClassName() {
		return className.get();
	}
	
	public void setClassName(String className) {
		this.className.set(className);
	}
	public String getClassGrade() {
		return classGrade.get();
	}
	public void setClassGrade(String classGrade) {
		this.classGrade.set(classGrade);
	}
	public String getTeacherFirstName() {
		return teacherFirstName.get();
	}
	public void setTeacherFirstName(String teacherFirstName) {
		this.teacherFirstName.set(teacherFirstName);
	}
	public String getTeacherLastName() {
		return teacherLastName.get();
	}
	public void setTeacherLastName(String teacherLastName) {
		this.teacherLastName.set(teacherLastName);
	}
	public String getDateGradesChecked() {
		return dateGradesChecked.get();
	}
	public void setDateGradesChecked(String dateGradesChecked) {
		this.dateGradesChecked.set(dateGradesChecked);
	}
}
