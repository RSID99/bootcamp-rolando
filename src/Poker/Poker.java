package Poker;
import java.util.Arrays;
public class Poker {
    public static void main(String[] args) {
        Poker poker = new Poker();
        carta[] mano = {
                new carta("2", "S"),
                new carta("2", "S"),
                new carta("2", "C"),
                new carta("3", "S"),
                new carta("3", "S")
        };
        poker.identificarJugadas(mano);
    }

    public boolean color(carta[] mano) {
        String palo = mano[0].getPalo();
        for (carta carta : mano) {
            if (carta.getPalo() != palo) {
                return false;
            }
        }
        return true;
    }

    public boolean escalera(carta[] mano) {
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

    public boolean doblePar (carta[] mano) {
        int pares = 0;
        int [] frecuencias = contarFrecuencias(mano);
        for (int frecuencia: frecuencias ){
            if (frecuencia == 2){
                pares ++;
            }
        }
        return pares==2;
    }

    public boolean par (carta[] mano) {
        int [] frecuencias = contarFrecuencias(mano);
        for (int frecuencia: frecuencias ){
            if (frecuencia == 2){
                return true;
            }
        }
        return false;
    }

    public boolean trio (carta[] mano) {
        int [] frecuencias = contarFrecuencias(mano);
        for (int frecuencia: frecuencias ){
            if (frecuencia == 3){
                return true;
            }
        }
        return false;
    }

    public boolean full(carta[] mano){
        if (trio(mano) && par(mano)){
            return true;
        }
        return false;
    }

    public boolean poker(carta[] mano) {
        int[] frecuencias = contarFrecuencias(mano);
        for (int frecuencia : frecuencias) {
            if (frecuencia == 4) {
                return true;
            }
        }
        return false;
    }

    public int[] contarFrecuencias(carta[] mano) {
        int[] valores = new int[15];
        for (carta carta : mano) {
            valores[carta.getValor()]++;
        }
        return valores;
    }

    public void identificarJugadas(carta[] mano) {
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
