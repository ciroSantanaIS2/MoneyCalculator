package Model;

import java.util.ArrayList;

public class CurrencySet {
    private final ArrayList<Currency> set;

    public CurrencySet() {
        set =  new ArrayList<Currency>();
    }

    public ArrayList<Currency> getSet() {
        return set;
    }

    @Override
    public String toString() {
        return "CurrencySet{" + "set=" + set + '}';
    }
    
    
}
