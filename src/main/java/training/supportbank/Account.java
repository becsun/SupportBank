package training.supportbank;

public class Account {
    private String name;
    private double money;

    public Account(String name) {
        this.name = name;
        this.money = money;
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
