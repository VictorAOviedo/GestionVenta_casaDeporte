package org.example.modelos;

public class DetalleVenta {
    private int idDetalleVenta;
    private int idVenta;
    private int idProducto;
    private int cantidadV;
    private int precioUnitario;

    //Constructor
    public DetalleVenta() {
    }

    public DetalleVenta(int idDetalleVenta, int idVenta, int idProducto, int cantidadV, int precioUnitario) {
        this.idDetalleVenta = idDetalleVenta;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidadV = cantidadV;
        this.precioUnitario = precioUnitario;
    }
    //Getter y Setter
    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidadV() {
        return cantidadV;
    }

    public void setCantidadV(int cantidadV) {
        this.cantidadV = cantidadV;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }


    //toString


    @Override
    public String toString() {
        return "DetalleVenta{" +
                "idDetalleVenta=" + idDetalleVenta +
                ", idVenta=" + idVenta +
                ", idProducto=" + idProducto +
                ", cantidadV=" + cantidadV +
                ", precioUnitario=" + precioUnitario +
                '}';
    }
}
