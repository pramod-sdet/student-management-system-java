package com.studentapp;

import java.util.*;

public class Main {

    private static List<Student> studentList;
    private static Scanner scanner;

    public static void main(String[] args) {

        System.out.println("************* Student Management System *************");

        studentList = new ArrayList<>();
        scanner = new Scanner(System.in);

        while (true) {

            System.out.println("*********** Welcome ***********");

            System.out.println("Select an Option.....");
            System.out.println("1. Register a Student");
            System.out.println("2. Find Student with studentId");
            System.out.println("3. List All Student Information");
            System.out.println("4. List Student Information in Sorted Order");
            System.out.println("5. Exit");

            int option = scanner.nextInt();

            switch (option) {

                case 1:
                    enrollStudent(scanner);
                    break;

                case 2:
                    findStudentById(scanner);
                    break;

                case 3:
                    printAllStudentData();
                    break;

                case 4:
                    sortByName();
                    break;

                case 5:
                    exit();
                    break;

                default:
                    System.out.println("Invalid option selected!... Enter between 1 to 5");

            }
        }
    }

    private static void exit() {

        System.out.println("Good Bye!!!!");

        System.exit(0);
    }

    private static void sortByName() {

        studentList.sort(Comparator.comparing(Student::getName));

        printAllStudentData();
    }

    private static void printAllStudentData() {

        if (studentList.size() > 0) {

            System.out.println("------------------- PRINTING All Student Data -------------------");

            for (Student student : studentList) {

                student.printStudentInfo();

            }

            System.out.println("-------------------************************-------------------");

        } else {

            System.err.println("Student List is Empty!!! No Student Record Found!!");

        }
    }

    private static void enrollStudent(Scanner scanner2) {

        System.out.println("Enter the Student Name:");

        String studentName = scanner2.next();

        System.out.println("Enter the Student Age:");

        int studentAge = scanner2.nextInt();

        System.out.println("Enter the Student Id:");

        String studentId = scanner2.next();

        Student newStudent = new Student(studentName, studentAge, studentId);

        studentList.add(newStudent);

        while (true) {

            System.out.println("Enter the course to be enrolled: Type Done to Exit");

            String courseName = scanner2.next();

            if (courseName.equalsIgnoreCase("done")) {

                break;

            }

            newStudent.enrollCourse(courseName);
        }

        newStudent.printStudentInfo();
    }

    // UI method (Scanner input)
    private static void findStudentById(Scanner scanner2) {

        System.out.println("Enter the Student Id:");

        String studentId = scanner2.next();

        Student studentFound = findStudentById(studentId);

        if (studentFound != null) {

            studentFound.printStudentInfo();

        }
    }

    // Logic method (Reusable)
    public static Student findStudentById(String studentId) {

        Student result = null;

        try {

            result = studentList.stream()
                    .filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No Data found!!!"));

        } catch (RuntimeException e) {

            System.err.println("Student with ID " + studentId + " not found!!");

        }

        return result;
    }
}