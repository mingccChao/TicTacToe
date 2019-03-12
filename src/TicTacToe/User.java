package TicTacToe;

public class User {
    String name;
    String symbol;

    public User(String name){
        this.name = name;
    }
    public String getName(){return this.name;}

    public void setSymbol(String symbol){this.symbol = symbol;}
    public String getSymbol(){return this.symbol;}
}
