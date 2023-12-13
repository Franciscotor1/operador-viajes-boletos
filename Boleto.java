public class Boleto {
    private int numeroBoleto;
    private String nombreCliente;
    private String destino;
    private int tipoViaje;
    private double precio;
    private String fecha;
    private boolean esAdultoMayor;

    public Boleto(int numeroBoleto, String nombreCliente, String destino, int tipoViaje, double precio, String fecha, boolean esAdultoMayor) {
        this.numeroBoleto = numeroBoleto;
        this.nombreCliente = nombreCliente;
        this.destino = destino;
        this.tipoViaje = tipoViaje;
        this.precio = precio;
        this.fecha = fecha;
        this.esAdultoMayor = esAdultoMayor;
    }

    public double calcularImporte() {
        if (tipoViaje == 1) {
            return precio;
        } else if (tipoViaje == 2) {
            return precio + (precio * 0.8);
        } else {
            throw new IllegalArgumentException("Tipo de viaje no válido");
        }
    }

    public double calcularImpuesto() {
        return calcularImporte() * 0.16;
    }

    public double calcularDescuento() {
        double descuento = 0;

        if (esAdultoMayor) {
            descuento = calcularImporte() * 0.5;
        }

        return descuento;
    }

    public double calcularTotalPagar() {
        return calcularImporte() + calcularImpuesto() - calcularDescuento();
    }

    public int getNumeroBoleto() {
        return numeroBoleto;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getDestino() {
        return destino;
    }

    public int getTipoViaje() {
        return tipoViaje;
    }

    public double getPrecio() {
        return precio;
    }

    public String getFecha() {
        return fecha;
    }

    public boolean isEsAdultoMayor() {
        return esAdultoMayor;
    }
}
