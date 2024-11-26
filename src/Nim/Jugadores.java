
public class Jugadores {
    private String nombre;
    private String[] pilas = {"A", "B", "C"};
    private int [] monedas = new int [3];

    public Jugadores (String nombre, int [] monedas){
        this.nombre=nombre;
        this.monedas=monedas;
    }

    public String getNombre() {
        return nombre;
    }

    public int[] getMonedas() {
        return monedas;
    }

    public void setMonedas(int[] monedas) {
        this.monedas = monedas;
    }
    public boolean verificarMayor(String pilas, int cantMonedas){
        if (pilas.toUpperCase().equals(this.pilas[0])){
            if (this.monedas[0]<cantMonedas) {
                return true;
            } else {
                return false;
            }
        } else if (pilas.toUpperCase().equals(this.pilas[1])){
            if (this.monedas[1]<cantMonedas) {
                return true;
            } else {
                return false;
            }
        } else {
            if (this.monedas[2]<cantMonedas) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void restamonedas(String pilas, int cantMonedas){
        if (pilas.toUpperCase().equals(this.pilas[0])){
            if (this.monedas[0]>=cantMonedas) {
                this.monedas[0] -= cantMonedas;
            }
        } else if (pilas.toUpperCase().equals(this.pilas[1])){
            if (this.monedas[1]>=cantMonedas) {
                this.monedas[1] -= cantMonedas;
            }
        } else {
            if (this.monedas[2]>=cantMonedas) {
                this.monedas[2] -= cantMonedas;
            }
        }
    }



    public boolean verificarGanador(){
        if (this.monedas[0]==0 && this.monedas[1]==0 && this.monedas[2]==0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString(){
        String resultado = "";
        for (int i = 0; i < this.pilas.length; i++) {
            resultado += this.pilas[i] + ":" + this.monedas[i];
            if (i < this.pilas.length - 1) {
                resultado += " ";
            }
        }
        return resultado;
    }
}
