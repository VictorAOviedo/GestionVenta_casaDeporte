package org.example.DAO;

import org.example.modelos.DetalleVenta;

import java.sql.SQLException;
import java.util.List;

public interface DetalleVentaDAO {
    void insertar (org.example.modelos.DetalleVenta detalleVenta) throws SQLException;
    void actualizar (DetalleVenta detalleVenta) throws SQLException;
    void eliminar(int DetalleVenta) throws SQLException;
    DetalleVenta obtenerPorId (int DetalleVenta) throws SQLException;
    List<DetalleVenta> obtenerTodos() throws SQLException;
}
