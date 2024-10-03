package org.example.DAO.Impl;

import org.example.BD.Conexion;
import org.example.DAO.ProductoDAO;
import org.example.modelos.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductoImpl implements ProductoDAO {
    @Override
    public void insertar(Producto producto) throws SQLException {
        String sql = "INSERT INTO Productos (nombre, id_categoria, descripcion, precio, cantidad_stock, id_proveedor) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getIdCategoria());
            ps.setString(3, producto.getDescripcion());
            ps.setDouble(4, producto.getPrecio());
            ps.setInt(5, producto.getCantidadStock());
            ps.setInt(6, producto.getIdProveedor());
            ps.executeUpdate();
        }
    }

    @Override
    public void actualizar(Producto producto) throws SQLException {
        String sql = "UPDATE Productos SET nombre=?, id_categoria=?, descripcion=?, precio=?, cantidad_stock=?, id_proveedor=? WHERE id_producto=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getIdCategoria());
            ps.setString(3, producto.getDescripcion());
            ps.setDouble(4, producto.getPrecio());
            ps.setInt(5, producto.getCantidadStock());
            ps.setInt(6, producto.getIdProveedor());
            ps.setInt(7, producto.getIdProducto());
            ps.executeUpdate();
        }
    }

    @Override
    public void eliminar(int idProducto) throws SQLException {
        String sql = "DELETE FROM Productos WHERE id_producto=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idProducto);
            ps.executeUpdate();
        }
    }

    @Override
    public Producto obtenerPorId(int idProducto) throws SQLException {
        String sql = "SELECT * FROM Productos WHERE id_producto=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idProducto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getInt("id_categoria"),
                        rs.getString("descripcion"),
                        rs.getInt("precio"),
                        rs.getInt("cantidad_stock"),
                        rs.getInt("id_proveedor")
                );
            }
        }
        return null;
    }

    @Override
    public List<Producto> obtenerTodos() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM Productos";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                productos.add(new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getInt("id_categoria"),
                        rs.getString("descripcion"),
                        rs.getInt("precio"),
                        rs.getInt("cantidad_stock"),
                        rs.getInt("id_proveedor")
                ));
            }
        }
        return productos;
    }
}
