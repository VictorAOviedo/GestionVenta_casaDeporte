package org.example.modelos;

import java.time.LocalDate;

public class Venta {
    private int idVenta;
    private int idCliente;
    private LocalDate fechaVenta;
    private int totalVenta;
    private int idMetodoDP;

    //Constructores
    public Venta() {
    }

    public Venta(int idVenta, int idCliente, LocalDate fechaVenta, int totalVenta, int idMetodoDP) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.fechaVenta = fechaVenta;
        this.totalVenta = totalVenta;
        this.idMetodoDP = idMetodoDP;
    }

    //Getter y Setter
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(int totalVenta) {
        this.totalVenta = totalVenta;
    }

    public int getIdMetodoDP() {
        return idMetodoDP;
    }

    public void setIdMetodoDP(int idMetodoDP) {
        this.idMetodoDP = idMetodoDP;
    }


    //toString
    @Override
    public String toString() {
        return "Venta{" +
                "idVenta=" + idVenta +
                ", idCliente=" + idCliente +
                ", fechaVenta=" + fechaVenta +
                ", totalVenta=" + totalVenta +
                ", idMetodoDP=" + idMetodoDP +
                '}';
    }
}
