package com.llbafaci.blocolo.helpers;

import com.llbafaci.blocolo.dtos.StudentDto;

public class TableCreatorHelper {
    public static void createTablesIfNotExist() {
        StudentDto.createTableIfNotExist();
    }
}
