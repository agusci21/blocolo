package repositories.students;

import java.util.ArrayList;
import entities.Student;

public class StudentRepository implements IStudentsRepository {

    private ArrayList<Student> students = new ArrayList<Student>();

    @Override
    public ArrayList<Student> getAllStudents() {
        return students;
    }

    @Override
    public void addStudent(Student student) {
        this.students.add(student);
    }

}
