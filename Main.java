import presentation.menu.*;
import repositories.students.IStudentsRepository;
import repositories.students.StudentRepository;
import repositories.tasks.ITasksRepository;
import repositories.tasks.TasksRepository;

public class Main {
    public static void main(String[] args) {
        // Dependencies
        IStudentsRepository studentsRepository = new StudentRepository();
        ITasksRepository tasksRepository = new TasksRepository();
        IMenu menu = new Menu(studentsRepository, tasksRepository);

        int selectedOption;
        do {
            selectedOption = menu.printAllOptions();
            if (selectedOption == 1) {
                menu.printAllStudents();
            } else if (selectedOption == 2) {
                menu.createNewStudent();
            } else if (selectedOption == 3) {
                menu.printAllTasks();
            } else if (selectedOption == 4) {
                menu.createTask();
            } else {
                continue;
            }
        } while (selectedOption > 0);
        System.out.println("----- Hasta Luego -----");
    }
}
