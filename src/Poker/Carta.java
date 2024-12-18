package Poker;

import java.util.Arrays;

public class Carta {
    private String valor;
    private String palo;


    public Carta(){
        this.valor = "";
        this.palo = "";
    }

    public Carta(String valor, String palo){
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
    public boolean color(Carta[] mano) {
        String palo = mano[0].getPalo();
        for (Carta carta : mano) {
            if (carta.getPalo() != palo) {
                return false;
            }
        }
        return true;
    }

    public boolean escalera(Carta[] mano) {
        int[] valores = new int[mano.length];
        for (int i = 0; i < mano.length; i++) {
            valores[i] = mano[i].getValor();
        }
        Arrays.sort(valores);

        for (int i = 0; i < valores.length - 1; i++) {
            if (valores[i] + 1 != valores[i + 1]) {
                return valores[0] == 2 && valores[1] == 3 && valores[2] == 4 &&
                        valores[3] == 5 && valores[4] == 14;
            }
        }
        return true;
    }

    public boolean doblePar (Carta[] mano) {
        int pares = 0;
        int [] frecuencias = contarFrecuencias(mano);
        for (int frecuencia: frecuencias ){
            if (frecuencia == 2){
                pares ++;
            }
        }
        return pares==2;
    }

    public boolean par (Carta[] mano) {
        int [] frecuencias = contarFrecuencias(mano);
        for (int frecuencia: frecuencias ){
            if (frecuencia == 2){
                return true;
            }
        }
        return false;
    }

    public boolean trio (Carta[] mano) {
        int [] frecuencias = contarFrecuencias(mano);
        for (int frecuencia: frecuencias ){
            if (frecuencia == 3){
                return true;
            }
        }
        return false;
    }

    public boolean full(Carta[] mano){
        if (trio(mano) && par(mano)){
            return true;
        }
        return false;
    }

    public boolean poker(Carta[] mano) {
        int[] frecuencias = contarFrecuencias(mano);
        for (int frecuencia : frecuencias) {
            if (frecuencia == 4) {
                return true;
            }
        }
        return false;
    }
    //contar la cantidad de veces que aparece el valor
    public int[] contarFrecuencias(Carta[] mano) {
        int[] valores = new int[15];
        for (Carta carta : mano) {
            valores[carta.getValor()]++;
        }
        return valores;
    }

    public void identificarJugadas(Carta[] mano) {
        if (color(mano) && escalera(mano)) {
            System.out.println("Escalera Color");
        } else if (poker(mano)) {
            System.out.println("Poker");
        } else if (full(mano)) {
            System.out.println("Full");
        } else if (color(mano)) {
            System.out.println("Color");
        } else if (escalera(mano)) {
            System.out.println("Escalera");
        } else if (trio(mano)) {
            System.out.println("Trío");
        } else if (doblePar(mano)) {
            System.out.println("Doble Par");
        } else if (par(mano)) {
            System.out.println("Par");
        } else {
            System.out.println("Carta Alta");
        }
    }

}
