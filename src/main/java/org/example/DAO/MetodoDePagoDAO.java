package org.example.DAO;

import org.example.modelos.MetodoDePago;

import java.sql.SQLException;
import java.util.List;

public interface MetodoDePagoDAO {
    void insertar (MetodoDePago metodoDePago) throws SQLException;
    void actualizar (MetodoDePago metodoDePago)throws SQLException;
    void eliminar (int MetodoDePago) throws SQLException;
    MetodoDePago obtenerPorId (int MetodoDePago) throws SQLException;
    List<MetodoDePago> obtenerTodos() throws SQLException;
}
