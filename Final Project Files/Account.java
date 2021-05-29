// Account.java - Stores informations regarding an account that is associated with a Customer - Abdulrahman Sinjab
package edu.sdccd.cisc191;
import java.util.ArrayList;

public class Account {
    private String name;
    private double balance;
    ArrayList<Transaction> transactions;

    public Account(String desc, double bal, ArrayList<Transaction> trans) {
        name= desc;
        balance = bal;
        transactions = trans;
    }

    //functions for transaction to use
    public void newTransaction(Transaction newt) {
        //needs to deduct or add to balance
        if(newt.isSuboradd() == true) {
            balance -= newt.getBalance();
        }
        else {
            balance += newt.getBalance();
        }
        transactions.add(newt);
    }

    //Functions for ATM to use
    public boolean checkAmount(double amou) {
        if (balance - amou < 0) {
            return false;
        }
        else {
            return true;
        }
    }

    public String getName() {
       return name;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}
