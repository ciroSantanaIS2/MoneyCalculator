package Control;

import Model.Currency;
import Model.CurrencySet;
import Model.Exchange;
import Model.ExchangeRate;
import Model.Money;
import View.Persistence.ExchangeRateLoader;
import View.Processes.Exchanger;
import View.UserInterface.ExchangeDialog;
import View.UserInterface.MoneyDisplay;

public class ExchangeCommand {
    CurrencySet set;

    public ExchangeCommand(CurrencySet set) {
        this.set = set;
    }

    public void execute() {
        ExchangeDialog dialog = new ExchangeDialog(set);
        Exchange exchange = dialog.execute();
        ExchangeRate rate = new ExchangeRateLoader().load(exchange.getMoney().getCurrency(), exchange.getCurrency());
        
        float result = Exchanger.convert(exchange.getMoney().getAmount(), rate.getRate());
        
        System.out.println("------------------------------------------------");
        
        MoneyDisplay.display(new Money(exchange.getCurrency(), result), rate);
    }
    
    
}

