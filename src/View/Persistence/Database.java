package View.Persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Currency;
import Model.CurrencySet;
import Model.ExchangeRate;

public class Database implements CurrencySetLoader {

    private final Connection connection;

    private final CurrencySet set = new CurrencySet();

    public Database(Connection connection) {
        this.connection = connection;
    }

    @Override
    public CurrencySet loadCurrencySet() {
        try {
            return processQuery(connection.createStatement().executeQuery("SELECT * FROM currenciess"));
        } catch (SQLException ex) {
            return new CurrencySet();
        }
    }


    private CurrencySet processQuery(ResultSet executeQuery) throws SQLException {
        CurrencySet set = new CurrencySet();
        while (executeQuery.next()) {
            set.add(processCurrency(executeQuery));
        }
        Currency euro = new Currency("Euro", "EUR", "€");
        set.add(euro);
        return set;
    }

    private Currency processCurrency(ResultSet executeQuery) throws SQLException {
        return new Currency(
                executeQuery.getString("name"),
                executeQuery.getString("code"),
                executeQuery.getString("symbol"));
    }

    
    public ExchangeRate loadExchangeRate(Currency currencyFrom, Currency currencyTo) {
        try {
            return processExchangeRate(connection.createStatement().executeQuery(
                    "Select CURRENCYFROM,CURRENCYTO,RATE"
                            + " FROM EXCHANGE_RATE"
                            + " WHERE CURRENCYFROM = '" + currencyFrom.getCode() + "'"
                            + " AND CURRENCYTO = '" + currencyTo.getCode() + "'"), currencyFrom, currencyTo);
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public ExchangeRate processExchangeRate(ResultSet resultSet, Currency currencyFrom, Currency currencyTo) {
        try {
            return new ExchangeRate(currencyFrom, currencyTo, resultSet.getDouble("RATE"));
        } catch (SQLException ex) {
            return null;
        }
    }
}
