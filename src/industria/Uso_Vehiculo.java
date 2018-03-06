package industria;

//import javax.swing.JOptionPane; Lo utilice con el código antes de la furgoneta

/**
 *
 * @author Alejo
 */
public class Uso_Vehiculo {

    public static void main(String[] args){
        //Coches BMW = new Coches(); Instanciar una clase, ejemplar de clase
        
        //System.out.println("Este coche tiene " + BMW.ruedas + " ruedas"); No se puede mostrar un dato o modificar si los valores a mostrar estan encapsulados (En otra clase)
        //System.out.println(BMW.dime_largo());
        
        
        /*Coches Mazda = new Coches();
        Mazda.poner_color(JOptionPane.showInputDialog("Introduce el color"));
        
        System.out.println(Mazda.dime_datos_generales());        
        System.out.println(Mazda.dime_color());
        
        Mazda.configura_asientos(JOptionPane.showInputDialog("¿Tiene asientos de cuero?"));
        
        System.out.println(Mazda.dime_asientos());
        
        Mazda.Configura_climatizador(JOptionPane.showInputDialog("¿Tiene climatizador?"));
        
        System.out.println(Mazda.dime_climatizador());
        
        System.out.println(Mazda.dime_peso_coche());
        
        System.out.println("El precio del coche es " + Mazda.dime_precio());*/ //Este código fue el primero que hice antes de la furgoneta
        
        Coches toyota = new Coches();
        
        toyota.poner_color("Rojo");
        
        Furgoneta volvo = new Furgoneta(7, 580);
        
        volvo.poner_color("Azul");
        
        volvo.configura_asientos("si");
        
        volvo.Configura_climatizador("si");
        
        System.out.println(toyota.dime_datos_generales() + " \n" + toyota.dime_color()); //No es posible que yo utilize un objeto de una diferente clase con los metodos de una 
                                                                                       //Diferente clase, es decir, el objeto "toyota" nunca podrá usar un metodo que pertenezca a la clase Furgoneta
        System.out.println(volvo.dime_datos_generales() + ". " +volvo.dime_datos_furgoneta()); //Sin embargo, la furgoneta si puede usar los metodos de la clase Coches al estar 
                                                                                                                                     //Heredando de esa clase 
                                                                                                                                     
         /*La herencia se usaría mejor si hubiese una clase en general que reuna la misma defición de todos los objetos, es decir, en este caso en particular
         todos los objetos creados fueron vehiculos por lo que se pudo haber creado una clase principal que se hubiese llamado vehiculo que es donde
          se le daría las caracteristicas principales a los objetos y todos los objetos heradaran de esa misma clase Vehiculo*/
         
         //Para la herencia hay que tener en cuenta SIEMPRE la regla "ES UN..."
    }
}