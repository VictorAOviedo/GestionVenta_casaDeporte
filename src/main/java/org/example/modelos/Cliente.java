package org.example.modelos;

import java.util.Date;

public class Cliente {
    private int idCliente;
    private String nombre;
    private String apellido;
    private String direccion;
    private String correoElectronico;
    private String telefono;
    private Date fechaDeRegistro;

    //Constructores
    public Cliente() {
    }

    public Cliente(int idCliente, String nombre, String apellido, String direccion, String correoElectronico, String telefono, Date fechaDeRegistro) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.fechaDeRegistro = fechaDeRegistro;
    }

    //Getter y Setter
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public Date getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(Date fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }

    //toString

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", telefono=" + telefono +
                ", fechaDeRegistro=" + fechaDeRegistro +
                '}';
    }
}


