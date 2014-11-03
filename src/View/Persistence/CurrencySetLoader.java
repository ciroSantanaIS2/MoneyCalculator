package View.Persistence;

import Model.Currency;
import Model.CurrencySet;

public class CurrencySetLoader {
    
    public CurrencySet load(){
        CurrencySet set = new CurrencySet();
        set.add(new Currency("Dolar","USD", "$"));
        set.add(new Currency("Euro","EUR", "€"));
        set.add(new Currency("Libra", "GBP", "L"));
        set.add(new Currency("Yen", "JPY", "Y"));
        
        return set;
    }
    
}
