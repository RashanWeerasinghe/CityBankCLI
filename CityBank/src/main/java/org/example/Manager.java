package org.example;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    RoleTemplate roleTemplate;
    public Manager(RoleTemplate roleTemplate) {
        this.roleTemplate=roleTemplate;
    }

    Scanner scanner = new Scanner(System.in);
    public void managerFeature(){
        System.out.println("Please Select Number");


        System.out.println("1) View Account List");
        System.out.println("2) View Account");

        int selectNumber = scanner.nextInt();

        if(selectNumber==1) {
            viewAccountList();
        } else {
            viewAccount();
        }
    }
    public List viewAccountList(){

        RoleTemplate roleTemplate = new RoleTemplate();

        try (Statement stmt = new DatabaseCon().createConnection().createStatement() ) {
            String query = "SELECT * FROM account";
            ResultSet rs = stmt.executeQuery(query);

            List<Account> accounts = new ArrayList<>();
            int count=1;
            while (rs.next()) {
                String Name = rs.getString("Name");
                String Address = rs.getString("Address");
                int PhoneNumber = rs.getInt("PhoneNumber");
                BigDecimal balance=rs.getBigDecimal("balance");
                int AccountNumber = rs.getInt("AccountNumber");
                int userId=rs.getInt("user_id");

                Account account=new Account();
                account.setName(Name);
                account.setAddress(Address);
                account.setPhoneNumber(PhoneNumber);
                account.setBalance(balance);
                account.setAccountNumber(AccountNumber);
                account.setUser_id(userId);

                accounts.add(account);



                System.out.println(" "+count+") "+"  Name: "+Name+"  AccountNumber: "+AccountNumber);

                count++;

            }

         return accounts;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void viewAccount(){
        List<Account> accounts=viewAccountList();
        System.out.println();
        System.out.print("You want see Account .Please Select ListNumber: ");
        int listNumber=scanner.nextInt();
        Account account=accounts.get(listNumber-1);
        System.out.println("Name: "+account.getName());
        System.out.println("Address: "+account.getAddress());
        System.out.println("Phone Number: "+account.getPhoneNumber());
        System.out.println("Balance: "+account.getBalance());
        System.out.println("Account Number: "+account.getAccountNumber());
        System.out.println("User ID: "+account.getUser_id());
    }
}
