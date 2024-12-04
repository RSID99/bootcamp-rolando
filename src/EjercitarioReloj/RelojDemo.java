package EjercitarioReloj;

import java.util.Scanner;
public class RelojDemo {
    public static void main (String []args) {
        System.out.println("Ingrese los segundos: ");
        Scanner sc = new Scanner(System.in);
        int segundo = sc.nextInt();
        sc.nextLine();
        System.out.println(" *** HOLA MUNDO *** ");
        System.out.println("segundos: " + segundo);

        /*
        Reloj reloj1 = new Reloj(segundo);
        Reloj rejoj2 =new Reloj(10,5,8);
        rejoj2.restaReloj(reloj1);
        for (int i = 0; i<10; i++){
            reloj1.tick();
            System.out.println(reloj1);
        }
        System.out.println("La resta es: "+rejoj2.toString());
         */
    }
}
