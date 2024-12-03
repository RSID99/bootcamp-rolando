function ecuacionCuadratica(a,b,c){
    if (a===0){
        return "La ecuación no es de segundo grado";
    }

    let discriminante = b*b -4*a*c;

    if (discriminante <0){
       
       return "No hay soluciones reales";
    }

    let raizCuadratrica = (-b-Math.sqrt(discriminante))/(2*a);


    return raizCuadratrica;
}

let resultado = ecuacionCuadratica(8,2,1);
console.log(resultado);
