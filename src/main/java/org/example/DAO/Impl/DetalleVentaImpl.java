package org.example.DAO.Impl;

import org.example.BD.Conexion;
import org.example.DAO.DetalleVentaDAO;
import org.example.modelos.DetalleVenta;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DetalleVentaImpl implements DetalleVentaDAO {
    @Override
    public void insertar(DetalleVenta detalleVenta) throws SQLException {
        String sql = "INSERT INTO Detalles_de_venta (id_venta, id_producto, cantidad_vendida, precio_unitario) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, detalleVenta.getIdVenta());
            ps.setInt(2, detalleVenta.getIdProducto());
            ps.setInt(3, detalleVenta.getCantidadV());
            ps.setInt(4, detalleVenta.getPrecioUnitario());

            ps.executeUpdate();
        }
    }

    @Override
    public void actualizar(DetalleVenta detalleVenta) throws SQLException {
        String sql = "UPDATE Detalles_de_venta SET id_venta=?, id_producto=?, cantidad_vendida=?, precio_unitario=? WHERE id_detalle=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, detalleVenta.getIdVenta());
            ps.setInt(2, detalleVenta.getIdProducto());
            ps.setInt(3, detalleVenta.getCantidadV());
            ps.setInt(4, detalleVenta.getPrecioUnitario());
            ps.setInt(5, detalleVenta.getIdDetalleVenta());
            ps.executeUpdate();
        }
    }

    @Override
    public void eliminar(int idDetalleVenta) throws SQLException {
        String sql = "DELETE FROM Detalles_de_venta WHERE id_detalle=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idDetalleVenta);
            ps.executeUpdate();
        }
    }

    @Override
    public DetalleVenta obtenerPorId(int idDetalleV) throws SQLException {
        String sql = "SELECT * FROM Detalles_de_venta WHERE id_detalle=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idDetalleV);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new DetalleVenta(
                        rs.getInt("id_detalle"),
                        rs.getInt("id_venta"),
                        rs.getInt("id_producto"),
                        rs.getInt("cantidad_vendida"),
                        rs.getInt("precio_unitario")
                );
            }
        }
        return null;
    }

    @Override
    public List<DetalleVenta> obtenerTodos() throws SQLException {
        List<DetalleVenta> detalleDV = new ArrayList<>();
        String sql = "SELECT * FROM Detalles_de_venta";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                detalleDV.add(new DetalleVenta(
                        rs.getInt("id_detalle"),
                        rs.getInt("id_venta"),
                        rs.getInt("id_producto"),
                        rs.getInt("cantidad_vendida"),
                        rs.getInt("precio_unitario")
                ));
            }
        }
        return detalleDV;
    }
}
