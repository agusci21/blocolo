package com.llbafaci.blocolo.entities;

import java.util.ArrayList;
import java.util.Arrays;

import com.llbafaci.blocolo.dtos.TaskDto;

public class Task {
    private int id;
    private String name;
    private String description;
    private ArrayList<String> tags;

    public Task(
            int id,
            String name,
            String description,
            ArrayList<String> tags) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public static Task fromDto(TaskDto dto) {
        String[] tagsArray = dto.getTags().split(",");
        ArrayList<String> tagsList = new ArrayList<>(Arrays.asList(tagsArray));
        return new Task(dto.getId(), dto.getName(), dto.getDescription(), tagsList);
    }

    public TaskDto toDto() {
        StringBuilder tagsString = new StringBuilder();
        for (String tag : tags) {
            tagsString.append(tag).append(",");
        }
        String tagsStr = tagsString.toString();
        if (tagsStr.endsWith(",")) {
            tagsStr = tagsStr.substring(0, tagsStr.length() - 1);
        }
        return new TaskDto(id, name, description, tagsStr);
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Identificador: " + id + "\nNombre: " + name + "\nDescripcion: " + description + "\nEtiquetas: " + tags;
    }
}
