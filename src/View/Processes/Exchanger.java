package View.Processes;

import Model.Currency;
import Model.ExchangeRate;
import Model.Money;

public class Exchanger {

    public static Money convert(Currency currency, double amount, double rate) {
        return new Money(currency, amount*rate);
    }
    
}
