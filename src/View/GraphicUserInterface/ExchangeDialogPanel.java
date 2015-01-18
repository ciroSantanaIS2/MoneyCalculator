package View.GraphicUserInterface;

import java.awt.FlowLayout;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Model.Currency;
import Model.Exchange;
import Model.Money;
import View.UserInterface.ExchangeDialog;

public class ExchangeDialogPanel extends JPanel implements ExchangeDialog {
    private final Currency[] currencies;
    private double amount;
    private Currency fromCurrency;
    private Currency toCurrency;

    public ExchangeDialogPanel(Currency currencies[]) {
        this.currencies = currencies;
        this.setLayout(new FlowLayout());
        this.add(createAmountField());
        this.add(createFromCurrencyField());
        this.add(createToCurrencyField());
    }
    
    @Override
    public Exchange getExchange() {
        return new Exchange(new Money(fromCurrency, amount), toCurrency);
    }

    private JTextField createAmountField() {
        final JTextField input = new JTextField();
        input.setColumns(20);
        input.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                amount = Double.parseDouble(input.getText());
            }
        });
        return input;
    }

    private JComboBox<Currency> createFromCurrencyField() {
        final JComboBox<Currency> combo = new JComboBox<>(currencies);
        combo.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() != ItemEvent.SELECTED) return;
                fromCurrency = combo.getItemAt(combo.getSelectedIndex());
            }
            
        });
        return combo;
    }

    private JComboBox<Currency> createToCurrencyField() {
        final JComboBox<Currency> combo = new JComboBox<>(currencies);
        combo.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() != ItemEvent.SELECTED) return;
                toCurrency = combo.getItemAt(combo.getSelectedIndex());
            }
            
        });
        return combo;
    }

}
