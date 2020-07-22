package com.example;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int id;
    private int password;
    private double checkingBalance=0;
    private double savingBalance=0;



    Scanner input =new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat(" '$ ' ###,##0.00");

    public void setUserId(int id){
        this.id = id;
    }

    public void setUserPassword(int password){
        this.password = password;
    }

    public int getUserId(){
        return id;
    }

    public int getUserPassword(){
        return password;
    }

    public double getCheckingBalance(){
        return checkingBalance;
    }

    public double getSavingBalance(){
        return savingBalance;
    }

    public double calcCheckingWithdraw(double amount){
        checkingBalance-=amount;
        return checkingBalance;
    }

    public double calcSavingWithdraw(double amount){
        savingBalance-=amount;
        return savingBalance;
    }

    public double calcCheckingDeposit(double amount){
        checkingBalance+=amount;
        return checkingBalance;
    }

    public double calcSavingDeposit(double amount){
        savingBalance+=amount;
        return savingBalance;
    }

    public void getCheckingWithdrawInput(){
        System.out.println("Your Checking Account balance : " + moneyFormat.format(checkingBalance));
        System.out.println("Enter the amount you want to withdraw : ");

        double withdrawAmount = input.nextDouble();

        if((checkingBalance- withdrawAmount)>=0){
            double amount = calcCheckingWithdraw(withdrawAmount);
            System.out.print("Your updated Checking Account balance is : " + moneyFormat.format(amount));
        }
        else{
            System.out.println("Please enter valid amount number. Account balance can not be negative");
        }

    }

    public void getSavingWithdrawInput(){
        System.out.println("Your Saving Account balance : " + moneyFormat.format(savingBalance));
        System.out.println("Enter the amount you want to withdraw : ");

        double withdrawAmount = input.nextDouble();

        if((savingBalance- withdrawAmount)>=0){
            double amount = calcSavingWithdraw(withdrawAmount);
            System.out.print("Your updated Savings Account balance is : " + moneyFormat.format(amount));
        }
        else{
            System.out.println("Please enter valid amount number. Account balance can not be negative");
        }

    }

    public void getCheckingDepositInput(){
        System.out.println("Your Checking Account balance : " + moneyFormat.format(checkingBalance));
        System.out.println("Enter the amount you want to deposit : ");

        double depositAmount = input.nextDouble();

        if((savingBalance+ depositAmount)>=0){
            double amount = calcCheckingDeposit(depositAmount);
            System.out.print("Your updated Checking Account balance is : " + moneyFormat.format(amount));
        }
        else{
            System.out.println("Please enter valid amount number. Account balance can not be negative");
        }

    }

    public void getSavingDepositInput(){
        System.out.println("Your Saving Account balance : " + moneyFormat.format(savingBalance));
        System.out.println("Enter the amount you want to withdraw : ");

        double depositAmount = input.nextDouble();

        if((savingBalance- depositAmount)>=0){
            double amount = calcSavingDeposit(depositAmount);
            System.out.print("Your updated Savings Account balance is : " + moneyFormat.format(amount));
        }
        else{
            System.out.println("Please enter valid amount number. Account balance can not be negative");
        }

    }

}
