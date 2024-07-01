package com.llbafaci.blocolo.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnection {
   private String url;

   private Connection connection = null;

   protected DatabaseConnection(String url) {
      this.url = url;
   }
   protected DatabaseConnection() {
      this.url = "jdbc:sqlite:D:/blocolo.db";
   }

   public void connectToDatabase() {

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


