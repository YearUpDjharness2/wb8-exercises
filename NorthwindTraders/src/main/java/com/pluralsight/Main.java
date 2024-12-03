package com.pluralsight;

import java.sql.*;

public class Main {
        public static void main(String[] args) throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // load the MySQL Driver
            // Class.forName("com.mysql.cj.jdbc.Driver");
            // 1. open a connection to the database
            // use the database URL to point to the correct database
            Connection connection;
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/northwind",
                    "root",
                    "yearup");
            // create statement
            // the statement is tied to the open connection
            Statement statement = connection.createStatement();
            // define your query
            String query = "select * from northwind.products;";
            // 2. Execute your query
            ResultSet results = statement.executeQuery(query);
            // process the results
            while (results.next()) {
                String productname = results.getString("productname");
                System.out.println(productname);
            }
            // 3. Close the connection
            statement.close();
            results.close();
            connection.close();


        }
    }