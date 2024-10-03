package org.example.modelos;

public class MetodoDePago {
    private int idMetodoPago;
    private String descripcion;

    //Constructores
    public MetodoDePago() {
    }

    public MetodoDePago(int idMetodoPago, String descripcion) {
        this.idMetodoPago = idMetodoPago;
        this.descripcion = descripcion;
    }

    //Getter y Setter
    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //toString
    @Override
    public String toString() {
        return "MetodoDePago{" +
                "idMetodoPago=" + idMetodoPago +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
