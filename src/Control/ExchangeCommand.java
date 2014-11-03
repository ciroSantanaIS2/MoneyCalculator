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
        
        Exchange exchange = readExchange();
        ExchangeRate rate = readExchangeRate(exchange);
        Money result = convert(exchange, rate);
        displayResult(result, rate);
        
    }

    private Exchange readExchange() {
        return new ExchangeDialog(set).getExchange();
    }

    private ExchangeRate readExchangeRate(Exchange exchange) {
        return new ExchangeRateLoader().load(exchange.getMoney().getCurrency(), exchange.getCurrency());
    }

    private Money convert(Exchange exchange, ExchangeRate rate) {
        return Exchanger.convert(exchange.getCurrency(), exchange.getMoney().getAmount(), rate.getRate());
    }

    private void displayResult(Money result, ExchangeRate rate) {
        System.out.println("------------------------------------------------");
        new MoneyDisplay(result, rate).display();
    }
    
    
}

