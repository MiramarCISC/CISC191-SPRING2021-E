//Bank.java - Stores informations regarding Banks registered with the program/ATM - Brian Har
package edu.sdccd.cisc191;
import java.util.ArrayList;

public class Bank {
    private String bankName;
    private String bankPassword;
    private ArrayList<User> customers;
    public Bank(String bName, String bPass, ArrayList<User> cust) {
        bankName = bName;
        bankPassword = bPass;
        customers = cust;
    }

    public ArrayList<User> getCustomers() {
        return customers;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBankPassword() {
        return bankPassword;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setBankPassword(String bankPassword) {
        this.bankPassword = bankPassword;
    }

    public void addCustomer(User cust){
        customers.add(cust);
    }
    public int numOfCustomers() {
        return customers.size();
    }
}
