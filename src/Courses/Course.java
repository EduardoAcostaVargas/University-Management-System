package Courses;

public class Course {
    private String courseCode;
    private String courseName;
    private String courseSection;
    private int courseCredits;

    public Course(String courseCode, String courseName, String courseSection, int courseCredits){
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseSection = courseSection;
        this.courseCredits = courseCredits;
    }

    @Override
    public String toString(){
        return "Course Code: " + courseCode + ", Course Name: " + courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseSection() {
        return courseSection;
    }

    public int getCourseCredits() {
        return courseCredits;
    }
}
