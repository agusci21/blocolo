package com.llbafaci.blocolo.repositories.tasks;

import java.util.ArrayList;

import com.llbafaci.blocolo.entities.Task;


public interface ITasksRepository {
    ArrayList<Task> getAllTasks();

    void createTask(Task task);
}
