package org.example.DAO;

import org.example.modelos.Proveedor;

import java.sql.SQLException;
import java.util.List;

public interface ProveedorDAO {
    void insertar (Proveedor proveedor) throws SQLException;
    void actualizar (Proveedor proveedor) throws SQLException;
    void eliminar(int Proveedor) throws SQLException;
    Proveedor obtenerPorId (int Proveedor) throws SQLException;
    List<Proveedor> obtenerTodos() throws SQLException;
}
