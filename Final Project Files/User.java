package edu.sdccd.cisc191;
import java.util.ArrayList;

public class User<T> {
    private T firstName;
    private T lastName;
    private T customerID;
    private int pin;
    ArrayList<Account> accounts;
    protected User() {

    }

    public User(T first, T last, T customer, int num, ArrayList<Account> acc) { //will add accounts when accounts class has been made
        firstName = first;
        lastName = last;
        customerID = customer;
        pin = num;
        accounts = acc;
    }

    public T getFirstName() {
        return firstName;
    }
    public T getLastName() {
        return lastName;
    }
    public T getCustomerID() {
        return customerID;
    }
    public int getPin() {
        return pin;
    }

    public void setCustomerID(T customerID) {
        this.customerID = customerID;
    }

    public void setFirstName(T firstName) {
        this.firstName = firstName;
    }

    public void setLastName(T lastName) {
        this.lastName = lastName;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void printDatabase() {
        System.out.println(customerID + ": " + firstName + " " + lastName + " - " + pin);
        System.out.println("Accounts: ");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(accounts.get(i).getName() + "- Balance: " + accounts.get(i).getBalance());
        }
    }



    public void setAccount(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }
    public ArrayList<Account> getAccount() {
        return accounts;
    }
    public void addAccount(Account a) {
        accounts.add(a);
    }


}
