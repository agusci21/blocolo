package com.llbafaci.blocolo.repositories.tasks;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.llbafaci.blocolo.entities.Task;
import com.llbafaci.blocolo.dtos.TaskDto;
import com.llbafaci.blocolo.helpers.DatabaseConnection;
import com.llbafaci.blocolo.helpers.DatabaseInstance;

public class TasksRepository implements ITasksRepository {

     DatabaseConnection connection = DatabaseInstance.getInstance();

    @Override
    public ArrayList<Task> getAllTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            ResultSet result = connection.execute("SELECT * FROM tasks");
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String description = result.getString("description");
                String tags = result.getString("tags");

                TaskDto taskDto = new TaskDto(id, name, description, tags);
                tasks.add(Task.fromDto(taskDto));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener todas las tareas: " + e.getMessage());
        }
        return tasks;
    }

    @Override
    public void createTask(Task task) {
        try {
            TaskDto taskDto = task.toDto();
            String query = taskDto.toTable();
            connection.execute(query);
            System.out.println("Tarea creada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al crear la tarea: " + e.getMessage());
        }
    }
}
