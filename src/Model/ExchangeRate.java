package Model;

public class ExchangeRate {

    private Currency from, to;
    private float rate;

    public ExchangeRate(Currency currencyFrom, Currency currencyTo, float rate) {
        this.from = currencyFrom;
        this.to = currencyTo;
        this.rate = rate;
    }

    public float getRate() {
        return rate;
    }

    public String getCurrencyFrom() {
        return from.toString();
    }

    public String getCurrencyTo() {
        return to.toString();
    }
}
