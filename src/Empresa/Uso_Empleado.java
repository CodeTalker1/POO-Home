package Empresa;

import java.util.*; //Así puedo exportar todas los metodos de un paquete de Java (java.metodo.*)

/**
 *
 * @author Alejo
 */

/*double num1 = 7,4;
int num2 = (int) num1;
Esto es lo que se conoce como "casting" para una variable de x tipo a otro 
 */
public class Uso_Empleado {

    public static void main(String[] args) {

        /*Empleado empleado1 = new Empleado("Alejandro Manotas", 105000, 2017, 8, 7);
        
        Empleado empleado2 = new Empleado("Analisa Melculo", 95000, 1999, 13, 3);
        
        Empleado empleado3 = new Empleado("Armando Casas", 85000, 1989, 3, 6);
        
        empleado1.subeSueldo(5);
        empleado2.subeSueldo(5);
        empleado3.subeSueldo(5);
        
        System.out.println("Nombre: " + empleado1.dame_nombre() + ". Sueldo:" + empleado1.dame_sueldo() + ". Fecha de alta: " + empleado1.dame_fecha_contrato());
        System.out.println("Nombre: " + empleado2.dame_nombre() + ". Sueldo:" + empleado2.dame_sueldo() + ". Fecha de alta: " + empleado2.dame_fecha_contrato());
        System.out.println("Nombre: " + empleado3.dame_nombre() + ". Sueldo:" + empleado3.dame_sueldo() + ". Fecha de alta: " + empleado3.dame_fecha_contrato());*/
        Jefatura JefeRRHH = new Jefatura("Alejo", 500000, 2015, 8, 9);
        JefeRRHH.establece_incentivo(130000);

        Empleado[] misEmpleados = new Empleado[6]; //Manera de usar un vector o array como objeto

        misEmpleados[0] = new Empleado("Alejandro Manotas", 105000, 2017, 8, 7);
        misEmpleados[1] = new Empleado("Analisa Melculo", 95000, 1999, 13, 3);
        misEmpleados[2] = new Empleado("Armando Casas", 85000, 1989, 3, 6);
        misEmpleados[3] = new Empleado("Pedro Wightman");
        misEmpleados[4] = JefeRRHH; //Polimorfismo en acción. Principio de sustitución. Tiene que ver con que la super clase espere a la sub clase
        misEmpleados[5] = new Jefatura("Maria", 95000, 1999, 26, 8); //En la clase padre se pueden almacenar tanto los objetos de la misma clase como objetos
        //de la clase hijo

        Jefatura Jefa_finanzas = (Jefatura) misEmpleados[5]; //Esto es un casting para convertir un objeto de x tipo a otro
        Jefa_finanzas.establece_incentivo(80000);

        /*for (int i = 0; i < 3; i++) {
            misEmpleados[i].subeSueldo(5);
        }*/
        for (Empleado m : misEmpleados) { //El ciclo para mejorado, simplemente utilizar el tipo de variable, la variable controladora que puede ser cualquiera (Tú la creas) y el array a recorrer
            m.subeSueldo(5);
        }

        /*for (int i = 0; i < misEmpleados.length; i++) {
            System.out.println("Nombre: " + misEmpleados[i].dame_nombre() + ". Sueldo: " + misEmpleados[i].dame_sueldo()
            + ". Fecha de alta: " + misEmpleados[i].dame_fecha_contrato());
        }*/
        for (Empleado m : misEmpleados) {
            System.out.println("Nombre: " + m.dame_nombre() + ". Sueldo: " + m.dame_sueldo()
                    + ". Fecha de alta: " + m.dame_fecha_contrato());
        }  //El enlazado dínamico consiste en que el interprete de Java sabe automaticamente a cual metodo utilizar en x clase, es decir, en ciertos momentos
    }     //llama al dame sueldo de la clase Empleado y en otros momentos llama al metodo dame sueldo de la clase Jefatura    
}

class Empleado {

    public Empleado(String nom, double sue, int año, int mes, int dia) { //Se pueden tener varios constructores con el mismo nombre pero no con la misma cantidad de parametro
        nombre = nom;                                                                            //Ni el mismo tipo    

        sueldo = sue;

        GregorianCalendar Calendario = new GregorianCalendar(año, mes - 1, dia);

        altaContrato = Calendario.getTime();

    }

    public Empleado(String nom) {    //Tener varios constructores en una misma clase se le conoce como "sobrecarga de constructores"
        this(nom, 40000, 2010, 5, 8); //De esta forma el "this" lo que hace es llamar a otro constructor de la clase para no dejar datos vacios y tener datos base, datos por defecto
    }                                          //En caso de haber más constructores en una clase el "this" llama al que coincida con el número de parametros

    public String dame_nombre() {
        return nombre;
    }

    public double dame_sueldo() {  //En un metodo si se coloca como final no es posible que se nombre de igual forma otro metodo en otra clase y ya no estaría sobreescribiendo
        return sueldo;                        //Ni  se vería el polimorfismo en acción ni el enlazado dínamico
    }

    public Date dame_fecha_contrato() {
        return altaContrato;
    }

    public void subeSueldo(double porcentaje) {
        double aumento = sueldo * porcentaje / 100;
        sueldo += aumento;

    }
    private String nombre;
    private double sueldo;
    private Date altaContrato; //Variable de tipo calendario, devuelve una fecha, por ende, podría ser necesario tener variables de año, mes y dia 
    private static int id_siguiente;
    private int id;
}

final class Jefatura extends Empleado { //Un constructor por defecto es aquel que no recibe parametro, es decir, lleva la forma nombre_metodo(){}. Así se entiende cuando se hereda 
    //Y no tiene los corchetes

    public Jefatura(String nom, double sue, int año, int dia, int mes) {
        super(nom, sue, año, dia, mes);  //Así funciona la instrucción SI la clase padre recibe n cantidad de parametros
    }

    public void establece_incentivo(double b) {
        incentivo = b;
    }

    @Override
    public double dame_sueldo() {
        double sueldoJefe = super.dame_sueldo();  //Así se referencia un metodo de otra clase que sea una clase padre con la instrucción super.nombre_metodo();
        return sueldoJefe + incentivo;
    }

    private double incentivo;
}

/*class Director extends Jefatura { El final class nombre de la clase, detiene la herencia, es decir, se detiene la herencia y nadie puede heredar de la clase a la cual se le declaro  
                                                   como final
     public Director(String nom, double sue, int año, int dia, int mes) {
     super(nom, sue, año, dia, mes);
    }
}*/
