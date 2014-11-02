package Model;

public class Money {

    private Currency currency;
    private float amount;

    public float getAmount() {
        return amount;
    }
    
    public Money(Currency currency, float amount) {
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
