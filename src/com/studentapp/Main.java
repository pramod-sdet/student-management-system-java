package com.studentapp;

public class Main {
    public static void main(String[] args) {
        System.out.println("********* Student Management System ***********");
        System.out.println("********* Welcome ***********");

        Student s1 = new Student("Pramod", 22, "S1");
        s1.enrollCourse("Java");
        s1.enrollCourse("DSA");
        System.out.println(s1);
        //s1.printStudentInfo();

        Student s2 = new Student("Ansh", 31, "S22");
        s2.enrollCourse("DSA");
        System.out.println(s2);

        Student s3 = new Student("Tim", 30, "S223");
        s2.enrollCourse("DevOps");


    }



}
