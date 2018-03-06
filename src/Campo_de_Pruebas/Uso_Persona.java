package Campo_de_Pruebas;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Alejo
 */
public class Uso_Persona {

    public static void main(String[] args) {
        Persona[] lasPersonas = new Persona[2];
        lasPersonas[0] = new Empleado2("Mario Conde", 90000, 1999, 8, 6);
        lasPersonas[1] = new Alumno("Ingenieria de sistemas", "Alejandro Manotas");

        for (Persona e : lasPersonas) {
            System.out.println(e.dameNombre() + " " + e.dameDescripcion());
        }
    }

}

abstract class Persona {

    String nombre;

    public Persona(String nom) {
        nombre = nom;
    }

    public String dameNombre() {
        return nombre;
    }

    public abstract String dameDescripcion();
}

class Empleado2 extends Persona {

    public Empleado2(String nom, double sue, int año, int mes, int dia) {

        super(nom);

        sueldo = sue;

        GregorianCalendar Calendario = new GregorianCalendar(año, mes - 1, dia);

        altaContrato = Calendario.getTime();

    }

    @Override
    public String dameDescripcion() {
        return "Este empleado tiene un Id: " + id + " con un sueldo igual a " + sueldo;
    }

    public double dame_sueldo() {
        return sueldo;
    }

    public Date dame_fecha_contrato() {
        return altaContrato;
    }

    public void subeSueldo(double porcentaje) {
        double aumento = sueldo * porcentaje / 100;
        sueldo += aumento;

    }
    private double sueldo;
    private Date altaContrato;
    private static int id_siguiente;
    private int id;
}

class Alumno extends Persona {

    public Alumno(String carr, String nom) {
        super(nom);
        carrera = carr;
    }

    @Override
    public String dameDescripcion() {
        return "Este alumno esta estudiando la carrera de: " + carrera;
    }
    private String carrera;
}
