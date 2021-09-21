package training.supportbank;

public class Transactions {
    private String date;
    private String transactionIn;
    private String transactionOut;
    private String narrative;

    public Transactions(String initDate, String personGivingMoney, String transactionOut ) {
        this.date = initDate;
        this.transactionIn = personGivingMoney;
        this.transactionOut = personGivingMoney;
    }

    public String getDate() {
        return date;
    }


}
