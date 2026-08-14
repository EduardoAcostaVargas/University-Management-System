package Courses;

public class Course {
    String courseCode;
    String courseName;
    String courseSection;
    int courseCredits;

    public Course(String courseCode, String courseName, String courseSection, int courseCredits){
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseSection = courseSection;
        this.courseCredits = courseCredits;
    }
}
