package com.llbafaci.blocolo.repositories.studentTask;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.llbafaci.blocolo.dtos.TaskDto;
import com.llbafaci.blocolo.entities.StudentTask;
import com.llbafaci.blocolo.entities.Task;
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

    @Override
    public ArrayList<Task> getTasksPerStudent(int studentCode) {
        ArrayList<Task> tasks = new ArrayList<>();

        try {
           String query = "select tasks.* from tasks inner join studentsTasks on tasks.id = studentsTasks.\"taskId\" inner join students on students.\"studentCode\" = \"studentsTasks\".\"studentId\" where students.\"studentCode\" = " + studentCode + ";";
           ResultSet result = connection.execute(query);

           while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String description = result.getString("description");
                String tags = result.getString("tags");

                TaskDto taskDto = new TaskDto(id, name, description, tags);
                tasks.add(Task.fromDto(taskDto));
            }
        } catch (Exception e) {}
        return tasks;
    }

}
