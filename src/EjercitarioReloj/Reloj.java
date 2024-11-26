public class Reloj {
    private int horas;
    private int minutos;
    private int segundos;
    public Reloj(){
        this.horas=12;
        this.minutos=00;
        this.segundos=00;
    }
    public Reloj(int horas, int minutos, int segundos){
        this.horas=horas;
        this.minutos=minutos;
        this.segundos=segundos;
    }
    public Reloj(int segundo){
        this(segundo/3600,segundo%3600/60,segundo%3600%60);
    }
    public void setReloj(int segundo){
        this.horas=(segundo/3600)%24;
        this.minutos=(segundo/60)%60;
        this.segundos=(segundo%60);
    }

    public void setHoras(int horas) {
        if (horas>=0 && horas<24) {
            this.horas = horas;
        }
    }

    public void setMinutos(int minutos) {
        if (minutos>=0 && minutos<60) {
            this.minutos = minutos;
        }
    }

    public void setSegundos(int segundos) {
        if (segundos>=0 && segundos<60) {
            this.segundos = segundos;
        }
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void tick(){
        this.segundos ++;
        if (this.segundos==59){
            this.segundos=0;
        }
    }
    public void tickDecrement(){
        this.segundos--;
    }

    public void addReloj(Reloj reloj){
        int totalSegundos = reloj.getHoras() * 3600 + reloj.getMinutos() * 60 + reloj.getSegundos();
        setReloj(totalSegundos);
    }

    public Reloj restaReloj(Reloj reloj){
        int pasarSegundos1 = this.horas*3600+this.minutos*60+this.segundos;
        int pasarSegundos2= reloj.getHoras()*3600+reloj.getMinutos()*60+ reloj.getSegundos();

        int resultadoResta=pasarSegundos1-pasarSegundos2;

        if (resultadoResta<0){
            resultadoResta=resultadoResta*(-1);
        }


        this.horas=(resultadoResta/3600)%24;
        this.minutos=(resultadoResta/60)%60;
        this.segundos=(resultadoResta%60);
        return new Reloj(horas,minutos,segundos);
    }
    @Override
    public String toString() {
        return String.format("[%02d:%02d:%02d]", horas, minutos, segundos);
    }
}
