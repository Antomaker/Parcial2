package servicios;

import modelo.Vehiculo;
import modelo.Pasajero;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona un viaje concreto: vehiculo asignado, pasajeros a bordo
 * y logica de reserva de cupos.
 *
 * Implementa la interfaz Reservable para garantizar el contrato
 * de gestion de cupos del sistema.
 */
public class GestorViaje implements Reservable {

    private Vehiculo vehiculo;
    private String origen;
    private String destino;
    private double distanciaKm;
    private List<String> pasajerosReservados;

    public GestorViaje(Vehiculo vehiculo, String origen, String destino, double distanciaKm) {
        this.vehiculo           = vehiculo;
        this.origen             = origen;
        this.destino            = destino;
        this.distanciaKm        = distanciaKm;
        this.pasajerosReservados = new ArrayList<>();
    }

    public Vehiculo getVehiculo()    { return vehiculo; }
    public String   getOrigen()      { return origen; }
    public String   getDestino()     { return destino; }
    public double   getDistanciaKm() { return distanciaKm; }

    public double calcularTarifaViaje() {
        return vehiculo.calcularCosto(distanciaKm);
    }

    @Override
    public boolean reservar(String idPasajero) {
        if (getCuposDisponibles() > 0 && !pasajerosReservados.contains(idPasajero)) {
            pasajerosReservados.add(idPasajero);
            return true;
        }
        return false;
    }

    @Override
    public boolean cancelarReserva(String idPasajero) {
        return pasajerosReservados.remove(idPasajero);
    }

  

    @Override
    public String toString() {
        return "Viaje: " + origen + " → " + destino
                + " | Vehiculo: " + vehiculo.getPlaca()
                + " | Pasajeros: " + pasajerosReservados.size()
                + "/" + vehiculo.getCapacidadMaxima();
    }
}
