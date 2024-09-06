/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentManagementApplication;

import java.util.ArrayList;
import java.util.Scanner;
import javax.lang.model.SourceVersion;

/**
 *
 * @author RC_Student_lab
 */
class Students {

    String id;
    String name;
    int age;
    String email;
    String course;

    public Students(String id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Email: " + email + ", Course: " + course;
    }

    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }
}

public class Studentz {
    private static ArrayList<Students> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Student Management Application");
            System.out.println("Enter 1 to Launch Menu or any other key to exit:");
            String input = scanner.nextLine();
            if (!input.equals("1")) {
                System.out.println("Exiting application...");
                break;
            }
            showMenu(); 
        }
    }

    private static void showMenu() {
        while (true) {
            System.out.println("Please select one of the following menu items:");
            System.out.println("1. Capture a new student");
            System.out.println("2. Search for a student");
            System.out.println("3. Delete a student");
            System.out.println("4. Print a student report");
            System.out.println("5. Exit application");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    captureNewStudent();
                    break;
                case "2":
                    searchForStudent();
                    break;
                case "3":
                    deleteStudent();
                    break;
                case "4":
                    printStudentReport();
                    break;
                case "5":
                    System.out.println("Exiting application...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void captureNewStudent() {
        System.out.println("Capture a new student:");
        System.out.print("Enter the student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter the student name: ");
        String name = scanner.nextLine();
        int age = getValidStudentAge();
        System.out.print("Enter the student email: ");
        String email = scanner.nextLine();
        System.out.print("Enter the student course: ");
        String course = scanner.nextLine();

        students.add(new Students(id, name, age, email, course));
        System.out.println("Student captured successfully!");
    }
   
        private static void searchForStudent() {
        System.out.print("Enter student ID to search: ");
        String id = scanner.nextLine();
        for (Students student : students) {
            if (student.id.equals(id)) {
                System.out.println("Student found: " + student);
                return;
            }
        }
        System.out.println("Student not found.");
        }

        private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        String id = scanner.nextLine();
        for (Students student : students) {
            if (student.id.equals(id)) {
                students.remove(student);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
        }
       
       
       
       
        private static int getValidStudentAge() {
        int age = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print("Enter the student age (must be 16 or older): ");
            String input = scanner.nextLine();
            try {
                age = Integer.parseInt(input);
                if (age >= 16) {
                    valid = true;
                } else {
                    System.out.println("Invalid age. Age must be 16 or older.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for age.");
            }
        }
        return age;
    }
       
        private static void printStudentReport() {
        System.out.println("Student Report:");
        for (Students student : students) {
            System.out.println(student);
        }
    }
}

