package presentation.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import entities.Student;
import entities.Task;
import repositories.students.*;
import repositories.tasks.*;

public class Menu implements IMenu {
    private IStudentsRepository studentsRepository;
    private ITasksRepository taskRepository;
    private Scanner scanner = new Scanner(System.in);

    public Menu(IStudentsRepository studentsRepository, ITasksRepository tasksRepostory) {
        this.studentsRepository = studentsRepository;
        this.taskRepository = tasksRepostory;
    }

    @Override
    public int printAllOptions() {
        System.out.println("---- Menu ----");
        System.out.println("1. Listar alumnos");
        System.out.println("2. Agregar alumno");
        System.out.println("3. Listar Tareas");
        System.out.println("4. Agregar Tarea");
        System.out.println("Alguna letra. Salir");

        String selectedOption = scanner.nextLine();
        try {
            return Integer.parseInt(selectedOption);
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public void printAllStudents() {
        System.out.println();
        System.out.println("----- Todos los alumnos -----");
        var students = studentsRepository.getAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
    }

    @Override
    public void createNewStudent() {
        System.out.println();
        System.out.println("----- Crear estudiante -----");
        System.out.println("Nombre: ");
        String firstName = scanner.nextLine();
        System.out.println("Apellido: ");
        String lastName = scanner.nextLine();
        int studentCode = getLastStudentCode() + 1;

        Student student = new Student(studentCode, firstName, lastName);
        studentsRepository.addStudent(student);
    }

    int getLastStudentCode() {
        int maxValue = 0;
        for (Student student : studentsRepository.getAllStudents()) {
            if (student.getStudentCode() > maxValue) {
                maxValue = student.getStudentCode();
            }
        }
        return maxValue;
    }

    int getLastTaskCode() {
        int maxValue = 0;
        for (Task task : taskRepository.getAllTasks()) {
            if (task.getId() > maxValue) {
                maxValue = task.getId();
            }
        }
        return maxValue;
    }

    @Override
    public void printAllTasks() {
        System.out.println();
        System.out.println("----- Tareas -----");
        for (Task task : taskRepository.getAllTasks()) {
            System.out.println(task);
        }
        System.out.println();
    }

    @Override
    public void createTask() {
        System.out.println(" ----- Crear Nueva Tarea -----");
        System.out.println("Titulo:");
        String title = scanner.nextLine();
        System.out.println("Descripcion: ");
        String description = scanner.nextLine();
        System.out.println("Etiquetas: (Ingreselas separadas por ,)");
        String tagsAsString = scanner.nextLine();
        String[] tags = tagsAsString.split(",");

        Task task = new Task(
                getLastTaskCode(),
                title,
                description,
                new ArrayList<String>(Arrays.asList(tags)));
        taskRepository.createTask(task);
    }
}
