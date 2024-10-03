package org.example.DAO.Impl;

import org.example.BD.Conexion;
import org.example.DAO.MetodoDePagoDAO;
import org.example.modelos.MetodoDePago;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MetodoDePagoImpl implements MetodoDePagoDAO {
    @Override
    public void insertar(MetodoDePago metodoDePago) throws SQLException {
        String sql = "INSERT INTO Metodos_de_pago (descripcion) VALUES (?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, metodoDePago.getDescripcion());
            ps.executeUpdate();
        }
    }

    @Override
    public void actualizar(MetodoDePago metodoDePago) throws SQLException {
        String sql = "UPDATE Metodos_de_pago SET descripcion=? WHERE id_metodo_pago=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, metodoDePago.getDescripcion());
            ps.setInt(2,metodoDePago.getIdMetodoPago());
            ps.executeUpdate();
        }
    }

    @Override
    public void eliminar(int idMetodoPago) throws SQLException {
        String sql = "DELETE FROM Metodos_de_pago WHERE id_metodo_pago=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idMetodoPago);
            ps.executeUpdate();
        }
    }

    @Override
    public MetodoDePago obtenerPorId(int idMetodoPago) throws SQLException {
        String sql = "SELECT * FROM Metodos_de_pago WHERE id_metodo_pago=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idMetodoPago);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new MetodoDePago(
                        rs.getInt("id_metodo_pago"),
                        rs.getString("descripcion")
                );
            }
        }
        return null;
    }

    @Override
    public List<MetodoDePago> obtenerTodos() throws SQLException {
        List<MetodoDePago> metodosDP = new ArrayList<>();
        String sql = "SELECT * FROM Metodos_de_pago";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                metodosDP.add(new MetodoDePago(
                        rs.getInt("id_metodo_pago"),
                        rs.getString("descripcion")
                ));
            }
        }
        return metodosDP;
    }
}
