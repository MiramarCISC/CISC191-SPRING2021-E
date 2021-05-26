package edu.sdccd.cisc191;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class ATM {
    public static ArrayList<Bank> banks = new ArrayList<>();
    public static void main(String args[]) {
        Scanner a = new Scanner(System.in);
        int stopper = 0;
        while (stopper == 0) {
            String choice;
            System.out.println("Are you an Admin or as a Customer?");
            choice = a.nextLine();
            if (choice.equals("Admin")) {
                System.out.println("Are you an Existing Admin or a New Admin?");
                choice = a.nextLine();
                if (choice.equals("New Admin")) {
                    newAdmin();
                } //52737
                else {
                    Admin();
                }

            }
            else {
                System.out.println("Are you an Existing Customer or a New Customer?");
                choice = a.nextLine();
                if (choice.equals("New Customer")) {
                    newCustomer();
                }
                else {
                    Customer();
                }
            }
            System.out.println("Would you like to permanently terminate the program? \n(WARNING: Permanently terminating the program will delete all data that was passed to this program) \nType Yes or No.");
            String option = a.nextLine();
            if (option.equals("Yes")) {
                stopper = 1;
                System.exit(0);
            }

        }


    }
    public static void newCustomer() {
        Scanner a = new Scanner(System.in);
        Random test = new Random();
        System.out.println("Which Bank is this customer application for?");
        String bankname = a.nextLine();
        int bankcheck = 0;
        int bankid = 0;
        for (int i = 0; i < banks.size(); i++) {
            if (banks.get(i).getBankName().equals(bankname)) {
                bankid = i;
                bankcheck = 1;
                break;
            }
        }
        if (bankcheck == 0) {
            System.out.println("Error: Invalid Bank");
            return;
        }
        System.out.println("Welcome new Customer! What is your first name?");
        String firstname = a.nextLine();
        System.out.println("What is your last name?");
        String lastname = a.nextLine();
        System.out.println("What PIN do you want to set for your account?");
        int pin = a.nextInt();
        a.nextLine();
        System.out.println("How much would you like to deposit into your Checking account?");
        double checkbal = a.nextDouble();
        a.nextLine();
        ArrayList<Transaction> tran = new ArrayList<>();
        Account dep = new Account("Checking", checkbal, tran);
        System.out.println("How much would you like to deposit into your Saving account?");
        double savebal = a.nextDouble();
        a.nextLine();
        ArrayList<Transaction> trans = new ArrayList<>();
        Account sav = new Account("Savings", savebal, trans);
        ArrayList<Account> ac = new ArrayList<>();
        ac.add(dep);
        ac.add(sav);
        int stopper = 0;
        int bankcustid = -1;
        while (stopper == 0) {
            bankcustid = test.nextInt(90000) + 10000;
            int check = 0;
            for(int i = 0; i < banks.get(bankid).getCustomers().size(); i++) {
                if (banks.get(bankid).getCustomers().get(i).getCustomerID().equals(bankcustid)) {
                    check = 1;
                    break;
                }
            }
            if (check == 0) {
                stopper = 1;
                break;
            }
        }
        banks.get(bankid).addCustomer(new User(firstname, lastname, bankcustid, pin, ac));
        System.out.println("Congratulations! You have successfully registered as a member with " + bankname + "." + "Please write down your customer ID which is " + bankcustid);

    }

    /** Customer features to implement
     * Withdrawal
     * Deposit
     * See Transactions
     * Change Pin
     *
     */
    public static void Customer() {
        Scanner a = new Scanner(System.in);
        System.out.println("Bank?");
        String bankname = a.nextLine();
        int bankcheck = 0;
        int bankid = 0;
        for (int i = 0; i < banks.size(); i++) {
            if (banks.get(i).getBankName().equals(bankname)) {
                bankid = i;
                bankcheck = 1;
                break;
            }
        }
        if (bankcheck == 0) {
            System.out.println("Error: Invalid Bank");
            return;
        }
        System.out.println("Customer ID?");
        int custid = a.nextInt();
        System.out.println("PIN?");
        int custpin = a.nextInt();
        a.nextLine();
        int custcheck = 0;
        int custindex = 0;
        for (int i = 0; i < banks.size(); i++) {
            if (banks.get(bankid).getCustomers().get(i).getCustomerID().equals(custid)) {
                if (banks.get(bankid).getCustomers().get(i).getPin() == (custpin)) {
                    custcheck = 1;
                    custindex = i;
                    break;
                }
            }
        }
        if (custcheck == 0) {
            System.out.println("Error: Wrong ID or PIN");
            return;
        }
        int stopper = 0;
        while(stopper == 0) {
            System.out.println("Welcome " + banks.get(bankid).getCustomers().get(custindex).getFirstName() + "!" + ". Please choose the number corresponding to your desired option.");
            System.out.println("1). Withdraw balance from an account.");
            System.out.println("2). Deposit balance into an account.");
            System.out.println("3). Change PIN.");
            System.out.println("4). Check Transaction details");
            int choice = a.nextInt();
            a.nextLine();
            if (choice == 1) {
                ArrayList<Account> lister = banks.get(bankid).getCustomers().get(custindex).getAccount();
                System.out.println("To which account would you like to withdraw from? Checking or Savings?");
                String checker = a.nextLine();
                int select = -1;
                if (checker.equals("Checking")) {
                    select = 0;
                }
                else {
                    select = 1;
                }
                System.out.println("How much do you want to withdraw?");
                double amount = a.nextDouble();
                a.nextLine();

                if (lister.get(select).checkAmount(amount) == false) {
                    System.out.println("Error: Insufficient Funds to withdraw.");
                    return;
                }

                System.out.println("What is the memo?");
                String memo = a.nextLine();

                lister.get(select).newTransaction(new Transaction(lister.get(select).getBalance(),lister.get(select).getBalance() - amount, amount, memo, true));

            }
            if (choice == 2) {
                ArrayList<Account> lister = banks.get(bankid).getCustomers().get(custindex).getAccount();
                System.out.println("To which account would you like to deposit to? Checkings or Savings?");
                String checker = a.nextLine();
                int select = -1;
                if (checker.equals("Checkings")) {
                    select = 0;
                }
                else {
                    select = 1;
                }
                System.out.println("How much do you want to deposit?");
                double amount = a.nextDouble();
                a.nextLine();

                System.out.println("What is the memo?");
                String memo = a.nextLine();

                lister.get(select).newTransaction(new Transaction(lister.get(select).getBalance(),lister.get(select).getBalance() + amount, amount, memo, false));

            }
            if (choice == 3) {
                System.out.println("What is your current PIN?");
                int pincheck = a.nextInt();
                a.nextLine();
                if (pincheck == custpin) {
                    System.out.println("What is the new PIN?");
                    int newPIN = a.nextInt();
                    a.nextLine();
                    banks.get(bankid).getCustomers().get(custindex).setPin(newPIN);
                    custpin = banks.get(bankid).getCustomers().get(custindex).getPin();
                    System.out.println("PIN change is successful.");
                }
                else {
                    System.out.println("Error: Incorrect PIN");
                }

            }
            if (choice == 4) {
                System.out.println("Which Account would you like to see transaction details for? Checking or Savings");
                String option = a.nextLine();
                int checker = 0;
                ArrayList<Account> lister = banks.get(bankid).getCustomers().get(custindex).getAccount();
                if (option.equals("Checking")) {
                    for (int i = 0; i < lister.get(0).getTransactions().size(); i++) {
                        lister.get(0).getTransactions().get(i).DatabaseforTransaction();
                    }
                }
                else {
                    for (int i = 0; i < lister.get(1).getTransactions().size(); i++) {
                        lister.get(1).getTransactions().get(i).DatabaseforTransaction();
                    }
                }

            }
            System.out.println("Would you like to end your session? Type Yes or No.");
            String option = a.nextLine();
            if (option.equals("Yes")) {
                stopper = 1;
                return;
            }
        }


    }


    public static void newAdmin() {
        Scanner a = new Scanner(System.in);
        System.out.println("Welcome new Admin! What is the name of your Bank?");
        String name = a.nextLine();
        System.out.println("What password do you want to set for your admin account?");
        String pass = a.nextLine();
        ArrayList<User> cust = new ArrayList<>();
        banks.add(new Bank(name, pass, cust));
        System.out.println("Congratulations! You have successfully registered as a new admin!");
    }

    /** admin features to implement:
     * password check
     * Check number of Customers
     * Change Bank name
     * Change password
     * Check Customer details
     */
    public static void Admin() {
        Scanner a = new Scanner(System.in);
        System.out.println("Bank name?");
        String name = a.nextLine();
        System.out.println("Password?");
        String pass = a.nextLine();
        int check = 0;
        int bankid = 0;
        for (int i = 0; i < banks.size(); i++) {
            if (banks.get(i).getBankName().equals(name)) {
                if (banks.get(i).getBankPassword().equals(pass)) {
                    check = 1;
                    bankid = i;
                    break;
                }
            }
        }
        if (check == 0) {
            System.out.println("Error: Wrong Username or Password");
            return;
        }
        int stopper = 0;
        while(stopper == 0) {
            System.out.println("Welcome Admin of " + name + ". Please choose the number corresponding to your desired option.");
            System.out.println("1). Check how many customers are members with " + name + ".");
            System.out.println("2). Change the bank's name.");
            System.out.println("3). Change admin password.");
            System.out.println("4). Check customer's detail");
            int choice = a.nextInt();
            a.nextLine();
            if (choice == 1) {
                System.out.println("There are " + banks.get(bankid).numOfCustomers() + " customers serving as members with " + name + ".");
            }
            if (choice == 2) {
                System.out.println("What is the bank's new name?");
                String newname = a.nextLine();
                banks.get(bankid).setBankName(newname);
                name = banks.get(bankid).getBankName();
                System.out.println("The bank is now called " + name + ".");
            }
            if (choice == 3) {
                System.out.println("What is your current password?");
                String passcheck = a.nextLine();
                if (passcheck.equals(pass)) {
                    System.out.println("What is the new password?");
                    String newpass = a.nextLine();
                    banks.get(bankid).setBankPassword(newpass);
                    pass = banks.get(bankid).getBankPassword();
                    System.out.println("Password change is successful.");
                }
                else {
                    System.out.println("Error: Incorrect password");
                }

            }
            if (choice == 4) {
                System.out.println("Enter the customerID of the customer's details you would like to find");
                int custID = a.nextInt();
                a.nextLine();
                int idcheck = 0;
                for (int i = 0; i < banks.get(bankid).getCustomers().size(); i++) {
                    if (banks.get(bankid).getCustomers().get(i).getCustomerID().equals(custID)) {
                        banks.get(bankid).getCustomers().get(i).printDatabase();
                        idcheck = 1;
                        break;
                    }
                }
                if (idcheck == 0) {
                    System.out.println("Error: Invalid Customer ID");
                }

            }
            System.out.println("Would you like to end your session? Type Yes or No.");
            String option = a.nextLine();
            if (option.equals("Yes")) {
                stopper = 1;
                return;
            }

        }
    }
}
