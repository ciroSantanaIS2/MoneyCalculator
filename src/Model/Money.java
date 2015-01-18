package Model;

public class Money {

    private Currency currency;
    private double amount;

    public double getAmount() {
        return amount;
    }
    
    public Money(Currency currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Currency getCurrency() {
        return this.currency;
    }
    
    @Override
    public String toString() {
        return amount + " " + currency.getSymbol();
    }
}
