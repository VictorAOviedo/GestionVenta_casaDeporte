package org.example.DAO.Impl;

import org.example.BD.Conexion;
import org.example.DAO.ProveedorDAO;
import org.example.modelos.Proveedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProveedorImpl implements ProveedorDAO {
    @Override
    public void insertar(Proveedor proveedor) throws SQLException {
        String sql = "INSERT INTO Proveedores (nombre_empresa, razon_social, direccion, correo_electronico, telefono) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, proveedor.getNombreEmpresa());
            ps.setString(2, proveedor.getRazonSocial());
            ps.setString(3, proveedor.getDireccion());
            ps.setString(4, proveedor.getCorreoElectronico());
            ps.setString(5, proveedor.getTelefono());

            ps.executeUpdate();
        }
    }

    @Override
    public void actualizar(Proveedor proveedor) throws SQLException {
        String sql = "UPDATE Proveedores SET nombre_empresa=?, razon_social=?, direccion=?, correo_electronico=?, telefono=? WHERE id_proveedor=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, proveedor.getNombreEmpresa());
            ps.setString(2, proveedor.getRazonSocial());
            ps.setString(3, proveedor.getDireccion());
            ps.setString(4, proveedor.getCorreoElectronico());
            ps.setString(5, proveedor.getTelefono());
            ps.setInt(6, proveedor.getIdProveedor());
            ps.executeUpdate();
        }
    }

    @Override
    public void eliminar(int idProveedor) throws SQLException {
        String sql = "DELETE FROM Proveedores WHERE id_proveedor=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idProveedor);
            ps.executeUpdate();
        }
    }

    @Override
    public Proveedor obtenerPorId(int idProveedor) throws SQLException {
        String sql = "SELECT * FROM Proveedores WHERE id_proveedor=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idProveedor);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Proveedor(
                        rs.getInt("id_proveedor"),
                        rs.getString("nombre_empresa"),
                        rs.getString("direccion"),
                        rs.getString("razon_social"),
                        rs.getString("correo_electronico"),
                        rs.getString("telefono")
                );
            }
        }
        return null;
    }

    @Override
    public List<Proveedor> obtenerTodos() throws SQLException {
        List<Proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM Proveedores";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                proveedores.add(new Proveedor(
                        rs.getInt("id_proveedor"),
                        rs.getString("nombre_empresa"),
                        rs.getString("direccion"),
                        rs.getString("razon_social"),
                        rs.getString("correo_electronico"),
                        rs.getString("telefono")
                ));
            }
        }
        return proveedores;
    }
}
