package training.supportbank;

import java.util.ArrayList;
import java.util.Arrays;

public class Account {
    private String name;
    private double money;
    private ArrayList<Transactions> transactionCredit;

    public Account(String initialName) {
        this.name = initialName;
        this.money = 0;
        this.transactionCredit = new ArrayList<Transactions>();
    }



    public void moneyReceived(double amount){
        this.money = this.money+amount;
    }



    public void moneyPaid(Transactions credit){
        transactionCredit.add(credit);

        //need a get method
        this.money = this.money - credit.getAmount();
    }

    public String getName(){
        return name;
    }


}
