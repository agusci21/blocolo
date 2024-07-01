
package com.llbafaci.blocolo;

import com.llbafaci.blocolo.helpers.ConsoleHelper;
import com.llbafaci.blocolo.helpers.DatabaseInstance;
import com.llbafaci.blocolo.helpers.NotOptimalConsoleHelper;
import com.llbafaci.blocolo.helpers.TableCreatorHelper;
import com.llbafaci.blocolo.presentation.menu.*;
import com.llbafaci.blocolo.repositories.studentTask.IStudentTaskRepository;
import com.llbafaci.blocolo.repositories.studentTask.StudentTaskRepository;
import com.llbafaci.blocolo.repositories.students.*;
import com.llbafaci.blocolo.repositories.tasks.*;

public class Blocolo {
    public static void main(String[] args) {

        // Dependencies
        ConsoleHelper consoleHelper = new NotOptimalConsoleHelper();
        DatabaseInstance.getInstance().connectToDatabase();

        IStudentsRepository studentsRepository = new StudentRepository();
        ITasksRepository tasksRepository = new TasksRepository();
        IStudentTaskRepository studentTaskRepository = new StudentTaskRepository();
        IMenu menu = new Menu(studentsRepository, tasksRepository, studentTaskRepository);

        TableCreatorHelper.createTablesIfNotExist();

        int selectedOption;
        do {
            consoleHelper.clearConsole();
            selectedOption = menu.printAllOptions();
            if (selectedOption == 1) {
                menu.printAllStudents();
            } else if (selectedOption == 2) {
                menu.createNewStudent();
            } else if (selectedOption == 3) {
                menu.printAllTasks();
            } else if (selectedOption == 4) {
                menu.createTask();
            } else if (selectedOption == 5) {
                menu.linkTaskWithStudent();
            } else {
                continue;
            }
            consoleHelper.awaitForTap();
        } while (selectedOption > 0);
        System.out.println("----- Hasta Luego -----");
    }
}
