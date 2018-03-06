package industria;

/**
 *
 * @author Alejo
 */
public class Furgoneta extends Coches {  //Con la palabra "extends" la clase hereda de otra clase, luego la clase que se usa después del "extends"
                                                                //El "extends" ahorra líneas de código                                                                  
    
    private int capacidad_carga;                    //Se le conoce como "super clase o clase padre" y la clase que va antes se le conoce como "sub clase o clase hijo"
    private int plazas_extra;                         //Esto es lo que se conoce como "Herencia", Java no admite herencia multiple, otros lenguajes sí lo admiten

    public Furgoneta(int plazas_extra, int capacidad_carga) {
        super(); //Esta instrucción llama al constructor de la clase padre o super clase

        this.capacidad_carga = capacidad_carga;
        this.plazas_extra = plazas_extra;
    }
    
    public String dime_datos_furgoneta(){
        return "La capacidad carga es " + capacidad_carga + " y la plazas son: " + plazas_extra;
    }

}
