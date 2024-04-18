package repositories.tasks;

import java.util.ArrayList;

import entities.Task;

public interface ITasksRepository {
    ArrayList<Task> getAllTasks();
    void createTask(Task task);
}
