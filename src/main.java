
import java.util.Arrays;
import java.util.Random;
public class main {
    public static void main(String[]args){
        Random rnd =new Random();
        int [] dado = new int[5];

        for (int i =0; i<dado.length;i++){
            dado[i]=rnd.nextInt(6)+1;
        }
        Arrays.sort(dado);
        Generala generala = new Generala(dado);
        System.out.println(Arrays.toString(dado));
        System.out.println(generala.jugada());
    }
}
