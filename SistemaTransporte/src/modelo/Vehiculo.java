package modelo;

/**
 * Clase abstracta que representa un vehiculo dentro del sistema de transporte.
 * Todo vehiculo tiene una placa, capacidad maxima de pasajeros y una ruta asignada.
 * 
 * Las subclases concretas deben definir como se realiza el abordaje
 * y como se calcula el costo del viaje.
 */
public abstract class Vehiculo {

    protected String placa;
    protected int capacidadMaxima;
    protected String rutaAsignada;
    protected boolean enServicio;

    public Vehiculo(String placa, int capacidadMaxima, String rutaAsignada) {
        this.placa = placa;
        this.capacidadMaxima = capacidadMaxima;
        this.rutaAsignada = rutaAsignada;
        this.enServicio = true;
    }

    public String getPlaca() { return placa; }

    public int getCapacidadMaxima() { return capacidadMaxima; }

    public String getRutaAsignada() { return rutaAsignada; }
    public void setRutaAsignada(String rutaAsignada) { this.rutaAsignada = rutaAsignada; }

    public boolean isEnServicio() { return enServicio; }
    public void setEnServicio(boolean enServicio) { this.enServicio = enServicio; }

    /**
     * Calcula el costo de un viaje segun la distancia en kilometros.
     * Cada tipo de vehiculo aplica su propia tarifa.
     */
    public abstract double calcularCosto(double distanciaKm);

    /**
     * Describe el proceso de abordaje del vehiculo.
     */
    public abstract String describirAbordaje();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [placa=" + placa
                + ", ruta=" + rutaAsignada
                + ", enServicio=" + enServicio + "]";
    }
}
