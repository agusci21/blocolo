package com.llbafaci.blocolo.helpers;

public class DatabaseInstance {
    private static DatabaseConnection databaseInstance = new ProductionDatabaseConnection(); //TODO! Liskov

    public static DatabaseConnection getInstance(){
        return databaseInstance;
    } 
}
