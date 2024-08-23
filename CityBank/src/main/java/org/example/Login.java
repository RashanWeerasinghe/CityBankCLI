package org.example;

import java.sql.*;

public class Login {
    String userName;
    String password;
    Login(String userName,String password){
        this.userName=userName;
        this.password=password;
    }

    public RoleTemplate checkLogin(){

        boolean check = false;

        String usertypeDB = "";

        RoleTemplate roleTemplate = new RoleTemplate();

        try (Statement stmt = new DatabaseCon().createConnection() ) {
            String query = "SELECT * FROM user";
            ResultSet rs = stmt.executeQuery(query);
            String usernameDB = "";
            String passwordDB = "";
            int userId = 0;
            while (rs.next()) {
                usernameDB = rs.getString("username");
                passwordDB = rs.getString("password");
                usertypeDB = rs.getString("usertype");
                userId=rs.getInt("id");

                if(usernameDB.equals(userName) && passwordDB.equals(password)){
                    check = true;
                    break;
                }else {
                    check = false;
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

                roleTemplate.setUserType(usertypeDB);
                roleTemplate.setUserName(usernameDB);
                roleTemplate.setUserId(userId);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return roleTemplate;
    }
}
