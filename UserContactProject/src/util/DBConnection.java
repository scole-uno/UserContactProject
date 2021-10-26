package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
   public static Connection connection = null;

   public static void getDBConnection() {
      System.out.println("-------- MySQL JDBC Connection Testing ------------");
      try {
         Class.forName("com.mysql.jdbc.Driver");
      } catch (ClassNotFoundException e) {
         System.out.println("Where is your MySQL JDBC Driver?");
         e.printStackTrace();
         return;
      }
      System.out.println("MySQL JDBC Driver Registered!");

      connection = null;
      try {
         ConfigProp.loadProperty();
         connection = DriverManager.getConnection(getURL(), getUserName(), getPassword());
      } catch (Exception e) {
         System.out.println("Connection Failed! Check output console");
         e.printStackTrace();
         return;
      }

      if (connection != null) {
      } else {
         System.out.println("Failed to make connection!");
      }
   }

   public static String getURL() {
      String url = ConfigProp.getProp("url");
      System.out.println("[DBG] URL: " + url);
      return url;
   }

   public static String getUserName() {
      String usr = ConfigProp.getProp("user");
      System.out.println("[DBG] URL: " + usr);
      return usr;
   }

   public static String getPassword() {
      String pwd = ConfigProp.getProp("password");
      System.out.println("[DBG] URL: " + pwd);
      return pwd;
   }

}