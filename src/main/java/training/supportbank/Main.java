package training.supportbank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    private static HashMap<String, Account> accountHolders = new HashMap<>();

    public static void main(String args[]) {
        String path = "Transactions2014 (1).csv";
        String line = "";
        printActions();
        HashMap<String, Integer> allAccounts = new HashMap<>();

        try {

            BufferedReader br = new BufferedReader((new FileReader(path)));
            String [] values = new String[0];
            while ((line = br.readLine()) != null) {
                 values = line.split(",");
            }
                if (!values[0].equals("Date")) {
                    String date = values[0];
                    String fromName = values[1];
                    String toName = values[2];
                    String narrative = values[3];
                    double amount = Double.parseDouble(values[4]);


                    findOrMakeAccount(fromName);
                    findOrMakeAccount(toName);


                    accountHolders.get(fromName).moneyPaid(new Transactions(date,fromName,toName,narrative,amount));


            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        for ( Account i : accountHolders.values()){
//            System.out.println(i);
//            System.out.println(i.getTransaction());
//        }
        accountHolders.forEach((e, k) -> System.out.println(k));



        Scanner scanner = new Scanner(System.in);
        boolean quit = false;


        while (!quit) {

            int accountChoice = scanner.nextInt();

            switch (accountChoice) {
                case 1:
                    System.out.println("list to be displayed");
                    break;
                case 2:
                    System.out.println("What was you name?");
                    break;
                case 3:
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
        System.out.println("What would you like to do today?");
        System.out.println("1. List All \n" +
                "2. List your account: \n" +
                "3. quit");
    }



































}
