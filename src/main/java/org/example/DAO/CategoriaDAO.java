package org.example.DAO;

import org.example.modelos.Categoria;


import java.sql.SQLException;
import java.util.List;

public interface CategoriaDAO {
    void insertar (Categoria categoria) throws SQLException;
    void actualizar (Categoria categoria)throws SQLException;
    void eliminar (int Categoria) throws SQLException;
    Categoria obtenerPorId (int Categoria) throws SQLException;
    List<Categoria> obtenerTodos() throws SQLException;
}
