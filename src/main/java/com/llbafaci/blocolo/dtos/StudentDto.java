package com.llbafaci.blocolo.dtos;

import com.llbafaci.blocolo.helpers.*;

public class StudentDto {
    private int studentCode;
    private String firstName;
    private String lastName;
    private String capabilities;

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