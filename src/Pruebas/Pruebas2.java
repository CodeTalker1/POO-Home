package Pruebas;

import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejo
 */

public class Pruebas2 {

    public static void main(String[] args) {
        Persona[] personitas = new Persona[4];
        personitas[0] = new Empleado(JOptionPane.showInputDialog("Nombre del empleado"),
                Integer.parseInt(JOptionPane.showInputDialog("Sueldo del empleado")),
                Integer.parseInt(JOptionPane.showInputDialog("Mes de alta")),
                Integer.parseInt(JOptionPane.showInputDialog("Día de alta")),
                Integer.parseInt(JOptionPane.showInputDialog("Año de alta")),
                JOptionPane.showInputDialog("Empresa"));

        personitas[1] = new Alumno(JOptionPane.showInputDialog("Nombre del alumno"),
                JOptionPane.showInputDialog("Carrera que estudia"),
                Integer.parseInt(JOptionPane.showInputDialog("Día del grado")),
                Integer.parseInt(JOptionPane.showInputDialog("Mes del grado")),
                Integer.parseInt(JOptionPane.showInputDialog("Año del grado")));
        
        personitas[2] = new Empleado(JOptionPane.showInputDialog("Nombre del empleado"),
                Integer.parseInt(JOptionPane.showInputDialog("Sueldo del empleado")),
                Integer.parseInt(JOptionPane.showInputDialog("Mes de alta")),
                Integer.parseInt(JOptionPane.showInputDialog("Día de alta")),
                Integer.parseInt(JOptionPane.showInputDialog("Año de alta")),
                JOptionPane.showInputDialog("Empresa"));
        
        personitas[3] = new Alumno(JOptionPane.showInputDialog("Nombre del alumno"),
                JOptionPane.showInputDialog("Carrera que estudia"),
                Integer.parseInt(JOptionPane.showInputDialog("Día del grado")),
                Integer.parseInt(JOptionPane.showInputDialog("Mes del grado")),
                Integer.parseInt(JOptionPane.showInputDialog("Año del grado")));
        
        for(Persona z: personitas){
            System.out.println(z.DameNombre() + z.DameDescripcion());
        }
    }
}

abstract class Persona {

    private String nombre;

    public Persona(String nom) {
        nombre = nom;
    }

    public String DameNombre() {
        return nombre;
    }

    public abstract String DameDescripcion();

}

class Empleado extends Persona {

    private int Id = 1, mes, dia, año;
    private double sueldo;
    private Date fecha_alta;
    private String empresa;

    public Empleado(String nom, double sue, int mes, int dia, int año, String emp) {
        super(nom);

        GregorianCalendar fecha = new GregorianCalendar(año, mes - 1, dia);

        fecha_alta = fecha.getTime();

        empresa = emp;
        
        sueldo = sue;
    }

    @Override
    public String DameDescripcion() {
        return " Su Id es: " + Id + "\n" + " Y su fecha de alta es: " + fecha_alta + "\nY trabaja en la empresa: " + empresa + " con un sueldo de "+ sueldo;
    }
}

class Alumno extends Persona {

    private String carrera;
    private Date grado;

    public Alumno(String nom, String carr, int dia, int mes, int año) {
        super(nom);
        carrera = carr;

        GregorianCalendar fecha = new GregorianCalendar(año, mes - 1, dia);
        grado = fecha.getTime();
    }

    @Override
    public String DameDescripcion() {
        return " El estudiante esta estudiando la carrera de " + carrera + "\n" + "Se gradua un: " + grado;
    }
}
