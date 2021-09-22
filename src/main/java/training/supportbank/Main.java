package training.supportbank;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;


import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());


    private static HashMap<String, Account> accountHolders = new HashMap<>();




    public static void main(String args[] ) throws IOException{
        String path = "test.csv";
        String line = "";
        System.out.println("What would you like to do today?");
        printActions();

//        logger.setLevel(Level.FINE);
//        logger.setLevel(Level.INFO);
        logger.info("HI");
        logger.warning("Error");

        try {

            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (jsonElement, type, jsonDeserializationContext) ->
                    // Convert jsonElement to a LocalDate here...
            );
            Gson gson = gsonBuilder.create();

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
           logger.info("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Scanner scanner = new Scanner(System.in);
        String accountChoice = scanner.nextLine();
        boolean quit = false;

        Pattern listAll = Pattern.compile("\"(List\\sall)|(list\\stransactions)|(quit)\"img");
        Matcher m = listAll.matcher(accountChoice);

        while (!quit && m.find()) {


            switch (m.group()) {

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
                "2. List Transactions: \n" +
                "3. quit");
    }



}
