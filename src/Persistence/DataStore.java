package Persistence;


import Courses.Course;
import Staff.Faculty;
import Students.Student;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
    private List<Faculty> facultyMembers;
    private List<Student> students;
    private List<Course> coursesOffered;

    public DataStore() {
        this.facultyMembers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.coursesOffered = new ArrayList<>();
    }

    public List<Faculty> getFacultyMembers() {
        return facultyMembers;
    }

    public void setFacultyMembers(List<Faculty> facultyMembers) {
        this.facultyMembers = facultyMembers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCoursesOffered() {
        return coursesOffered;
    }

    public void setCoursesOffered(List<Course> coursesOffered) {
        this.coursesOffered = coursesOffered;
    }
}
