package Pruebas;

import javax.swing.JOptionPane;

/**
 *
 * @author Alejo
 */
public class Prueba3 {

    public static void main(String[] args) {
        Cuadernos cuadernos = new Cuadernos();
        System.out.println(cuadernos.MuestraDatosCuaderno());
    }

}

final class Cuadernos {

    public Cuadernos() {
        FabricacionCuaderno = 1;
        ContinuarCuadernos = true;

        while (ContinuarCuadernos) {
            CantidadCuadernos = Fabricacion(CantidadCuadernos);
            Verificador = JOptionPane.showInputDialog("¿Desea continuar creando cuadernos?");
            if ("no".equalsIgnoreCase(Verificador)) {
                ContinuarCuadernos = false;
            }
        }
        Personalizacion();
    }

    public int Fabricacion(int cuadernos) {
        return cuadernos += FabricacionCuaderno;
    }

    public String MuestraDatosCuaderno() {
        return "El día de hoy se fabricaron: " + CantidadCuadernos + "cuadernos" + "\n" + Rojos + " Son rojos" + "\n" + Azules
                + " Son azules" + "\n" + Amarillos + " Son amarillos";
    }

    public void Personalizacion() {
        int i = 0;
        while (i < CantidadCuadernos) {
            Opcion = Integer.parseInt(JOptionPane.showInputDialog("Escoja el color para los cuadernos. 1=Rojo. 2=Azul. 3=Amarillos"));
            while (Opcion < 1 || Opcion > 3) {
                Opcion = Integer.parseInt(JOptionPane.showInputDialog("1=Rojo. 2=Azul. 3=Amarillos"));
            }
            if (Opcion == 1) {
                Rojos += 1;
            }
            if (Opcion == 2) {
                Azules += 1;
            }
            if (Opcion == 3) {
                Amarillos += 1;
            }
            i += 1;
        }
    }
    private final int FabricacionCuaderno;
    private int CantidadCuadernos, Opcion, Rojos, Azules, Amarillos;
    private boolean ContinuarCuadernos;
    private String Verificador;
}
