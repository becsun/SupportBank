package training.supportbank;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String args[]) {
        String path = "Transactions2014 (1).csv";
        String line = "";
        Set<String> accountHolders = new HashSet<String>();
        HashMap<String,Integer> allAccounts = new HashMap<>();

        try {

            BufferedReader br = new BufferedReader((new FileReader(path)));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                String date = values[0];
                String fromName = values[1];
                String toName = values[2];
                String narrative = values[3];
                double amount = Double.parseDouble(values[4]);

//                System.out.println(fromName);

                Account fromAccount = new Account(fromName );
                if(!accountHolders.contains(fromName )){
                    accountHolders.add(fromName);
                    fromAccount.moneyPaid(amount);
                }
                Account toAccount = new Account(toName);
                if(!accountHolders.contains(toName)){
                    accountHolders.add(toName);
                }
                System.out.println(fromAccount.getMoney());

            }

            for(String i: accountHolders){
                allAccounts.put(i,0 );
            }
            System.out.println(allAccounts);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
//        Scanner scanner = new Scanner(System.in);
//        boolean quit = false;
//        printActions();
//
//        while (!quit) {
//
//            int accountChoice = scanner.nextInt();
//
//            switch (accountChoice) {
//                case 1:
//                    System.out.println("list to be displayed");
//                    break;
//                case 2:
//                    System.out.println("What was you name?");
//                    break;
//                case 3:
//                    System.out.println("Bye");
//                    quit = true;
//            }
//        }



//    private static void printActions(){
//        System.out.println("What would you like to do today?");
//        System.out.println("1. List All \n" +
//                "2. List your account: \n" +
//                "3. quit");
//    }



































}
