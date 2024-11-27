package Poker;
import java.util.Random;
public class Poker {
    public static void main(String[] args) {
        Random rnd = new Random();
        String[] valores = new String[5];
        String[] palos = new String[5];
        for (int i = 0; i < valores.length; i++) {
            int valor = rnd.nextInt(14) + 1;
            valores[i] = String.valueOf(valor);
        }

        for (int i = 0; i < palos.length; i++) {
            int palo = rnd.nextInt(4) + 1;
            switch (palo) {
                case 1:
                    palos[i] = "S";
                    break;
                case 2:
                    palos[i] = "C";
                    break;
                case 3:
                    palos[i] = "H";
                    break;
                case 4:
                    palos[i] = "D";
                    break;
                default:
                    System.out.println("No Corresponde");
                    break;
            }
        }

        Carta[] mano = {
                new Carta(valores[0], palos[0]),
                new Carta(valores[1], palos[1]),
                new Carta(valores[2], palos[2]),
                new Carta(valores[3], palos[3]),
                new Carta(valores[4], palos[4]),
        };

        /*//Probar de manera manual
        Carta[] mano = {
                new Carta("4", "S"),
                new Carta("5", "S"),
                new Carta("6", "S"),
                new Carta("7", "S"),
                new Carta("8", "S")
        };*/

        Carta poker = new Carta();
        poker.identificarJugadas(mano);




    }
}
