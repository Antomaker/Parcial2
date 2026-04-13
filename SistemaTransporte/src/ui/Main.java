package ui;

import modelo.*;
import servicios.*;
import util.*;

import java.util.ArrayList;
import java.util.List;

/**
 * =========================================================
 *   SISTEMA DE TRANSPORTE — Punto de entrada
 *   Parcial Programacion Orientada a Objetos
 * =========================================================
 *
 *  INSTRUCCIONES:
 *  - NO modifiques este archivo.
 *  - Corrige los fallos en los paquetes modelo, servicios y util.
 *  - Cuando todo este bien, la salida debe coincidir con los
 *    valores "Esperado" que aparecen en los println.
 * =========================================================
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=================================================");
        System.out.println("    SISTEMA DE TRANSPORTE — Verificacion Final");
        System.out.println("=================================================\n");

        // ── 1. Creacion de vehiculos (herencia + clases abstractas) ──────
        Bus bus1 = new Bus("BUS-001", 40, "Ruta Norte", 3, true);
        Bus bus2 = new Bus("BUS-002", 35, "Ruta Sur",   2, false);
        TaxiAereo taxi = new TaxiAereo("TAX-001", 4, "Ruta Aerea Central", 3000, "Bell 407");
        bus2.setEnServicio(false);   // fuera de servicio para probar el reporte

        List<Vehiculo> flota = new ArrayList<>();
        flota.add(bus1);
        flota.add(bus2);
        flota.add(taxi);

        // ── 2. Costo de viaje (sobreescritura de calcularCosto) ──────────
        System.out.println("── Costos de viaje para 10 km ──");
        System.out.printf("Bus (10 km)       → Esperado: $900.00   | Obtenido: $%.2f%n",
                bus1.calcularCosto(10));
        System.out.printf("Taxi aereo (10 km)→ Esperado: $40000.00 | Obtenido: $%.2f%n",
                taxi.calcularCosto(10));

        // ── 3. Pasajeros y herencia ──────────────────────────────────────
        System.out.println("\n── Pasajeros ──");
        Pasajero p1 = new Pasajero("Maria Torres", "1090123456", "maria@mail.com", 50000);
        PasajeroFrecuente pf = new PasajeroFrecuente(
                "Juan Perez", "1001234567", "juan@mail.com", 80000, "ORO");

        System.out.println(p1);
        System.out.println(pf);
        System.out.println("Saldo frecuente → Esperado: $80000 | Obtenido: $"
                + String.format("%.0f", pf.getSaldo()));
        System.out.println("Descuento ORO   → Esperado: 20%    | Obtenido: "
                + (int)(pf.obtenerDescuento() * 100) + "%");

        // ── 4. Gestor de viaje (interfaz Reservable) ─────────────────────
        System.out.println("\n── Reservas de viaje ──");
        GestorViaje viaje = new GestorViaje(bus1, "Terminal Norte", "Plaza Central", 8.5);
        viaje.reservar(p1.getCedula());
        viaje.reservar(pf.getCedula());
        System.out.println(viaje);
        System.out.println("Cupos disponibles → Esperado: 38 | Obtenido: "
                + viaje.getCuposDisponibles());

        boolean cancelado = viaje.cancelarReserva(p1.getCedula());
        System.out.println("Cancelacion exitosa → Esperado: true | Obtenido: " + cancelado);
        System.out.println("Cupos tras cancelar → Esperado: 39  | Obtenido: "
                + viaje.getCuposDisponibles());

        // ── 5. Reporte de flota (polimorfismo + util) ────────────────────
        System.out.println();
        ReporteFlota.imprimirResumen(flota);
        System.out.println("Vehiculos en servicio → Esperado: 2 | Obtenido: "
                + ReporteFlota.contarEnServicio(flota));

        System.out.println("\n=================================================");
        System.out.println("   Fin de la verificacion");
        System.out.println("=================================================");
    }
}
