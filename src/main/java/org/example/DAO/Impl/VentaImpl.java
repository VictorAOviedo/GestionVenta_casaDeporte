package org.example.DAO.Impl;

import org.example.BD.Conexion;
import org.example.DAO.VentaDAO;
import org.example.modelos.Venta;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VentaImpl implements VentaDAO {
    @Override
    public void insertar(Venta venta) throws SQLException {
        String sql = "INSERT INTO Ventas (id_cliente, fecha_venta, total_de_la_venta, id_metodo_pago) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, venta.getIdCliente());
            ps.setDate(2, Date.valueOf(venta.getFechaVenta()));
            ps.setInt(3, venta.getTotalVenta());
            ps.setInt(4, venta.getIdMetodoDP());

            ps.executeUpdate();
        }
    }

    @Override
    public void actualizar(Venta venta) throws SQLException {
        String sql = "UPDATE Ventas SET id_cliente=?, fecha_venta=?, total_de_la_venta=?, id_metodo_pago=? WHERE id_venta=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, venta.getIdCliente());
            ps.setDate(2, Date.valueOf(venta.getFechaVenta()));
            ps.setInt(3, venta.getTotalVenta());
            ps.setInt(4, venta.getIdMetodoDP());
            ps.setInt(6, venta.getIdVenta());
            ps.executeUpdate();
        }
    }

    @Override
    public void eliminar(int idVenta) throws SQLException {
        String sql = "DELETE FROM Ventas WHERE id_venta=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idVenta);
            ps.executeUpdate();
        }
    }

    @Override
    public Venta obtenerPorId(int idVenta) throws SQLException {
        String sql = "SELECT * FROM Ventas WHERE id_venta=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idVenta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Venta(
                        rs.getInt("id_venta"),
                        rs.getInt("id_cliente"),
                        rs.getDate("fecha_venta").toLocalDate(),
                        rs.getInt("total_de_la_venta"),
                        rs.getInt("id_metodo_pago")
                );
            }
        }
        return null;
    }

    @Override
    public List<Venta> obtenerTodos() throws SQLException {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT * FROM Ventas";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ventas.add(new Venta(
                        rs.getInt("id_venta"),
                        rs.getInt("id_cliente"),
                        rs.getDate("fecha_venta").toLocalDate(),
                        rs.getInt("total_de_la_venta"),
                        rs.getInt("id_metodo_pago")
                ));
            }
        }
        return ventas;
    }
}
