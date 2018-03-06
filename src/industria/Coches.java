package industria;

/**
 *
 * @author Alejo
 */
public class Coches {

    private int ruedas;
    private int motor;
    private int largo;
    private int ancho;
    private int peso_plataforma;
    private String Color;
    private int peso_total;
    private boolean asientos_cuero, climatizador;

    public Coches() {
        ruedas = 4;
        motor = 1600;
        largo = 2000;
        ancho = 400;
        peso_plataforma = 500;
        asientos_cuero = false;
        climatizador = false;
    }

    public String dime_datos_generales() {    //Metodo Getter, también parece una función, aunque las propiedades esten encapsuladas con este metodo puedo mostrarla y usarlas en otra clase. 

        return "La plataforma del vehiculo tiene " + ruedas + " ruedas" + ". Mide " + largo / 1000 + " metros de largo"
                + " con un ancho de " + ancho + " centimetros y un peso de la plataforma de " + peso_plataforma + " kilos";
    }

    public void poner_color(String color_coche) { //Metodo Setter, también parece un procedimento, no devuelve un valor a diferencia del metodo getter
        //Color = "azul";
        Color = color_coche;
    }

    public String dime_color() {
        return "El color del coche es " + Color;
    }

    public void configura_asientos(String asientos_cuero) {
        if (asientos_cuero.equalsIgnoreCase("si")) {
            this.asientos_cuero = true;
        }
    }

    public String dime_asientos() {
        if (asientos_cuero) {
            return "El coche tiene asientos de cuero";
        } else {
            return "El coche tiene asientos de serie";
        }
    }

    public void Configura_climatizador(String climatizador) {
        if (climatizador.equalsIgnoreCase("si")) {
            this.climatizador = true;
        } else{
            this.climatizador = false;
        }
    }

    public String dime_climatizador() {
        if (climatizador) {
            return "el coche tiene climatizador";
        } else {
            return "el coche tiene aire acondicionado";
        }
    }
    
    
    public String dime_peso_coche(){ //Setter y Getter combinados. No del todo recomendado pero si sabes usarlo no hay problema
        int peso_carroceria = 500;
        peso_total = peso_plataforma + peso_carroceria;
        
        if(asientos_cuero = true){
            peso_total = peso_total + 50;
        }
        
        if(climatizador = true){
            peso_total = peso_total + 20;
        }
        return "El peso total del coche es " + peso_total / 1000 + " Kg";
    }
    
    
    public int dime_precio(){
        int precio_final = 10000;
        if(asientos_cuero){
            precio_final+=2000;
        }
        
        if(climatizador){
            precio_final+=1500;
        }
        return precio_final;
    }
}