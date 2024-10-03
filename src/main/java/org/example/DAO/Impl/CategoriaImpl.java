package org.example.DAO.Impl;

import org.example.BD.Conexion;
import org.example.DAO.CategoriaDAO;
import org.example.modelos.Categoria;
import org.example.modelos.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaImpl implements CategoriaDAO {
    @Override
    public void insertar(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO Categorias (descripcion) VALUES (?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, categoria.getDescripcion());
            ps.executeUpdate();
        }
    }

    @Override
    public void actualizar(Categoria categoria) throws SQLException {
        String sql = "UPDATE Categorias SET descripcion=? WHERE id_categoria=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, categoria.getDescripcion());
            ps.setInt(2,categoria.getIdCategoria());
            ps.executeUpdate();
        }
    }

    @Override
    public void eliminar(int idCategoria) throws SQLException {
        String sql = "DELETE FROM Categorias WHERE id_categoria=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCategoria);
            ps.executeUpdate();
        }
    }

    @Override
    public Categoria obtenerPorId(int idCategoria) throws SQLException {
        String sql = "SELECT * FROM Categorias WHERE id_categoria=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCategoria);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Categoria(
                        rs.getInt("id_categoria"),
                        rs.getString("descripcion")
                );
            }
        }
        return null;
    }

    @Override
    public List<Categoria> obtenerTodos() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM Categorias";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                categorias.add(new Categoria(
                        rs.getInt("id_categoria"),
                        rs.getString("descripcion")
                ));
            }
        }
        return categorias;
    }
}
