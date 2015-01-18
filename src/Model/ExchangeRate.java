package Model;

public class ExchangeRate {

    private Currency from, to;
    private double rate;

    public ExchangeRate(Currency currencyFrom, Currency currencyTo, double rate) {
        this.from = currencyFrom;
        this.to = currencyTo;
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public String getCurrencyFrom() {
        return from.toString();
    }

    public String getCurrencyTo() {
        return to.toString();
    }
}
