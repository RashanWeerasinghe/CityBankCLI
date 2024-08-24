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
                User user = new User(roleTemplate);
                user.userFeature();
                break;
            case "MANAGER":
                Manager manager=new Manager(roleTemplate);
                manager.managerFeature();
                break;
            case "ADMIN":
                Admin admin=new Admin();
                admin.adminFeature();
                break;
            default:
                break;
        }


    }
}