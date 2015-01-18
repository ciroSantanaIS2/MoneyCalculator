package App;

import Control.ExchangeCommand;
import Model.CurrencySet;
import View.GraphicUserInterface.ApplicationFrame;
import View.Persistence.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException {
        final Connection connection = establishConnection("");
        CurrencySet set = new Database(connection).loadCurrencySet();
        final ApplicationFrame frame = new ApplicationFrame(set.getSet());
        frame.register(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new ExchangeCommand(frame.getExchangeDialog(), connection).execute();
            }

            
        });
    }

    private static Connection establishConnection(String path) throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        return DriverManager.getConnection("jdbc:oracle:thin:@" + path, "system", "orcl");
    }
    
}
