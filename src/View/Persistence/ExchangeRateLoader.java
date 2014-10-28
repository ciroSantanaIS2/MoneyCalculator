package View.Persistence;

import Model.Currency;
import Model.ExchangeRate;

public class ExchangeRateLoader {
    public ExchangeRate load(Currency from, Currency to) {
        return new ExchangeRate(from, to, (float) 1.34);
    }
}
