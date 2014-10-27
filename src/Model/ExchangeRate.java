package Model;

public class ExchangeRate {

    private Currency from, to;
    private float rate;

    public ExchangeRate(Currency currency1, Currency currency2, float rate) {
        this.from = currency1;
        this.to = currency2;
        this.rate = rate;
    }
}
