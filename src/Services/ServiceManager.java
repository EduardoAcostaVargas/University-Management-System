package Services;

import Courses.Course;
import Persistence.DataStore;
import Persistence.PersistenceManager;
import Staff.Faculty;
import Students.Student;


import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ServiceManager {
    private static List<Faculty> facultyMembers;
    private static List<Student> students;
    private static List<Course> coursesOffered;

    private static final Scanner scanner = new Scanner(System.in);


    public static void run() {
        boolean isRunning = true;

        DataStore dataStore = PersistenceManager.loadData();
        facultyMembers = dataStore.getFacultyMembers();
        students = dataStore.getStudents();
        coursesOffered = dataStore.getCoursesOffered();

        while (isRunning) {
            System.out.println("----- University Management System -----");
            System.out.println("1. Members Menu");
            System.out.println("2. Courses Menu");
            System.out.println("3. Close System");

            System.out.print("Select an Option 1-3: ");
            int menuChoice = scanner.nextInt();
            scanner.nextLine();


            switch (menuChoice) {
                case 1:
                    membersMenu();
                    break;
                case 2:
                    coursesMenu();
                    break;
                case 3:
                    DataStore saveData = new DataStore();
                    saveData.setFacultyMembers(facultyMembers);
                    saveData.setStudents(students);
                    saveData.setCoursesOffered(coursesOffered);
                    PersistenceManager.saveData(saveData);
                    System.out.println("Shutting the System Down, Good Bye.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option, choose an option between 1-3.");
                    break;
            }
        }
    }

    //MEMBERS METHODS
    private static void membersMenu() {
        System.out.println("---------- Members Menu ----------");
        System.out.println("1. Add Member");
        System.out.println("2. View Members");
        System.out.println("3. Remove Member");
        System.out.println("4. Main Menu");

        System.out.print("Enter an option 1-4: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                addNewMember();
                break;
            case 2:
                viewMembers();
                break;
            case 3:
                removeMember();
                break;
            case 4:
                System.out.println("Exiting System, Good Bye.");

        }

    }

    private static void addNewMember() {
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

    private static void viewMembers() {
        System.out.println("What members do you like to see?");
        System.out.println("1) Faculty");
        System.out.println("2) Students");

        System.out.print("Enter an option 1-2: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        if (option == 1) {

            if (!facultyMembers.isEmpty()) {
                System.out.println("----- Faculty Members -----");

                for (Faculty faculty : facultyMembers) {
                    System.out.println(faculty.toString());
                }
            } else {
                System.out.println("List is Empty.");
            }

        } else if (option == 2) {

            if (!students.isEmpty()) {
                System.out.println("----- Students ------");

                for (Student student : students) {
                    System.out.println(student.toString());
                }
            } else {
                System.out.println("List is Empty.");
            }

        } else {
            System.out.println("Invalid option, please select 1-2.");
        }
    }

    private static void removeMember() {
        System.out.println("What member would you like to remove?");
        System.out.println("1) Faculty");
        System.out.println("2) Student");
        System.out.print("Select an Option 1-2: ");

        int option = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Member ID: ");
        int userToDeleteID = scanner.nextInt();
        scanner.nextLine();

        boolean removed;

        if (option == 1) {
            removed = facultyMembers.removeIf(faculty -> faculty.getId() == userToDeleteID );

        } else if (option == 2) {
            removed = students.removeIf(student -> student.getId() == userToDeleteID);
        } else {
            System.out.println("Invalid option, please select 1-2.");
            return;
        }

        if (removed) {
            System.out.println("Member deleted successfully.");
        } else {
            System.out.println("Member with ID: " + userToDeleteID + " not found.");
        }
    }

    //COURSES METHODS
    private static void coursesMenu() {
        System.out.println("---------- Courses Menu ----------");
        System.out.println("1. Add Course");
        System.out.println("2. View Courses");
        System.out.println("3. Delete Course");
        System.out.println("4. Main Menu");

        int option = scanner.nextInt();
        scanner.nextLine();


        switch (option) {
            case 1:
                addCourse();
                break;
            case 2:
                viewAllCourses();
                break;
            case 3:
                removeCourse();
                break;
            case 4:
                System.out.println("Returning to Main Menu");
                break;
        }
    }

    private static void addCourse() {
        System.out.println("---------- New Course ----------");

        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();

        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter course section: ");
        String courseSection = scanner.nextLine();

        System.out.print("Enter amount of course credits: ");
        int courseCredits = scanner.nextInt();
        scanner.nextLine();

        Course newCourse = new Course(courseCode, courseName, courseSection, courseCredits);
        coursesOffered.add(newCourse);

        System.out.println("---------- Course ----------");
        System.out.println(
                "Course code: " + courseCode +
                        "\nCourse name: " + courseName +
                        "\nCourse credits: " + courseCredits
        );
        System.out.println("Course added successfully.");
        System.out.println("----------------------------");
    }

    private static void viewAllCourses() {

        if (!coursesOffered.isEmpty()) {
            System.out.println("---------- Courses ----------");
            for (Course course : coursesOffered) {
                System.out.println(course.toString());
            }
        } else {
            System.out.println("No available courses at this moment.");
        }
    }

    private static void removeCourse() {
        System.out.print("Enter Course Code e.g.(CWEB1234, CNTS 1343): ");
        String courseToDeleteCode = scanner.nextLine();

        boolean removed = false;

        if (!coursesOffered.isEmpty()) {
            removed = coursesOffered.removeIf(course -> Objects.equals(course.getCourseCode(), courseToDeleteCode));
        }

        if (removed) {
            System.out.println("Course deleted successfully.");
        } else {
            System.out.println("Course with code: " + courseToDeleteCode + " not found.");
        }
    }
}
