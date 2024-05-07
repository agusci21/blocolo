package com.llbafaci.blocolo.repositories.students;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.llbafaci.blocolo.dtos.StudentDto;
import com.llbafaci.blocolo.entities.Student;
import com.llbafaci.blocolo.helpers.DatabaseConnection;

public class StudentRepository implements IStudentsRepository {

    private DatabaseConnection connection = DatabaseConnection.getConnection();

    @Override
    public ArrayList<Student> getAllStudents() {
        ArrayList<StudentDto> studentsDtos = new ArrayList<>();
        try {
            connection.connectToDatabase();
            ResultSet result = connection.execute("SELECT * FROM STUDENTS");
            while (result.next()) {
                int studentCode = result.getInt("studentCode");
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");
                String capabilities = result.getString("capabilities");

                StudentDto student = new StudentDto(studentCode, firstName, lastName, capabilities);
                studentsDtos.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<Student> students = new ArrayList<>();

        for (StudentDto dto : studentsDtos) {
            students.add(Student.fromDto(dto));
            System.out.println(Student.fromDto(dto));
        }

        return students;
    }

    @Override
    public void addStudent(Student student) {
        try {
            String query = student.toDto().toTable();
            connection.execute(query);
        } catch (Exception e) {}
    }

}
