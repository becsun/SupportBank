package training.supportbank;

public class Transactions {
    private String date;
    private String personGivingMoney;
    private String personGettingMoney;
    private String narrative;
    private double amount;

    public Transactions(String date, String personGivingMoney, String personGettingMoney, String narrative, double amount) {
        this.date = date;
        this.personGivingMoney = personGivingMoney;
        this.personGettingMoney = personGettingMoney;
        this.narrative = narrative;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public String getPersonGivingMoney() {
        return personGivingMoney;
    }

    public String personGettingMoney() {
        return personGettingMoney;
    }

    public String getNarrative() {
        return narrative;
    }

    public double getAmount() {
        return amount;
    }

    public String toString(){
        return "name "+personGivingMoney+" money "+ personGettingMoney+ "transactions " +amount;
    }
}
