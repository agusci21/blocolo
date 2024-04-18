package entities;

import java.util.ArrayList;

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

    @Override
    public String toString() {
        return "Identificador: " + id + "\nNombre: " + name + "\nDescripcion: " + description + "\nEtiquetas: " + tags;
    }
}
