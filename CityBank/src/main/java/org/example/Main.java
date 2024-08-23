package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.println("City Bank System");
        System.out.println();
        System.out.print("Enter your User Name: ");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();
        System.out.print("Enter Your Password: ");
        String password = scanner.next();

        Login login = new Login(userName,password);
        RoleTemplate roleTemplate = login.checkLogin();

        switch (roleTemplate.getUserType()){
            case "USER":
                System.out.println("Welcome to User DashBoard");
                User user = new User(roleTemplate);
                user.userFeature();
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
}