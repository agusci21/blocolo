package com.llbafaci.blocolo.dtos;

import com.llbafaci.blocolo.helpers.DatabaseConnection;
import com.llbafaci.blocolo.helpers.DatabaseInstance;

public class StudentTaskDto {

    private int taskId;
    private int studentId;

    

    public StudentTaskDto(int taskId, int studentId) {
        this.taskId = taskId;
        this.studentId = studentId;
    }

    public static void createTableIfNotExist() {
        String query = "CREATE TABLE IF NOT EXISTS studentsTasks (" +
                "studentId INTEGER NOT NULL," +
                "taskId INTEGER NOT NULL," +
                "PRIMARY KEY (studentId, taskId))";

        try {
            DatabaseConnection connection = DatabaseInstance.getInstance();
            connection.execute(query);
            System.out.println("Tabla 'StudentTask' creada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al crear la tabla 'StudentTask': " + e.getMessage());
        }
    }

    public String toTable() {
        String query = "INSERT INTO studentsTasks (studentId, taskId) VALUES (" +
                studentId + ", '" +
                taskId + "', ');";
        return query;
    }

    public int getTaskId() {
        return taskId;
    }

    public int getStudentId() {
        return studentId;
    }

}
