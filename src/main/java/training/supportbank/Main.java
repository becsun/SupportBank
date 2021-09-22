package training.supportbank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    private static HashMap<String, Account> accountHolders = new HashMap<>();


    public static void main(String args[]) {
        String path = "test.csv";
        String line = "";
        System.out.println("What would you like to do today?");
        printActions();


        try {

            BufferedReader br = new BufferedReader((new FileReader(path)));

            while ((line = br.readLine()) != null) {
                String [] values = new String[0];
                 values = line.split(",");

                if (!values[0].equals("Date")) {
                    String date = values[0];
                    String fromName = values[1];
                    String toName = values[2];
                    String narrative = values[3];
                    double amount = Double.parseDouble(values[4]);


                    findOrMakeAccount(fromName);
                    findOrMakeAccount(toName);

                    accountHolders.get(fromName).moneyPaid(new Transactions(date, fromName, toName, narrative, amount));
                    accountHolders.get(toName).moneyReceived(new Transactions(date, fromName, toName, narrative, amount));

                }
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Scanner scanner = new Scanner(System.in);
        boolean quit = false;


        while (!quit) {

            String accountChoice = scanner.nextLine();

            switch (accountChoice) {
                case "List All":
                    for ( Account i : accountHolders.values()){
                        System.out.println("Account Holder: "+i.getName()+" ****** Total Balance: "+i.getBalance());
                    }
                    printActions();
                    break;
                case "List your account":
                    System.out.println("Print your name?");
                    String nameInput = scanner.nextLine();
                    System.out.println(accountHolders.get(nameInput).getTransaction());
                    break;
                case "quit":
                    System.out.println("Bye");
                    quit = true;

            }
        }
    }

    private static Account findOrMakeAccount(String fromName) {
        Account account = accountHolders.get(fromName);
        if (account == null) {
            account = new Account(fromName);
            accountHolders.put(fromName, account);
        }

        return account;
    }


    private static void printActions(){
        System.out.println("Choose from the following: \n" +
                "1. List All \n" +
                "2. List your account: \n" +
                "3. quit");
    }



































}
