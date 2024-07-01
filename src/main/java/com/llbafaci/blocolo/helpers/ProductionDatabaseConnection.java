package com.llbafaci.blocolo.helpers;

public class ProductionDatabaseConnection extends DatabaseConnection {
    public ProductionDatabaseConnection() {
       super("jdbc:sqlite:D:/blocolo_prod.db");
       System.out.println("Base de datos de produccion creada");
    }
}
