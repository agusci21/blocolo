package com.llbafaci.blocolo.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

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
      Connection connection;

      try {
         connection = DriverManager.getConnection(url);
         if (connection == null) {
            System.out.println("No se ha conectado a la base de datos");
         }

         PreparedStatement preparedStatement = connection.prepareStatement("select * from students;");
         ResultSet result = preparedStatement.executeQuery();

         while (result.next()) {
            int studentCode = result.getInt("studentCode");
            String firstName = result.getString("firstName");
            String lastName = result.getString("lastName");
            String capabilities = result.getString("capabilities");

            System.out.println("Student Code: " + studentCode);
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Capabilities: " + capabilities);
            System.out.println("-------------------------");
         }
      } catch (Exception e) {
         System.out.println(e);
         System.out.println("ERROR");
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
