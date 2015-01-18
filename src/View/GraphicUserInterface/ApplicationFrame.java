package View.GraphicUserInterface; 

import static java.awt.BorderLayout.SOUTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Model.Currency;
import View.UserInterface.ExchangeDialog;

public class ApplicationFrame extends JFrame {
    
    private final Currency[] currencies;
    private ExchangeDialog exchangeDialog;
    private ActionListener actionListener;

    public ApplicationFrame(Currency[] currencies) {
        this.currencies = currencies;
        this.setTitle("Money calculator");
        this.setSize(500,500);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(createExchangeDialogPanel(currencies));
        this.getContentPane().add(createMoneyPanel(), SOUTH);
        this.getContentPane().add(createCalculateButton(), SOUTH);
        this.setVisible(true);
    }

    private JPanel createExchangeDialogPanel(Currency[] currencies) {
        ExchangeDialogPanel dialogPanel = new ExchangeDialogPanel(currencies);
        exchangeDialog = dialogPanel;
        return dialogPanel;
    }

    private JPanel createMoneyPanel() {
        return new JPanel();
    }

    private JButton createCalculateButton() {
        JButton button = new JButton("Calcular");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                actionListener.actionPerformed(e);
            }
        });
        return button;
    }

    public void register(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public ExchangeDialog getExchangeDialog() {
        return exchangeDialog;
    }
    
    
    public class MoneyPanel extends JPanel {
        
    }
}