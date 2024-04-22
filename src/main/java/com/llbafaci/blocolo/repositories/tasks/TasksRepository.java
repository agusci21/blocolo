package com.llbafaci.blocolo.repositories.tasks;

import java.util.ArrayList;

import com.llbafaci.blocolo.entities.Task;

public class TasksRepository implements ITasksRepository {

    private ArrayList<Task> tasks = new ArrayList<Task>();

    @Override
    public ArrayList<Task> getAllTasks() {
        return tasks;
    }

    @Override
    public void createTask(Task task) {
        tasks.add(task);
    }

}
