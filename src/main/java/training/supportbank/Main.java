package training.supportbank;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String args[]) {
        String path = "/Users/rsun5/Transactions2014 (1).csv";
        String line ="";



        try{

            BufferedReader br = new BufferedReader((new FileReader(path)));

            while((line = br.readLine()) != null){
//                System.out.println(line);
//                while((line = br.readLine()) != null){
                    String [] values = line.split(",");
                    System.out.println(values[1] + values[2]+values[4]);
                Set<String> accountHolders = new HashSet<String>();
                accountHolders.add(values[1]);
                System.out.print(accountHolders);

            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }


        System.out.println("What would you like to do today?");
        System.out.println("1. List All \n" +
                            "2. List your account:");
        Scanner scanner = new Scanner(System.in);
        int accountChoice = scanner.nextInt();
        if(accountChoice == 1){
            System.out.println("list to be displayed");
        }else if (accountChoice == 2){
            System.out.println("What was you name?");
        }else{
            System.out.println("please pick from the 2 choices");
        }

    }

































}
