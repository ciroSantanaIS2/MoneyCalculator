package View.UserInterface;

import Model.Currency;
import Model.CurrencySet;
import Model.Exchange;
import Model.Money;
import java.util.Scanner;

public class ExchangeDialog {
    
    private CurrencySet set;
    Exchange exchange;
    
    public ExchangeDialog(CurrencySet set) {
        this.set = set;
        exchange = new Exchange(new Money(readCurrency("origen"), readAmount()), readCurrency("destino"));
    }

    private void showAvailableCurrencies(CurrencySet set) {
        int i = 0;
        for (Currency currency : set.getSet()) {
            System.out.print(currency.toString() + " (" + i++ + ") ");
        }
        System.out.println("");
    }

    private Currency readCurrency(String variable) {
        System.out.print("Elegir divisa de " + variable + ": ");
        showAvailableCurrencies(set);
        
        Scanner string = new Scanner(System.in);
        
        
        while (true) {
            String entry = string.nextLine();
            Currency available = set.getCurrency(entry);
            if (available != null) return available;
            System.out.println("Divisa no soportada. Por favor, introduzca una divisa válida.");
        }
    }
    
    private float readAmount() {
        System.out.println("Ingrese la cantidad que desea cambiar: ");
        Scanner number = new Scanner(System.in);
        return number.nextFloat();
    }

    public Exchange getExchange() {
        return exchange;
    }

}
