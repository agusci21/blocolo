package com.llbafaci.blocolo.repositories.students;

import java.util.ArrayList;
import com.llbafaci.blocolo.entities.Student;


public interface IStudentsRepository {
    ArrayList<Student> getAllStudents();

    void addStudent(Student student);
}
