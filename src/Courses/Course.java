package Courses;

public class Course {
    String courseCode;
    String courseName;
    String courseSection;
    String professorTeachingCourse;
    int courseCredits;

    public Course(String courseCode, String courseName, String courseSection, String professorTeachingCourse, int courseCredits){
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseSection = courseSection;
        this.professorTeachingCourse = professorTeachingCourse;
        this.courseCredits = courseCredits;
    }
}
