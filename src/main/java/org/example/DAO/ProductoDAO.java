package org.example.DAO;

import org.example.modelos.Producto;

import java.sql.SQLException;
import java.util.List;

public interface ProductoDAO {
    void insertar (Producto producto) throws SQLException;
    void actualizar (Producto producto) throws SQLException;
    void eliminar(int Producto) throws SQLException;
    Producto obtenerPorId (int Producto) throws SQLException;
    List<Producto> obtenerTodos() throws SQLException;
}
