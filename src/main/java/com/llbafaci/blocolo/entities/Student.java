
package com.llbafaci.blocolo.entities;

import java.util.ArrayList;

import com.llbafaci.blocolo.dtos.StudentDto;

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

    public StudentDto toDto() {
        String capabilitiesString = String.join(",", this.capabilities);
        return new StudentDto(this.studentCode, this.firstName, this.lastName, capabilitiesString);
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

    public static Student fromDto(StudentDto dto) {
        return new Student(dto.getStudentCode(), dto.getFirstName(), dto.getLastName(), dto.getCapabilities());
    }

    @Override
    public String toString() {
        return "Legajo: " + studentCode + " Nombre: " + firstName + " Apellido: " + lastName + " Habilidades: " + capabilities.toString();
    }
}
