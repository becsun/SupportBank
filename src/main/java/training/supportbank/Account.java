package training.supportbank;

import java.util.ArrayList;
import java.util.Arrays;

public class Account {
    private String name;
    private double money;
    private ArrayList<Transactions> transactions;

    public Account(String initialName) {
        this.name = initialName;
        this.money = 0;
    }


    public double getMoney() {
        return money;
    }

    public void moneyRecieved(double amount){
        this.money = this.money+amount;
    }

    public void moneyPaid(double amount){
        this.money = this.money - amount;
    }




}
