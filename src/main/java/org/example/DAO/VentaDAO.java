package org.example.DAO;

import org.example.modelos.Venta;

import java.sql.SQLException;
import java.util.List;

public interface VentaDAO {
    void insertar (Venta venta) throws SQLException;
    void actualizar (Venta venta) throws SQLException;
    void eliminar(int Venta) throws SQLException;
    Venta obtenerPorId (int Venta) throws SQLException;
    List<Venta> obtenerTodos() throws SQLException;
}
