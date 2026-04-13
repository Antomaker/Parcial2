package util;

import modelo.Vehiculo;
import java.util.List;

/**
 * Genera reportes estadisticos sobre la flota de vehiculos
 * registrada en el sistema de transporte.
 */
public class ReporteFlota {

    /**
     * Cuenta cuantos vehiculos estan actualmente en servicio.
     *
     * 
     *
     * @param flota lista completa de vehiculos
     * @return numero de vehiculos en servicio
     */
    //  el ! sobra;
    public static int contarEnServicio(List<Vehiculo> flota) {
        int contador = 0;
        for (Vehiculo v : flota) {
            if (!v.isEnServicio()) {     
                contador++;
            }
        }
        return contador;
    }

    /**
     * Calcula el ingreso potencial de toda la flota para una distancia dada.
     * Usa polimorfismo: llama calcularCosto() sin importar el tipo de vehiculo.
     */
    public static double calcularIngresoTotal(List<Vehiculo> flota, double distanciaKm) {
        double total = 0;
        for (Vehiculo v : flota) {
            if (v.isEnServicio()) {
                total += v.calcularCosto(distanciaKm);
            }
        }
        return total;
    }

    /**
     * Imprime un resumen de la flota por consola.
     * Demuestra polimorfismo: toString() se resuelve en tiempo de ejecucion.
     */
    public static void imprimirResumen(List<Vehiculo> flota) {
        System.out.println("========== REPORTE DE FLOTA ==========");
        for (Vehiculo v : flota) {
            System.out.println("  " + v);                          // polimorfismo
            System.out.printf("  Abordaje: %s%n", v.describirAbordaje());
            System.out.println();
        }
        System.out.println("Vehiculos en servicio  : " + contarEnServicio(flota));
        System.out.println("Ingreso potencial/10km : $"
                + String.format("%.2f", calcularIngresoTotal(flota, 10)));
        System.out.println("======================================");
    }
}
