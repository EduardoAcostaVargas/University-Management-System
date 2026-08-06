package Students;

public class Student {
    final int id;
    String firstName;
    String lastName;
    String email;


    public Student(int id, String firstName, String lastName, String email){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString(){
        return "[" + firstName + ", " + lastName + "]";
    }

    public int getId() {
        return id;
    }
}
