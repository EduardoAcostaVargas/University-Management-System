package Services;

import Staff.Faculty;
import Students.Student;


import java.util.ArrayList;
import java.util.Scanner;

public class ServiceManager {
    private static ArrayList<Faculty> facultyMembers = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();


    public static void run() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("----- University Management System -----");
            System.out.println("1) Add New Member");
            System.out.println("2) See Members");
            System.out.println("3) Exit");

            System.out.print("Enter an option 1-3: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addNewMember();
                    break;
                case 2:
                    seeMembers();
                    break;
                case 3:
                    System.out.println("Exiting System, Good Bye.");
                    isRunning = false;
                    break;

            }
        }

        scanner.close();
    }

    private static void addNewMember(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("---------- New Member ----------");

        System.out.print("Enter New Member Role e.g.(Professor, Student, Clerk): ");
        String facultyRole = scanner.nextLine();

        System.out.print("Enter Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        if (!facultyRole.equalsIgnoreCase("Student")){
            Faculty newFaculty = new Faculty(facultyRole, firstName, lastName, email);
            facultyMembers.add(newFaculty);
        } else {
            Student newStudent = new Student(firstName, lastName, email);
            students.add(newStudent);
        }


        System.out.println("---------- New Member Added Successfully ----------");
        System.out.println("[Role: " + facultyRole + ", Name: " + firstName + " " + lastName + "]");
        System.out.println("---------------------------------------------------");
    }

    private static void seeMembers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What members do you like to see?");
        System.out.println("1) Faculty");
        System.out.println("2) Students");

        System.out.print("Enter an option 1-2: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        if (option == 1 && !facultyMembers.isEmpty()) {
            for( Faculty faculty : facultyMembers) {
                System.out.println("[" + faculty.toString() + "]");
            }
        } else {
           for (Student student : students) {
               System.out.println("[" + student.toString() + "]");
           }
        }
        System.out.println("List is Empty.");
    }
}
