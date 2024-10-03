package org.example.modelos;

public class Producto {
    private int idProducto;
    private String nombre;
    private int idCategoria;
    private String descripcion;
    private int precio;
    private int cantidadStock;
    private int idProveedor;

    //Constructores
    public Producto() {
    }

    public Producto(int idProducto, String nombre, int idCategoria, String descripcion, int precio, int cantidadStock, int idProveedor) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.idProveedor = idProveedor;
    }

    // Getter y Setter


    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    //toString
    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", idCategoria=" + idCategoria +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", cantidadStock=" + cantidadStock +
                ", idProveedor=" + idProveedor +
                '}';
    }
}
