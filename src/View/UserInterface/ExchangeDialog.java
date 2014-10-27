package View.UserInterface;

import Model.Currency;
import Model.Money;

public class ExchangeDialog {

    public ExchangeDialog() {
    }
    
    public Money getMoney() {
        return new Money(new Currency("Dólar", "$"), (float) 458.29);
    }
    
    public Currency getCurrency() {
        return new Currency("Euro", "€");
    }
    
    
}
