package com.llbafaci.blocolo.dtos;

import java.util.ArrayList;

import com.llbafaci.blocolo.helpers.*;

public class StudentDto {
    private int studentCode;

    public int getStudentCode() {
        return studentCode;
    }

    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    private String lastName;

    public String getLastName() {
        return lastName;
    }

    private String capabilities;

    public ArrayList<String> getCapabilities() {
        String[] capabilitiesArray = this.capabilities.split(",");
        ArrayList<String> capabilitiesList = new ArrayList<>();
        for (String capability : capabilitiesArray) {
            capabilitiesList.add(capability.trim());
        }
        return capabilitiesList;
    }

    public StudentDto(int studentCode, String firstName, String lastName, String capabilities) {
        this.studentCode = studentCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.capabilities = capabilities;
    }

    public static void createTableIfNotExist() {
        String query = "CREATE TABLE IF NOT EXISTS students (" +
                "studentCode INTEGER PRIMARY KEY," +
                "firstName TEXT," +
                "lastName TEXT," +
                "capabilities TEXT)";

        try {
            DatabaseConnection connection = DatabaseConnection.getConnection();
            connection.execute(query);
        } catch (Exception e) {
            System.out.println("could not create table student");
        }
    }
}