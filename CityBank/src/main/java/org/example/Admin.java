package org.example;

import java.sql.*;
import java.util.Scanner;

public class Admin {

    Scanner scanner=new Scanner(System.in);
    public void adminFeature() {
        System.out.println("Please Select");
        System.out.println("1) Create User Account");
        System.out.println("2) Create Manager Account");
        System.out.print("Enter Number: ");
        int num = scanner.nextInt();

        if(num==1)
            createUser();
        else
            createManager();
    }
    public void createUser() {
        try (Connection connection = new DatabaseCon().createConnection();
             Statement stmt = connection.createStatement()) {

            System.out.println("Enter User Name: ");
            String userName = scanner.next();

            System.out.println("Enter User Password: ");
            String password = scanner.next();

            String query = "INSERT INTO USER (UserName, Password, UserType) VALUES ('"
                    + userName + "','" + password + "','USER')";

            // Execute the query
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void createManager(){
        try(Connection connection = new DatabaseCon().createConnection();
            Statement stmt = connection.createStatement();){

            System.out.println("Enter User Name: ");
            String userName = scanner.next();
            System.out.println("Enter User Password: ");
            String password=scanner.next();

            String Query = "INSERT INTO USER(UserName,Password,UserType) VALUES ('"
                    +userName+"','"+password+"','MANAGER') ";
            stmt.executeUpdate(Query);


        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


}
