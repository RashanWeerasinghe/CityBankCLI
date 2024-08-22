package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
          String DB_URL = "jdbc:mysql://localhost:3306/citybank";
          String DB_USERNAME = "root";
          String DB_PASSWORD = "1234";

        System.out.println("City Bank System");
        System.out.println();
        System.out.print("Enter your User Name: ");
        Scanner scanner=new Scanner(System.in);
        String userName=scanner.next();
        System.out.print("Enter Your Password: ");
        String password=scanner.next();


        boolean check=false;
        String usertypeDB="USER";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             Statement stmt = conn.createStatement();) {
            String query = "SELECT * FROM user";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String usernameDB = rs.getString("username");
                String passwordDB = rs.getString("password");
                usertypeDB = rs.getString("usertype");


                if(usernameDB.equals(userName) && passwordDB.equals(password)){
                    check=true;
                    break;
                }else {
                    check=false;

                }

            }


            if(!check)
                System.out.println("Invalid credential");
            else {
                switch (usertypeDB){
                    case "USER":
                        System.out.println("Welcome to User DashBoard");
                        break;
                    case "MANAGER":
                        System.out.println("Welcome to Manager Dashboard");
                        break;
                    case "ADMIN":
                        System.out.println("Welcome to Admin Dashboard");
                        break;
                    default:
                        break;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}