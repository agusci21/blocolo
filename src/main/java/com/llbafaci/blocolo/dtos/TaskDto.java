package com.llbafaci.blocolo.dtos;


public class TaskDto {
    private int id;
    private String name;
    private String description;
    private String tags;

    public TaskDto(
            int id,
            String name,
            String description,
            String tags) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }


    @Override
    public String toString() {
        return "Identificador: " + id + "\nNombre: " + name + "\nDescripcion: " + description + "\nEtiquetas: " + tags;
    }
}
