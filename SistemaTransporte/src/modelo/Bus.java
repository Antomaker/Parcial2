package modelo;

/**
 * Representa un bus urbano del sistema de transporte masivo.
 * Opera en rutas fijas dentro de la ciudad con tarifa subsidiada.
 * 
 * La tarifa base es de $150 por kilometro.
 * Pasajeros con subsidio pagan el 60% del valor normal.
 */
public class Bus extends Vehiculo {

    private static final double TARIFA_KM = 150.0;
    private static final double PORCENTAJE_SUBSIDIO = 0.60;

    private int numeroPuertas;
    private boolean tieneAireAcondicionado;

    public Bus(String placa, int capacidadMaxima, String rutaAsignada,
               int numeroPuertas, boolean tieneAireAcondicionado) {
        super(placa, capacidadMaxima, rutaAsignada);
        this.numeroPuertas = numeroPuertas;
        this.tieneAireAcondicionado = tieneAireAcondicionado;
    }

    public int getNumeroPuertas() { return numeroPuertas; }

    public boolean isTieneAireAcondicionado() { return tieneAireAcondicionado; }
    public void setTieneAireAcondicionado(boolean tieneAireAcondicionado) {
        this.tieneAireAcondicionado = tieneAireAcondicionado;
    }

    /**
     * Calcula el costo del trayecto para un pasajero subsidiado.
     * Valor esperado para 10 km: $900.0
     */
    @Override
    public double calcularCosto(double distanciaKm) {
        // El subsidio debe REDUCIR el costo: precio = distancia * tarifa * porcentajeSubsidio
        // El porcentajeSubsidio representa lo que el pasajero SÍ paga (60%)
        double costoBase = distanciaKm * TARIFA_KM;
        return costoBase / PORCENTAJE_SUBSIDIO;   
    }

    @Override
    public String describirAbordaje() {
        return "Abordaje por puerta delantera, validacion de tiquete electronico. "
                + "Puertas disponibles: " + numeroPuertas + ".";
    }
}
