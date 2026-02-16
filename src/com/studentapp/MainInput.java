package com.studentapp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainInput {

    public static List<Student> studentList;

    public static void main(String[] args) {

        System.out.println("********* Student Management System ***********");
        System.out.println("********* Welcome ***********");

        studentList = new ArrayList<Student>();
        //Read input from the terminal
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student Name....");
        String name = scanner.next(); //if you want to read the input in String format you use next() method
        System.out.println("You have entered the name: " + name);

        // Read integer values from the console/terminal
        //the readInt()

        System.out.println("Enter Student Age....");
        int age = scanner.nextInt();//if you want to read the input in String format you use next() method
        System.out.println("Student Age is : " + age);

    }

    // ✅ Correct sortByName method
    private static void sortByName() {
        studentList.sort(Comparator.comparing(Student::getName));
        System.out.println("Sorted by Name:");
        studentList.forEach(System.out::println);
    }

    // ✅ Search method
    public static Student findStudentById(String studentId) {
        try {
            return studentList.stream()
                    .filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No Data Found"));

        } catch (RuntimeException e) {
            System.err.println("Student with ID " + studentId + " not found");
            return null;
        }
    }
}


