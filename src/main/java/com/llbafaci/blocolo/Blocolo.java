
package com.llbafaci.blocolo;

import com.llbafaci.blocolo.helpers.ProductionDatabaseConnection;
import com.llbafaci.blocolo.helpers.TableCreatorHelper;
import com.llbafaci.blocolo.presentation.menu.*;
import com.llbafaci.blocolo.repositories.students.*;
import com.llbafaci.blocolo.repositories.tasks.*;



public class Blocolo {
    public static void main(String[] args) {

        var connection = new ProductionDatabaseConnection(); 

        // Dependencies
        IStudentsRepository studentsRepository = new StudentRepository(connection);
        ITasksRepository tasksRepository = new TasksRepository(connection);
        IMenu menu = new Menu(studentsRepository, tasksRepository);

        TableCreatorHelper.createTablesIfNotExist();

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
            } else if (selectedOption == 5) {
                menu.linkTaskWithStudent();
            } else {
                continue;
            }
        } while (selectedOption > 0);
        System.out.println("----- Hasta Luego -----");
    }
}
