import java.util.Random;
import java.util.Scanner;
public class nim {
    public static void main(String[]args) {
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        int []monedas = new int[3];

        for (int i=0;i<3;i++){ //se ingresa de manera aleatoria los valores
            monedas[i]=rnd.nextInt(20)+1;
        }

        System.out.print("Jugador 1, Ingrese su nombre: ");
        String nombrej1 = sc.nextLine(); //ingresa nombre del jugador1
        Jugadores jugador1 = new Jugadores(nombrej1,monedas);
        System.out.print("Jugador 2, Ingrese su nombre: ");
        String nombrej2 = sc.nextLine(); //ingresa nombre del jugador1
        Jugadores jugador2 = new Jugadores(nombrej2,monedas);
        System.out.println("A:"+monedas[0]+" B:"+monedas[1]+" C:"+monedas[2]);
        int cJugador1=1; //bandera para dar lugar al jugador

        do {
            if (cJugador1==1){
                 System.out.print(jugador1.getNombre()+", elija una pila: ");
                 String pila=sc.nextLine();

                 if (pila.toUpperCase().equals("A") || pila.toUpperCase().equals("B") || pila.toUpperCase().equals("C")){
                     System.out.print("Cuantos quitara de la pila "+pila.toUpperCase()+": ");
                     int quitar1 = sc.nextInt();
                     sc.nextLine();
                     if (jugador2.verificarMayor(pila,quitar1)){ //verifica si la cantidad de monedas que quitara no supere a los que tiene
                         System.out.println("El numero es mayor a la cantidad de monedas restante");
                         System.out.println("Vuelva a intentarlo");
                         cJugador1=1;
                     }else {
                         jugador1.restamonedas(pila, quitar1);// resta las monedas
                         jugador1.getMonedas();
                         System.out.println(jugador1); //imprime el estado de las monedas aun pendientes

                         if (jugador1.verificarGanador()) { // verifica si ya no hay ninguna moneda en las pilas
                             System.out.println(jugador1.getNombre() + ", ya no quedan contadores, asi que... Ganaste! ");
                         }
                         cJugador1 = 0;
                     }
                 }
                    // se repite el procedimiento para el jugador 2
            } else {
                System.out.print(jugador2.getNombre()+", elija una pila: ");
                String pila=sc.nextLine();

                if (pila.toUpperCase().equals("A") || pila.toUpperCase().equals("B") || pila.toUpperCase().equals("C")){
                    System.out.print("Cuantos quitara de la pila "+pila.toUpperCase()+": ");
                    int quitar2 = sc.nextInt();
                    sc.nextLine();
                    if (jugador2.verificarMayor(pila,quitar2)){
                        System.out.println("El numero es mayor a la cantidad de monedas restante");
                        System.out.println("Vuelva a intentarlo ");
                        cJugador1=0;
                    }else{
                        jugador2.restamonedas(pila, quitar2);
                        jugador2.getMonedas();
                        System.out.println(jugador2);
                        if (jugador2.verificarGanador()){
                        System.out.println(jugador2.getNombre()+", ya no quedan contadores, asi que... Ganaste! ");
                        }
                        cJugador1=1;
                    }
                }
            }
        } while(!jugador1.verificarGanador());
    }
}