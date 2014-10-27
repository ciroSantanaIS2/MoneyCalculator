package Control;

import Model.Currency;
import Model.CurrencySet;
import Model.Money;
import View.UserInterface.ExchangeDialog;

public class ExchangeCommand {
    CurrencySet set;

    public ExchangeCommand(CurrencySet set) {
        this.set = set;
    }

    public void execute() {
        ExchangeDialog dialog = new ExchangeDialog();
        Money money = dialog.getMoney();
        Currency currencyTo = dialog.getCurrency();
        
        ExchangeRate rate = new ExchangeRateLoader(Currency to, Currency from).load();
    }
    
    
}
