package Staff;

public class Faculty {
    String facultyRole;
    String firstName;
    String lastName;
    String facultyEmail;

    public Faculty(String facultyRole, String firstName, String lastName, String facultyEmail) {
        this.facultyRole = facultyRole;
        this.firstName = firstName;
        this.lastName = lastName;
        this.facultyEmail = facultyEmail;

    }

    @Override
    public String toString(){
        return "[" + firstName + ", " + lastName + "]";
    }

}
