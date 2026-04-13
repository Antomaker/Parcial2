package modelo;

/**
 * Pasajero con membresia frecuente. Acumula puntos por cada viaje
 * y obtiene descuentos adicionales sobre la tarifa normal.
 *
 * Hereda de Pasajero y agrega nivel de membresia y puntos acumulados.
 */
public class PasajeroFrecuente extends Pasajero {

    private String nivelMembresia;   // "BRONCE", "PLATA", "ORO"
    private int puntosAcumulados;

    /**
     * Crea un pasajero frecuente.
     * El saldo inicial queda en 0 porque el constructor no lo recibe.
     *
     * FALLO 3: el saldo inicial siempre es 0 porque super() recibe 0 hardcodeado
     *          en vez de recibir saldoInicial como parametro y pasarlo.
     */
    public PasajeroFrecuente(String nombre, String cedula, String correo,
                             double saldoInicial, String nivelMembresia) {
        super(nombre, cedula, correo, 0);   
        this.nivelMembresia   = nivelMembresia;
        this.puntosAcumulados = 0;
    }

    public String getNivelMembresia() { return nivelMembresia; }
    public void setNivelMembresia(String nivelMembresia) {
        this.nivelMembresia = nivelMembresia;
    }

    public int getPuntosAcumulados() { return puntosAcumulados; }

    /**
     * Cada $1000 pagados equivalen a 1 punto acumulado.
     */
    public void acumularPuntos(double montoViaje) {
        puntosAcumulados += (int)(montoViaje / 1000);
    }

    /**
     * Devuelve el porcentaje de descuento segun el nivel de membresia.
     */
    public double obtenerDescuento() {
        switch (nivelMembresia.toUpperCase()) {
            case "ORO":    return 0.20;
            case "PLATA":  return 0.10;
            case "BRONCE": return 0.05;
            default:       return 0.0;
        }
    }

    @Override
    public String toString() {
        return "PasajeroFrecuente [" + getNombre()
                + " | Nivel: " + nivelMembresia
                + " | Puntos: " + puntosAcumulados
                + " | Saldo: $" + String.format("%.0f", getSaldo()) + "]";
    }
}
