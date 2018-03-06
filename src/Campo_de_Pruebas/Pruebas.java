package Campo_de_Pruebas;

/**
 *
 * @author Alejo
 */
public class Pruebas {

    public static void main(String[] args) {
Empleados trabajador1 = new Empleados("Alejandro");
Empleados trabajador2 = new Empleados ("Rafael");
Empleados trabajador3 = new Empleados("Putin");
Empleados trabajador4= new Empleados("Pendejin");

trabajador1.cambia_seccion("Recursos humanos");
        System.out.println(trabajador1.devuelve_datos() + "\n" + trabajador2.devuelve_datos() + "\n" + trabajador3.devuelve_datos() +
                "\n" + trabajador4.devuelve_datos());
        System.out.println(Empleados.dame_idSiguiente());
    }
}

class Empleados {

    private final String nombre;
    private String seccion;
    private int id;
    private static int id_siguiente=1; //Una variable static no puede ser usada fuera de la clase por otra variable u objeto
                                                     //Si quiero usar una variable static fuera de la clase tengo que usar 
                                                     //una función para poder llevar fuera de la clase la variable  

    public Empleados(String nom) {
        nombre = nom;
        seccion = "Administración";
        id =id_siguiente;
        id_siguiente++;
    }
    
   public static String dame_idSiguiente(){  //Los metodos estaticos no actuan sobre objetos, tienen que usarse así: nombre_de_la_clase.variableStatic
       return "El Id siguiente es: " + id_siguiente;  //Las variables que se usen en los metodos static también tienen que ser estaticos, no ocurre lo contrario con las varibales publicas
   }                                                            //Es decír, una variable estatica puede ser usada en un contexto público pero una variable pública no puede ser usara en un contexto estatico

    public void cambia_seccion(String seccion) {
        this.seccion = seccion;
    }

    public String devuelve_datos(){
        return "El nombre es " + nombre + " y la seccion es " + seccion + " y el ID es: " + id;
    }
}
