public class Perro {
    String nombre;
    String raza;
    int edad;
    float gramos;

    float pasarKilogramos(int gramos){
        this.gramos=gramos;
        return (this.gramos/1000);
    }

    void asignarAtributos(String nombre, String raza, int edad){
        this.nombre=nombre;
        this.raza=raza;
        this.edad=edad;
    }

    void ladrar(){
        System.out.println("ladra");
    }
    void comer(){
        System.out.println("comiendo");
    }
    void dormir(){
        System.out.println("durmiendo");
    }
}
