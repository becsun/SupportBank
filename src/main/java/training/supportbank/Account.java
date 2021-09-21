package training.supportbank;

import java.util.ArrayList;

public class Account {
    private String name;
    private double money;
    private ArrayList<Transactions> transactionCredit;

    public Account(String initialName) {
        this.name = initialName;
        this.money = 0;
        this.transactionCredit = new ArrayList<Transactions>();
    }


    public void moneyReceived(Transactions credit) {
        this.transactionCredit.add(credit);
        this.money = this.money + credit.getAmount();
    }

    public String getName() {
        return name;
    }

    public void moneyPaid(Transactions deduction){
        this.transactionCredit.add(deduction);
        this.money = this.money - deduction.getAmount();
    }

    public String toString(){
        return "name "+name+" money "+ money+ "transactions " +transactionCredit;
    }

    public double getBalance(){
        return money;
    }

    public ArrayList<Transactions> getTransaction(){
        return transactionCredit;
    }


}
