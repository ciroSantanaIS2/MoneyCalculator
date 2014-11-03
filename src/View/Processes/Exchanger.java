package View.Processes;

import Model.Currency;
import Model.ExchangeRate;
import Model.Money;

public class Exchanger {

    public static Money convert(Currency currency, float amount, float rate) {
        return new Money(currency, amount*rate);
    }
    
}
