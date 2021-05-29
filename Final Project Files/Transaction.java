// Transaction.java - Stores informations regarding transactions that have been carried out by the ATM - Ali Ahmed
package edu.sdccd.cisc191;

public class Transaction {
    private double initbal;
    private double balance;
    private double finalbal;
    private String memo;
    private boolean suboradd;

    public Transaction(double ibal, double fbal, double bal, String m, boolean deporwith) {
        balance = bal;
        initbal = ibal;
        finalbal = fbal;
        memo = m;
        suboradd = deporwith;

    }

    public String getMemo() {
        return memo;
    }

    public double getBalance() {
        return balance;
    }

    public double getInitbal() {
        return initbal;
    }

    public double getFinalbal() {
        return finalbal;
    }

    public boolean isSuboradd() {
        return suboradd;
    }
    public void DatabaseforTransaction() {
        System.out.println("Initial Balance: " + initbal);
        if (suboradd == true) {
            System.out.println("Withdrawal Balance: -" + balance);
        }
        else {
            System.out.println("Deposit Balance: +" + balance);
        }
        System.out.println("Memo: " + memo);
        System.out.println();
    }
}
