package Poker;

public class carta {
    private String valor;
    private String palo;

    public carta (String valor, String palo){
        this.valor = valor;
        this.palo = palo;
    }

    public String getPalo() {
        return palo;
    }

    public int getValor() {
        switch (this.valor.toUpperCase()) {
            case "A":
                return 14;
            case "T":
                return 10;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            default:
                return Integer.parseInt(valor);
        }
    }

}
