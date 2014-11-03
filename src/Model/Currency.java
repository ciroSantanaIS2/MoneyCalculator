package Model;

public class Currency {

    private String name;
    private String code;
    private String symbol;

    public Currency(String name, String code,String symbol) {
        this.name = name;
        this.code = code;
        this.symbol = symbol;
    }
    
    @Override
    public String toString() {
        return name + " (" + symbol + ")";
    }

    String getName() {
        return name;
    }

    String getSymbol() {
        return symbol;
    }
}
