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
}
