package org.example.DAO.Impl;

import org.example.BD.Conexion;
import org.example.DAO.ClienteDAO;
import org.example.modelos.Cliente;
import org.example.modelos.Producto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteImpl implements ClienteDAO {
    @Override
    public void insertar(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Clientes (nombre, apellido, direccion, correo_electronico, telefono, fecha_registro) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getCorreoElectronico());
            ps.setString(5, cliente.getTelefono());
            ps.setDate(6, (Date) cliente.getFechaDeRegistro());
            ps.executeUpdate();
        }
    }

    @Override
    public void actualizar(Cliente cliente) throws SQLException {
        String sql = "UPDATE Clientes SET nombre=?, apellido=?, direccion=?, correo_electronico=?, telefono=?, fecha_registro=? WHERE id_cliente=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getCorreoElectronico());
            ps.setString(5, cliente.getTelefono());
            ps.setDate(6, (Date) cliente.getFechaDeRegistro());
            ps.setInt(7, cliente.getIdCliente());
            ps.executeUpdate();
        }
    }

    @Override
    public void eliminar(int idCliente) throws SQLException {
        String sql = "DELETE FROM Clientes WHERE id_cliente=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            ps.executeUpdate();
        }
    }

    @Override
    public Cliente obtenerPorId(int idCliente) throws SQLException {
        String sql = "SELECT * FROM Clientes WHERE id_cliente=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("direccion"),
                        rs.getString("correo_electronico"),
                        rs.getString("telefono"),
                        rs.getDate("fecha_registro")
                );
            }
        }
        return null;
    }

    @Override
    public List<Cliente> obtenerTodos() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Clientes";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clientes.add(new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("direccion"),
                        rs.getString("correo_electronico"),
                        rs.getString("telefono"),
                        rs.getDate("fecha_registro")
                ));
            }
        }
        return clientes;
    }
}
