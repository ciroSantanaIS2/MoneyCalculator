package Model;

import java.util.ArrayList;
import java.util.Iterator;

public class CurrencySet {
    private final ArrayList<Currency> set;

    public CurrencySet() {
        set =  new ArrayList<Currency>();
    }

    @Override
    public String toString() {
        return "CurrencySet{" + "set=" + set + '}';
    }

    public ArrayList<Currency> getSet() {
        return set;
    }

    public void add(Currency currency) {
        set.add(currency);
    }

    public Currency getCurrency(String entry) {
        for (Currency currency : set) {
            if (currency.getName().equals(entry)) {
                return currency;
            }
        }
        return null;
    }
    
}
