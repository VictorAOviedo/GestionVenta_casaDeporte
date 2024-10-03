package org.example.DAO.Impl;

import org.example.BD.Conexion;
import org.example.DAO.ConsultaMultitablaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultaMultitablaImpl implements ConsultaMultitablaDAO {

    @Override
    public List<String> generarConsultaMultitablas(String tabla1, String tabla2) throws SQLException {
        List<String> resultado = new ArrayList<>();
        String query = construirConsulta(tabla1, tabla2);

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ResultSet rs = ps.executeQuery();
            int columnas = rs.getMetaData().getColumnCount();

            // Definir un ancho fijo para las columnas
            int anchoColumna = 18;

            // Extraer los nombres de las columnas y formatear
            StringBuilder encabezado = new StringBuilder();
            for (int i = 1; i <= columnas; i++) {
                encabezado.append(String.format("%-" + anchoColumna + "s", rs.getMetaData().getColumnName(i))).append("|");
            }
            resultado.add(encabezado.toString());

            // Extraer los datos y formatearlos encolumnados
            while (rs.next()) {
                StringBuilder fila = new StringBuilder();
                for (int i = 1; i <= columnas; i++) {
                    String valor = rs.getString(i);
                    if (valor == null) valor = "NULL"; // Para evitar valores nulos
                    fila.append(String.format("%-" + anchoColumna + "s", valor)).append("|");
                }
                resultado.add(fila.toString());
            }

        } catch (SQLException e) {
            throw new SQLException("Error al ejecutar consulta: " + e.getMessage());
        }

        return resultado;
    }

    // Método para construir la consulta SQL en función de las tablas elegidas
    private String construirConsulta(String tabla1, String tabla2) {
        String query = null;

        if (tabla1.equals("productos") && tabla2.equals("categorias")) {
            query = "SELECT p.id_producto, p.nombre, p.precio, p.descripcion, p.cantidad_stock, p.id_proveedor, c.descripcion " +
                    "FROM productos p " +
                    "JOIN categorias c ON p.id_categoria = c.id_categoria";
        } else if (tabla1.equals("productos") && tabla2.equals("proveedores")) {
            query = "SELECT p.id_producto, p.nombre, p.precio, pr.nombre_empresa " +
                    "FROM productos p " +
                    "JOIN proveedores pr ON p.id_proveedor = pr.id_proveedor";
        } else if (tabla1.equals("ventas") && tabla2.equals("clientes")) {
            query = "SELECT v.id_venta, v.fecha_venta, v.total, c.nombre, c.apellido " +
                    "FROM ventas v " +
                    "JOIN clientes c ON v.id_cliente = c.id_cliente";
        } else if (tabla1.equals("detalles de venta") && tabla2.equals("ventas")) {
            query = "SELECT d.cantidad_vendida, d.id_producto, d.id_venta, v.fecha_venta, v.id_metodo_pago, v.total_de_la_venta " +
                    "FROM detalles_de_venta d " +
                    "JOIN ventas v ON d.id_venta = v.id_venta";
        } else if (tabla1.equals("detalles de venta") && tabla2.equals("productos")) {
            query = "SELECT p.id_producto, p.nombre, p.precio, p.cantidad_stock, d.cantidad_vendida, d.id_producto, d.precio_unitario " +
                    "FROM detalles_de_venta d " +
                    "JOIN productos p ON d.id_producto = p.id_producto";
        } else if (tabla1.equals("ventas") && tabla2.equals("metodos de pago")) {
            query = "SELECT v.id_cliente, v.fecha_venta, m.descripcion, m.id_metodo_pago " +
                    "FROM ventas v " +
                    "JOIN metodos_de_pago m ON v.id_metodo_pago = m.id_metodo_pago";
        }

        return query;
    }
}