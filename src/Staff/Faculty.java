package Staff;

public class Faculty {
    private int id;
    String facultyRole;
    String firstName;
    String lastName;
    String facultyEmail;

    public Faculty(int id, String facultyRole, String firstName, String lastName, String facultyEmail) {
        this.id = id;
        this.facultyRole = facultyRole;
        this.firstName = firstName;
        this.lastName = lastName;
        this.facultyEmail = facultyEmail;

    }

    @Override
    public String toString() {
        return "[" + firstName + ", " + lastName + "]";
    }

    public int getId() {
        return id;
    }

    public String getFacultyRole() {
        return facultyRole;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFacultyEmail() {
        return facultyEmail;
    }
}
