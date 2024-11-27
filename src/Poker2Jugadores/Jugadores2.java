package Poker2Jugadores;
import java.util.Random;
public class Jugadores2 {
    public static void main(String[] args) {
        Random rnd = new Random();
        String[] valores = new String[10];
        String[] palos = new String[10];
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
        Cartas [] mano1 ={
                new Cartas(valores[0], palos[0]),
                new Cartas(valores[1], palos[1]),
                new Cartas(valores[2], palos[2]),
                new Cartas(valores[3], palos[3]),
                new Cartas(valores[4], palos[4]),
        };
        Cartas [] mano2={
                new Cartas(valores[5], palos[5]),
                new Cartas(valores[6], palos[6]),
                new Cartas(valores[7], palos[7]),
                new Cartas(valores[8], palos[8]),
                new Cartas(valores[9], palos[9]),
        };


        /*//Probar de manera manual
        Cartas[] mano1 = {
                new Cartas("2", "S"),
                new Cartas("3", "S"),
                new Cartas("5", "S"),
                new Cartas("8", "S"),
                new Cartas("A", "C")
        };

        Cartas[] mano2 = {
                new Cartas("2", "S"),
                new Cartas("4", "S"),
                new Cartas("6", "S"),
                new Cartas("8", "S"),
                new Cartas("Q", "C")
        };*/

        Cartas poker = new Cartas();
        System.out.println("Mano 1:");
        for (Cartas carta : mano1) {
            System.out.print(carta+" ");
        }
        System.out.println();
        poker.identificarJugadas(mano1);

        System.out.println("Mano 2:");
        for (Cartas carta : mano2) {
            System.out.print(carta+" ");
        }
        System.out.println();
        poker.identificarJugadas(mano2);

        if (poker.asignarValor(mano1)<poker.asignarValor(mano2)){
            System.out.println("Ganador Jugador 2");
        } else if (poker.asignarValor(mano1)>poker.asignarValor(mano2)){
            System.out.println("Ganador Jugador 1");
        } else {
            if (poker.mayorValor(mano1)<poker.mayorValor(mano2)){
                System.out.println("Ganador Jugador2");
            } else if (poker.mayorValor(mano1)>poker.mayorValor(mano2)){
                System.out.println("Ganador Jugador1");
            } else {
                System.out.println("Empate");
            }
        }

    }
}
