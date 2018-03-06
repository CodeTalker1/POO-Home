package Pruebas;

import javax.swing.JOptionPane;
import java.util.*;

/**
 *
 * @author Alejo
 */
public class Prueba {

    public static void main(String[] args) {
        boolean continuar = true; String op;
        while (continuar) {
            Industria BMW = new Industria(Integer.parseInt(JOptionPane.showInputDialog("El día de fabricación")), 
                    Integer.parseInt(JOptionPane.showInputDialog("Mes de fabricación")),
                    Integer.parseInt(JOptionPane.showInputDialog("Año de fabricación"))) ;
            
            BMW.Todoterreno(JOptionPane.showInputDialog("¿Quiere que el auto sea todo terreno?"));
            
            BMW.Aire_acondicionado(JOptionPane.showInputDialog("¿Quiere que el auto tenga aire acondicionado?"));
            
            BMW.Nitrogeno(JOptionPane.showInputDialog("¿Quiere nitrogeno en su auto?"));
            
            BMW.Color(JOptionPane.showInputDialog("¿De que color quiere el auto?"));
            
            BMW.PrecioFinal();
            
            op = JOptionPane.showInputDialog("¿Desea continuar fabricando coches?");
            if(op.equalsIgnoreCase("no"))
                continuar = false;
        }
        System.out.println("Gracias por usar nuestra aplicación. \nSigue en version Beta :)" );
    }
}

class Industria {

    private int costoBase, largo, ancho, alto;
    private boolean todoTerreno, aire_acondicionado, nitrogeno;
    private double peso_total;
    private String Color;
    private Date Fecha_fabricacion;

    public Industria(int dia, int mes, int año) {
        costoBase = 100000; peso_total = 7000; largo = 2000; ancho = 1600; alto = 1300;
        GregorianCalendar Fecha = new GregorianCalendar(año, mes - 1, dia);
        Fecha_fabricacion = Fecha.getTime();
    }

    public void Todoterreno(String todoTerreno) {
        if (todoTerreno.equalsIgnoreCase("si")) {
            this.todoTerreno = true;
        }
    }

    public void Color(String Color) {
        this.Color = Color;
    }

    public void Aire_acondicionado(String aire_acondicionado) {
        if (aire_acondicionado.equalsIgnoreCase("si")) {
            this.aire_acondicionado = true;
        }
    }

    public void Nitrogeno(String nitrogeno) {
        if (nitrogeno.equalsIgnoreCase("si")) {
            this.nitrogeno = true;
        }
    }

    public void PrecioFinal() {
        if (todoTerreno) {
            costoBase += 10000; peso_total += 3000;
        }
        if (aire_acondicionado) {
            costoBase += 5000; peso_total += 500;
        }
        if (nitrogeno) {
            costoBase += 15000; peso_total += 500;
        }
        System.out.println("El precio del coche modificado es: " + costoBase + ". Tiene un peso total de: " + peso_total / 1000 + " Kg."
                + "\nEl color del coche es: " + Color + "\nFecha de fabricación: " + Fecha_fabricacion);
        System.out.println("Las dimensiones del auto son: " + largo / 100 + "m de largo." + "\n" + ancho / 100 + "m ancho."
                + "\n" + alto / 100 + "m de alto.");
    }
}