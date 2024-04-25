package com.llbafaci.blocolo.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
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
      try {
         String url = "jdbc:sqlite:src/main/java/com/llbafaci/blocolo/data/data.db";
         connection = DriverManager.getConnection(url);

         System.out.println("Connection to SQLite has been established.");

      } catch (SQLException e) {
         System.out.println(e.getMessage());
      } finally {
         try {
            if (connection != null) {
               connection.close();
            }
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
         }
      }
   }

   public void execute(String query) {
      try {
         if (connection == null || connection.isClosed()) {
            System.out.println("No hay conexión a la base de datos.");
            return;
         }

         Statement statement = connection.createStatement();
         statement.execute(query);
         System.out.println("Query ejecutado correctamente.");
         statement.close();
      } catch (SQLException e) {
         System.out.println("Error al ejecutar el query: " + e.getMessage());
      }
   }
}
