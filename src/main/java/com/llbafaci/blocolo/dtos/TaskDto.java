package com.llbafaci.blocolo.dtos;

import com.llbafaci.blocolo.helpers.DatabaseConnection;
import com.llbafaci.blocolo.helpers.DatabaseInstance;

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
    static DatabaseConnection connection = DatabaseInstance.getInstance();
    public static void createTableIfNotExist() {
    String query = "CREATE TABLE IF NOT EXISTS tasks (" +
            "id INTEGER PRIMARY KEY," +
            "name TEXT," +
            "description TEXT," +
            "tags TEXT)";
    
    try {
        connection.execute(query);
        System.out.println("Tabla 'tasks' creada exitosamente.");
    } catch (Exception e) {
        System.out.println("Error al crear la tabla 'tasks': " + e.getMessage());
    }
}

    public String toTable() {
        String query = "INSERT INTO tasks (id, name, description, tags) VALUES (" +
                id + ", '" +
                name + "', '" +
                description + "', '" +
                tags + "');";
        return query;
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
