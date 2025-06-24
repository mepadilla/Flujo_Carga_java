/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tools;

/**
 *
 * @author melvin
 */
public class ComplejoApp {
    public static void main(String[] args) {
//suma
        Complejo c1=new Complejo(1.0, 2.0);
        Complejo c2=new Complejo(-1.0, 3.0);
        Complejo resultado=Complejo.suma(c1, c2);
        System.out.println("Suma "+resultado);
//producto
        resultado=Complejo.producto(c1, c2);
        System.out.println("Producto "+resultado);
        resultado=Complejo.producto(3.2, c2);
        System.out.println("Producto "+resultado);
        resultado=Complejo.producto(c1, 2.7);
        System.out.println("Producto "+resultado);
 //cociente
        try{
            resultado=Complejo.cociente(c1, c2);
        }catch(ExcepcionDivideCero ex){
            System.out.println("Al calcular el cociente se ha producido una excepción\n "
                +ex.getClass()+ " con el mensaje "+ ex.getMessage());
        }
        System.out.println("Cociente "+resultado);
 //potencia
        resultado=Complejo.potencia(c1, 3);
        System.out.println("Potencia "+resultado);
//argumento
        Complejo c3=new Complejo(3.0, -5.0);
        System.out.println("argumento "+c3.argumento());
//operaciones combinadas
        resultado=Complejo.suma(Complejo.opuesto(c1), Complejo.suma(c2, c3));
        System.out.println("op. combinadas "+resultado);
        resultado=Complejo.producto(Complejo.suma(c1, c2), c3);
        System.out.println("op. combinadas "+resultado);
        try{
            resultado=Complejo.producto(Complejo.cociente(c1, c2),Complejo.exponencial(c3));
            System.out.println("op. combinadas "+resultado);
        }catch(ExcepcionDivideCero ex){
            System.out.println("Al calcular el cociente se ha producido una excepción\n "
                +ex.getClass()+ " con el mensaje "+ ex.getMessage());
        }

        try{
//espera la pulsación de una tecla y luego RETORNO
            System.in.read();
        }catch (Exception ex) {  }
    }
}
