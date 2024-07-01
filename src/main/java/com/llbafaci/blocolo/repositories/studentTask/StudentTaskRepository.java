package com.llbafaci.blocolo.repositories.studentTask;

import com.llbafaci.blocolo.entities.StudentTask;
import com.llbafaci.blocolo.helpers.DatabaseConnection;
import com.llbafaci.blocolo.helpers.DatabaseInstance;

public class StudentTaskRepository implements IStudentTaskRepository {

    DatabaseConnection connection = DatabaseInstance.getInstance();

    @Override
    public void addStudentTask(StudentTask studentTask) {
        try {
            String query = studentTask.toDto().toTable();
            connection.execute(query);
        } catch (Exception e) {}

    }

}
