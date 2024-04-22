
package com.llbafaci.blocolo.entities;

import java.util.ArrayList;

public class Student {
    private int studentCode;
    private String firstName;
    private String lastName;
    private ArrayList<String> capabilities;

    public Student(
            int studentCode,
            String firstName,
            String lastName,
            ArrayList<String> capabilities) {
        this.studentCode = studentCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.capabilities = capabilities;
    }

    public int getStudentCode() {
        return this.studentCode;
    }

    public String getFirstName() {
        return this.firstName;
    };

    public String getLastName() {
        return this.lastName;
    }

    public ArrayList<String> getCapabilities() {
        return this.capabilities;
    }

    @Override
    public String toString() {
        return "Legajo: " + studentCode + " Nombre: " + firstName + " Apellido: " + lastName + " Habilidades: " + capabilities.toString();
    }
}
