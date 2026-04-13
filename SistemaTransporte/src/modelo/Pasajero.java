package modelo;

/**
 * Representa a un pasajero registrado en el sistema de transporte.
 * Cada pasajero tiene una tarjeta con saldo para pagar sus viajes.
 */
public class Pasajero {

    private String nombre;
    private String cedula;
    private String correo;
    protected double saldo;     

    public Pasajero(String nombre, String cedula, String correo, double saldoInicial) {
        this.nombre  = nombre;
        this.cedula  = cedula;
        this.correo  = correo;
        this.saldo   = saldoInicial;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCedula() { return cedula; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public double getSaldo() { return saldo; }

    /**
     * Recarga saldo a la tarjeta del pasajero.
     * Solo acepta montos positivos.
     */
    public void recargarSaldo(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }

    /**
     * Descuenta del saldo si hay fondos suficientes.
     * @return true si el pago fue exitoso, false si no habia saldo.
     */
    public boolean pagar(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Pasajero [" + nombre + " | CC: " + cedula
                + " | Saldo: $" + String.format("%.0f", saldo) + "]";
    }
}
