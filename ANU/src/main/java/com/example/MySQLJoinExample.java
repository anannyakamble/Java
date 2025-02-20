package com.example;
import java.sql.*;

public class MySQLJoinExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Anannya"; // Change 'your_database' to your actual DB name
        String user = "root";
        String password = "manager"; // No password as per your setup

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to MySQL database!");

            // SQL JOIN query
            String sql = "SELECT Employees.EmpID, Employees.EmpName, Departments.DeptName " +
                         "FROM Employees " +
                         "LEFT JOIN Departments ON Employees.DeptID = Departments.DeptID";

            // Execute query
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Display results
            System.out.println("\n📌 Employees and Their Departments:");
            System.out.println("-----------------------------------");
            while (rs.next()) {
                int empId = rs.getInt("EmpID");
                String empName = rs.getString("EmpName");
                String deptName = rs.getString("DeptName");

                System.out.printf("EmpID: %d | Name: %s | Dept: %s\n", empId, empName, (deptName != null ? deptName : "No Department"));
            }

            // Close resources
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("\n✅ Query execution completed!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
