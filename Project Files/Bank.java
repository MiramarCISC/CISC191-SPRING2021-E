package edu.sdccd.cisc191;
import java.util.ArrayList;

public class Bank {
    public String bankName;
    public ArrayList<User> customers;
    public Bank(String bName, ArrayList<User> cust) {
        bankName = bName;
        customers = cust;
    }

    public ArrayList<User> getCustomers() {
        return customers;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public void addCustomer(User cust){
        customers.add(cust);
    }
}
