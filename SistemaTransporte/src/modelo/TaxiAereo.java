package modelo;

/**
 * Representa un taxi aereo (helicoptero o aeronave pequena) del sistema.
 * Opera en rutas especiales con tarifa premium por kilometro.
 *
 * Tarifa: $2500 por km + cargo fijo de despegue.
 */
public class TaxiAereo extends Vehiculo {

    private static final double TARIFA_KM    = 2500.0;
    private static final double CARGO_FIJO   = 15000.0;

    private int altitudMaximaMetros;
    private String modeloAeronave;

    public TaxiAereo(String placa, int capacidadMaxima, String rutaAsignada,
                     int altitudMaximaMetros, String modeloAeronave) {
        super(placa, capacidadMaxima, rutaAsignada);
        this.altitudMaximaMetros = altitudMaximaMetros;
        this.modeloAeronave = modeloAeronave;
    }

    public int getAltitudMaximaMetros() { return altitudMaximaMetros; }

    public String getModeloAeronave() { return modeloAeronave; }
    public void setModeloAeronave(String modeloAeronave) {
        this.modeloAeronave = modeloAeronave;
    }

    @Override
    public double calcularCosto(double distanciaKm) {
        return CARGO_FIJO + (distanciaKm * TARIFA_KM);
    }

    @Override
    public String describirAbordaje() {
        return "Abordaje en helipuerto autorizado. Equipaje maximo 10 kg. "
                + "Aeronave: " + modeloAeronave + ".";
    }
}
