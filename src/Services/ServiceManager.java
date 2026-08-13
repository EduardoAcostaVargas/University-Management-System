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
            System.out.println("3) Remove Member");
            System.out.println("4) Exit");

            System.out.print("Enter an option 1-4: ");
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
                    removeMember();
                    break;
                case 4:
                    System.out.println("Exiting System, Good Bye.");
                    isRunning = false;
                    break;

            }
        }

        scanner.close();
    }

    private static void addNewMember() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("---------- New Member ----------");

        System.out.print("Enter New Member ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter New Member Role e.g.(Professor, Student, Clerk): ");
        String memberRole = scanner.nextLine();

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        if (!memberRole.equalsIgnoreCase("Student")) {
            Faculty newFaculty = new Faculty(id, memberRole, firstName, lastName, email);
            facultyMembers.add(newFaculty);
        } else {
            Student newStudent = new Student(id, firstName, lastName, email);
            students.add(newStudent);
        }


        System.out.println("---------- New Member Added Successfully ----------");
        System.out.println("[Role: " + memberRole + ", Name: " + firstName + " " + lastName + "]");
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
            System.out.println("----- Faculty Members -----");

            for (Faculty faculty : facultyMembers) {
                System.out.println(faculty.toString());
            }

        } else if (option == 2 && !students.isEmpty()) {
            System.out.println("----- Students ------");

            for (Student student : students) {
                System.out.println(student.toString());
            }

        } else {
            System.out.println("List is Empty.");
        }
    }

    private static void removeMember() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What member would you like to remove?");
        System.out.println("1) Faculty");
        System.out.println("2) Student");
        System.out.print("Select an Option 1-2: ");

        int option = scanner.nextInt();
        scanner.nextLine();

        if (option == 1) {
            System.out.print("Enter Member ID: ");
            int userToDeleteID = scanner.nextInt();
            scanner.nextLine();
            facultyMembers.removeIf(faculty -> faculty.getId() == userToDeleteID);

        } else if (option == 2) {
            System.out.print("Enter Member ID: ");
            int userToDeleteID = scanner.nextInt();
            scanner.nextLine();
            students.removeIf(student -> student.getId() == userToDeleteID);
        } else {
            System.out.println("Member not found.");
        }
        System.out.println("Member deleted successfully.");

    }
}
