package App;

import Control.ExchangeCommand;
import Model.CurrencySet;
import View.Persistence.CurrencySetLoader;

public class Application {

    public static void main(String[] args) {
        CurrencySet set = new CurrencySetLoader().load();
        new ExchangeCommand(set).execute();
        
    }
    
}
