package com.example;

import java.text.DecimalFormat;
import java.util.*;

public class Menu extends Account{
    Scanner menuInput=new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$' ###,##0.00");

    HashMap<Integer,Integer> data = new HashMap<>();

    public void getLogin() {
        int x=1;
        data.put(12345,123);
        data.put(56789,123);
        do{
            try {
                System.out.println("Welcome to ATM Project! ");

                System.out.println("Enter your Id :");
                setUserId(menuInput.nextInt());

                System.out.println("Enter your password :");
                setUserPassword(menuInput.nextInt());

            }
            catch (Exception e){
                System.out.print("\n Invalid characters.\n Only numbers allowed \n");
                //getLogin();
                x=0;
            }

            data.forEach((key,value)->{
                if (key==getUserId() && value==getUserPassword()){
                    getAccountType();
                }

            });

            System.out.println("\n\n Wrong Customer ID or Password. \n\n");
            //getLogin();

        }while(x==1);
    }

    public void getAccountType(){
        System.out.println("Select Account type you want to Access ");
        System.out.println("Select 1 : Checking Account ");
        System.out.println("Select 2 : Savings Account ");
        System.out.println("Select 3 : Exit ");

        System.out.println("Enter your Option : ");
        int option = menuInput.nextInt();

        switch (option) {
            case 1 -> getCheckingAccount();
            case 2 -> getSavingAccount();
            case 3 -> {
                System.out.println("\n Thanks for using ATM services ");
                getLogin();
            }
            default -> {
                System.out.println(" Invalid choice ");
                getAccountType();
            }
        }
    }

    public void getCheckingAccount(){
        System.out.println("Checking Account : ");
        System.out.println("Select 1 : View Balance ");
        System.out.println("Select 2 : Withdraw Funds ");
        System.out.println("Select 3 : Deposit Funds ");
        System.out.println("Select 4 : Exit ");

        System.out.println("Enter your Option : ");
        int option = menuInput.nextInt();

        switch (option) {
            case 1 -> {
                System.out.println("Checking Account Balance : " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
            }
            case 2 -> {
                getCheckingWithdrawInput();
                getAccountType();
            }
            case 3 -> {
                getCheckingDepositInput();
                getAccountType();
            }
            case 4 -> System.out.println("\n Thanks for using ATM services ");
            default -> {
                System.out.println(" Invalid choice ");
                getCheckingAccount();
            }
        }
    }

    public void getSavingAccount(){
        System.out.println("Saving Account : ");
        System.out.println("Select 1 : View Balance ");
        System.out.println("Select 2 : Withdraw Funds ");
        System.out.println("Select 3 : Deposit Funds ");
        System.out.println("Select 4 : Exit ");

        System.out.println("Enter your Option : ");
        int option = menuInput.nextInt();

        switch (option) {
            case 1 -> {
                System.out.println("Savings Account Balance : " + moneyFormat.format(getSavingBalance()));
                getAccountType();
            }
            case 2 -> {
                getSavingWithdrawInput();
                getAccountType();
            }
            case 3 -> {
                getSavingDepositInput();
                getAccountType();
            }
            case 4 -> System.out.println("\n Thanks for using ATM services ");

            default -> {
                System.out.println(" Invalid choice ");
                getSavingAccount();
            }
        }
    }

}
