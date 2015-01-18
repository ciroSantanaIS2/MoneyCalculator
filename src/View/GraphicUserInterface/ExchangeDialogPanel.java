package View.GraphicUserInterface;

import javax.swing.JFrame;

public class ExchangeDialogPanel extends JFrame{
    
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
        this.getContentPane().add(createMoneyPanel());
        this.getContentPane().add(createCalculateButton());
        this.setVisible(true);
    }
    
}
