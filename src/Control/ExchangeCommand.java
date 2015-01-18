package Control;

import Model.Exchange;
import Model.ExchangeRate;
import Model.Money;
import View.Persistence.Database;
import View.Processes.Exchanger;
import View.UserInterface.ExchangeDialog;
import java.sql.Connection;

public class ExchangeCommand {
    private final ExchangeDialog exchangeDialog;
    
    private final Connection connection;

    public ExchangeCommand(ExchangeDialog exchangeDialog, Connection connection) {
        this.exchangeDialog = exchangeDialog;
        this.connection = connection;
    }

    public void execute() {
               
        Exchange exchange = obtainExchange();
        ExchangeRate rate = obtainRate(exchange);
        Money result = convert(exchange,rate);
        displayResult(result);
        
    }

    private Exchange obtainExchange() {
        return exchangeDialog.getExchange();
    }

    private ExchangeRate obtainRate(Exchange exchange) {
        return new Database(connection).loadExchangeRate(exchange.getMoney().getCurrency(), exchange.getCurrency());
    }
    
    private Money convert(Exchange exchange, ExchangeRate rate) {
        return Exchanger.convert(exchange.getCurrency(), exchange.getMoney().getAmount(), rate.getRate());
    }

    private void displayResult(Money result) {
        System.out.println(result);
    }
}

