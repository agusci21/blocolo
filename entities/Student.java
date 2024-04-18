
package entities;


public class Student {
    private int studentCode;
    private String firstName;
    private String lastName;

    public Student(
            int studentCode,
            String firstName,
            String lastName) {
        this.studentCode = studentCode;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getStudentCode() {
        return this.studentCode;
    }

    String getFirstName() {
        return this.firstName;
    };

    String getLastName() {
        return this.lastName;
    }

    public String toJsonString () {
        return "{\n studentCode: " +studentCode + "\n firstName: " + firstName + "\n lastName: " + lastName + "\n}";
    }

    @Override 
    public String toString() {
        return  "Legajo: " + studentCode + " Nombre: " + firstName +" Apellido: " + lastName;
    }
}
