package com.llbafaci.blocolo.helpers;

import com.llbafaci.blocolo.dtos.StudentDto;
import com.llbafaci.blocolo.dtos.TaskDto;

public class TableCreatorHelper {
    public static void createTablesIfNotExist() {
        StudentDto.createTableIfNotExist();
        TaskDto.createTableIfNotExist();
    }
}
