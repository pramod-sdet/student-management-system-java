package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
	private String name;
	private int age;
	private String studentId;
	private List<String> courses;

	public Student(String name, int age, String studentId) {
		if (validateAge(age) && validateName(name) && validateStudentId(studentId)) {
			this.name = name;
			this.age = age;
			this.studentId = studentId;
			this.courses = new ArrayList<>();
		} else {
			throw new IllegalArgumentException("Invalid student details. Student not created.");
		}
	}

	public void enrollCourse(String course) {
		if (validateCourseName(course)) {
			if (!courses.contains(course)) {
				courses.add(course);
				System.out.println("Student is enrolled to the course " + course + " successfully");
			} else {
				System.out.println("Student is already enrolled to the course " + course);
			}
		}
	}

	public void printStudentInfo() {
		System.out.println("**** Student Information *****");
		System.out.println("Student Name: " + name);
		System.out.println("Student Age: " + age);
		System.out.println("Student ID: " + studentId);
		System.out.println("Enrolled For: " + courses);
	}

	@Override
	public String toString() {
		return "Student{" + "name='" + name + '\'' + ", age=" + age + ", studentId='" + studentId + '\'' + ", courses="
				+ courses + '}';
	}

	// Age Validation
	public boolean validateAge(int age) {
		if (age >= 19 && age <= 35) {
			return true;
		} else {
			System.out.println("Invalid age. Student age should be between 19 and 35");
			return false;
		}
	}

	// Name Validation
	public boolean validateName(String name) {
		String nameRegex = "^[a-zA-Z\\s]+$";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);
		if (nameMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid Name! Please enter alphabets only");
			return false;
		}
	}

	// Student ID Validation
	private boolean validateStudentId(String studentId) {
		String studentIDRegex = "^S-\\d+$"; // S1, S12, S100
		Pattern studentIDPattern = Pattern.compile(studentIDRegex);
		Matcher studentIDMatcher = studentIDPattern.matcher(studentId);
		if (studentIDMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid Student ID! Format should be like S1, S12, S100");
			return false;
		}
	}

	public boolean validateCourseName(String course) {
		if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("DevOps")) {

			return true;

		} else {
			System.err.println("Invalid Course Name Please select Course From the list[Java,DSA,DevOps]");
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}
}