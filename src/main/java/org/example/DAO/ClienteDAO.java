package org.example.DAO;

import org.example.modelos.Cliente;
import org.example.modelos.Producto;

import java.sql.SQLException;
import java.util.List;

public interface ClienteDAO {
    void insertar (Cliente cliente) throws SQLException;
    void actualizar (Cliente cliente) throws SQLException;
    void eliminar(int Cliente) throws SQLException;
    Cliente obtenerPorId (int Cliente) throws SQLException;
    List<Cliente> obtenerTodos() throws SQLException;
}
