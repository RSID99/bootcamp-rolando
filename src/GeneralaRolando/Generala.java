public class Generala {
    private int[] dados;

    public Generala(int []dados) {
        this.dados = dados;
    }

    String jugada() {
        if (maxRepetidas()==5){
            return"GENERALA";
        }
        if (maxRepetidas()==4){
            return "POKER";
        }
        if (maxRepetidas()==3 && duoRepetidas()==2){
            return "FULL";
        }
        if (escalera()){
            return "ESCALERA";
        }
        if (invalido()){
            return "INVALIDO";
        }
        return "NADA";
    }

    public int maxRepetidas(){
        int[] repetidas = cantRepetidas();
        int max = 0;
        for (int r : repetidas) {
            if (r > max) {
                max = r;
            }
        }
        return max;
    }

    public int duoRepetidas(){
        int[] repetidas = cantRepetidas();
        int max = maxRepetidas();
        int duo = 0;
        for (int r : repetidas) {
            if (r > duo && r < max) {
                duo = r;
            }
        }
        return duo;
    }
    public int []cantRepetidas(){
        int[] repetidas = new int[7];
        for (int dado : dados) {
            repetidas[dado]++;
        }
        return repetidas;
    }

    public boolean escalera() {
        for (int i = 0; i < this.dados.length - 1; i++) {
            if (this.dados[i] + 1 != this.dados[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean invalido() {
        for (int dado : this.dados) {
            if (dado < 1 || dado > 6) {
                return true;
            }
        }
        return false;
    }
}