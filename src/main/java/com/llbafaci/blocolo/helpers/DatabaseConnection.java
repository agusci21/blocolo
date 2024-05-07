package com.llbafaci.blocolo.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnection {
   static private DatabaseConnection instance = new DatabaseConnection();

   static public DatabaseConnection getConnection() {
      return instance;
   }

   private Connection connection = null;

   private DatabaseConnection() {
   }

   public void connectToDatabase() {
      String url = "jdbc:sqlite:D:/blocolo.db";

      try {
         connection = DriverManager.getConnection(url);
         if (connection == null) {
            System.out.println("No se ha conectado a la base de datos");
         }

      } catch (Exception e) {
         System.out.println(e);
         System.out.println("ERROR");
      }
   }

   public ResultSet execute(String query) throws SQLException {
      if (connection == null || connection.isClosed()) {
         throw new SQLException("No hay conexión a la base de datos.");
      }

      Statement statement = connection.createStatement();
      return statement.executeQuery(query);
   }

}
