package training.supportbank;

import java.util.ArrayList;

public class Account {
    private String name;
    private double money;
    private ArrayList<Transactions> allTransactions;

    public Account(String initialName) {
        this.name = initialName;
        this.money = 0;
        this.allTransactions = new ArrayList<Transactions>();
    }


    public void moneyReceived(Transactions credit) {
        this.allTransactions.add(credit);
        this.money = this.money + credit.getAmount();
    }

    public String getName() {
        return name;
    }

    public void moneyPaid(Transactions deduction){
        this.allTransactions.add(deduction);
        this.money = this.money - deduction.getAmount();
    }

    public String toString(){
        return "Account Holder: "+name+" Amount: "+ money+ " Transactions: " + allTransactions;
    }

    public double getBalance(){
        return money;
    }

    public ArrayList<Transactions> getTransaction(){
        return allTransactions;
    }


}
