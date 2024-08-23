package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class User {
    RoleTemplate roleTemplate;

    User(RoleTemplate roleTemplate){
        this.roleTemplate=roleTemplate;
    }
    Scanner scanner = new Scanner(System.in);
    public void userFeature(){
        System.out.println("Please Select Number");

        Scanner scanner = new Scanner(System.in);
        System.out.println("1) Withdraw");
        System.out.println("2) Deposit");
        System.out.println("3) Transfer");
        System.out.println("4) Check Balance");

        int selectNumber = scanner.nextInt();

        switch (selectNumber){
            case 1:
                withdraw();
                break;
            case 2:
                deposit();
                break;
            case 3:
                transfer();
                break;
            case 4:
                accountBalance();
                break;
            default:
                System.out.println("Invalid Number!! please Select Valid Number");
        }
    }
    public void withdraw(){

        System.out.print("Please Enter Withdraw Amount Rs: ");

        int amount = scanner.nextInt();

        try (Statement stmt = new DatabaseCon().createConnection().createStatement() ) {

            String query=  "UPDATE account SET balance = balance -"+String.valueOf(amount) +
                    " WHERE user_id ="+String.valueOf( roleTemplate.getUserId());

            int rs = stmt.executeUpdate(query);

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void deposit(){
        System.out.print("Please Enter Deposit Amount Rs: ");
        int depositAmount = scanner.nextInt();

        try (Statement stmt = new DatabaseCon().createConnection().createStatement() ) {

            String query=  "UPDATE account SET balance = balance +"+String.valueOf(depositAmount) +
                    " WHERE user_id ="+String.valueOf( roleTemplate.getUserId());

            int rs = stmt.executeUpdate(query);

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void transfer(){
        System.out.print("Please Enter Transfer Account Number: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Please Enter Transfer Amount RS: ");
        int transferamount = scanner.nextInt();

        try (Connection connection = new DatabaseCon().createConnection();
             Statement stmt = connection.createStatement() ) {


            String query1=  "UPDATE account SET balance = balance -"+String.valueOf(transferamount) +
                    " WHERE user_id ="+String.valueOf( roleTemplate.getUserId());
            String query2=  "UPDATE account SET balance = balance +"+String.valueOf(transferamount) +
                    " WHERE AccountNumber ="+String.valueOf( accountNumber);


            int rs1 = stmt.executeUpdate(query1);
            int rs2 = stmt.executeUpdate(query2);

            System.out.println("Transaction committed successfully.");

        }catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public void accountBalance(){

    }
}
