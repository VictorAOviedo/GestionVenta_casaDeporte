package org.example.modelos;

public class Proveedor {
    private int idProveedor;
    private String nombreEmpresa;
    private String razonSocial;
    private String direccion;
    private String correoElectronico;
    private String telefono;

    //Constructores
    public Proveedor() {
    }

    public Proveedor(int idProveedor, String nombreEmpresa, String razonSocial, String direccion, String correoElectronico, String telefono) {
        this.idProveedor = idProveedor;
        this.nombreEmpresa = nombreEmpresa;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
    }

    //Getter y Setter
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    //toString
    @Override
    public String toString() {
        return "Proveedor{" +
                "idProducto=" + idProveedor +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                ", direccion='" + direccion + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
