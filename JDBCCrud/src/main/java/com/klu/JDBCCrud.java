package com.klu;

import java.sql.*;

public class JDBCCrud {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/fsad3";
        String user = "root";
        String pwd = "root";

        try {
            Connection con = DriverManager.getConnection(url, user, pwd);
            System.out.println("Connection done");

            Statement st = con.createStatement();
            String createDept =
                    "CREATE TABLE IF NOT EXISTS Dept (" +
                    "dept_id INT PRIMARY KEY AUTO_INCREMENT," +
                    "dept_name VARCHAR(20)" +
                    ")";
            st.execute(createDept);

            String createEmp =
                    "CREATE TABLE IF NOT EXISTS Emp (" +
                    "emp_id INT PRIMARY KEY AUTO_INCREMENT," +
                    "emp_name VARCHAR(50)," +
                    "sal DOUBLE," +
                    "dept_id INT," +
                    "FOREIGN KEY (dept_id) REFERENCES Dept(dept_id)" +
                    ")";
            st.execute(createEmp);
            System.out.println("Tables created");
            st.executeUpdate("INSERT INTO Dept (dept_name) VALUES ('HR')");
            st.executeUpdate("INSERT INTO Dept (dept_name) VALUES ('IT')");
            st.executeUpdate("INSERT INTO Dept (dept_name) VALUES ('Finance')");
            st.executeUpdate(
                    "INSERT INTO Emp (emp_name, sal, dept_id) VALUES ('Ravi', 50000, 1)");
            st.executeUpdate(
                    "INSERT INTO Emp (emp_name, sal, dept_id) VALUES ('Sita', 65000, 2)");
            st.executeUpdate(
                    "INSERT INTO Emp (emp_name, sal, dept_id) VALUES ('Ganesh', 55000, 2)");

            System.out.println("Values inserted");

            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
