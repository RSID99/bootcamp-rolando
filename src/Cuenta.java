public class Cuenta {
    protected float saldo;
    protected int nroConsignacion =0;
    protected  int nroretiros = 0;
    protected float tasaAnual;
    protected float comisionMensual=0;
    public Cuenta(float saldo,int nroConsignacion, int nroretiros, float tasaAnual, float comisionMensual){
        this.saldo=saldo;
        this.tasaAnual=tasaAnual;
    }

    public void consignarDinero(float agregarSaldo){
        this.saldo+=agregarSaldo;
    }



}
