package servicios;

/**
 * Interfaz que define el contrato de reserva para cualquier viaje
 * dentro del sistema de transporte.
 *
 * Toda clase que gestione reservas debe implementar estos tres metodos.
 */
public interface Reservable {

    /**
     * Realiza la reserva de un cupo en el viaje.
     * @param idPasajero identificador del pasajero
     * @return true si la reserva fue exitosa
     */
    boolean reservar(String idPasajero);

    /**
     * Cancela una reserva existente.
     * @param idPasajero identificador del pasajero
     * @return true si la cancelacion fue exitosa
     */
    boolean cancelarReserva(String idPasajero);

    /**
     * Devuelve el numero de cupos disponibles actualmente.
     */
    int getCuposDisponibles();
}
