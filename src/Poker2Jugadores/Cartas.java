package Poker2Jugadores;

import java.util.Arrays;

public class Cartas {
    private String valor;
    private String palo;


    public Cartas(){
        this.valor = "";
        this.palo = "";
    }

    public Cartas(String valor, String palo){
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
    public boolean color(Cartas[] mano) {
        String palo = mano[0].getPalo();
        for (Cartas carta : mano) {
            if (carta.getPalo() != palo) {
                return false;
            }
        }
        return true;
    }

    public boolean escalera(Cartas[] mano) {
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

    public boolean doblePar (Cartas[] mano) {
        int pares = 0;
        int [] frecuencias = contarFrecuencias(mano);
        for (int frecuencia: frecuencias ){
            if (frecuencia == 2){
                pares ++;
            }
        }
        return pares==2;
    }

    public boolean par (Cartas[] mano) {
        int [] frecuencias = contarFrecuencias(mano);
        for (int frecuencia: frecuencias ){
            if (frecuencia == 2){
                return true;
            }
        }
        return false;
    }

    public boolean trio (Cartas[] mano) {
        int [] frecuencias = contarFrecuencias(mano);
        for (int frecuencia: frecuencias ){
            if (frecuencia == 3){
                return true;
            }
        }
        return false;
    }

    public boolean full(Cartas[] mano){
        if (trio(mano) && par(mano)){
            return true;
        }
        return false;
    }

    public boolean poker(Cartas[] mano) {
        int[] frecuencias = contarFrecuencias(mano);
        for (int frecuencia : frecuencias) {
            if (frecuencia == 4) {
                return true;
            }
        }
        return false;
    }
    //contar la cantidad de veces que aparece el valor
    public int[] contarFrecuencias(Cartas[] mano) {
        int[] valores = new int[15];
        for (Cartas carta : mano) {
            valores[carta.getValor()]++;
        }
        return valores;
    }

    public void identificarJugadas(Cartas[] mano) {
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

    public int asignarValor(Cartas[] mano ){
        int valor=0;
        if (color(mano) && escalera(mano)) {
            valor=9;
        } else if (poker(mano)) {
            valor=8;
        } else if (full(mano)) {
            valor=7;
        } else if (color(mano)) {
            valor=6;
        } else if (escalera(mano)) {
            valor=5;
        } else if (trio(mano)) {
            valor=4;
        } else if (doblePar(mano)) {
            valor=3;
        } else if (par(mano)) {
            valor=2;
        } else {
            valor=1;
        }
        return valor;
    }

    public int mayorValor(Cartas []mano){
        int mayor = 0;
        for (int i = 0; i<mano.length;i++){
            if (mayor<mano[i].getValor()){
                mayor=mano[i].getValor();
            }
        }
        return mayor;
    }

    public String obtenerValor (){
        String valores="";
        switch (this.valor){

            case "1":
                valores="A";
                break;
            case "10":
                valores="T";
                break;
            case "11":
                valores="J";
                break;
            case "12":
                valores="Q";
                break;
            case "13":
                valores="K";
                break;
            case "14":
                valores="A";
                break;
            default:
                valores=this.valor;
        }
        return valores;
    }

    public String toString() {
        return obtenerValor()+ palo+" ";
    }
}
