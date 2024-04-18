package repositories.students;

import java.util.ArrayList;
import entities.Student;;

public interface IStudentsRepository {
    ArrayList<Student> getAllStudents();
    void addStudent(Student student);
}
