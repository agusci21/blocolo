package com.llbafaci.blocolo.repositories.studentTask;

import java.util.ArrayList;

import com.llbafaci.blocolo.entities.StudentTask;
import com.llbafaci.blocolo.entities.Task;

public interface IStudentTaskRepository {
    void addStudentTask(StudentTask studentTask);
    ArrayList<Task> getTasksPerStudent(int studentCode);
}
