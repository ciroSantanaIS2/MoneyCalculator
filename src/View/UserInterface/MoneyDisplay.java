package View.UserInterface;

import Model.ExchangeRate;
import Model.Money;

/**
 *
 * @author Ciro
 */
public class MoneyDisplay {

    private static Money money;
    private static ExchangeRate rate;

    public MoneyDisplay(Money money, ExchangeRate rate) {
        this.money = money;
        this.rate = rate;
    }
    
    public static void display() {
        System.out.println("El tipo de cambio de " + rate.getCurrencyFrom() + " a " + 
                rate.getCurrencyTo() + " es: " + rate.getRate());
        System.out.println("Su cambio es: " + money.toString());
    }
    
}
