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
            tabla1 = obtenerNombreTabla(tabla1);
            tabla2 = obtenerNombreTabla(tabla2);

            System.out.println("La combinacion de Tabla: '" + tabla1 + "' y Tabla: '" + tabla2 + "' no es valida.");

        }

        return resultado;
    }

    // Método para construir la consulta SQL en función de las tablas elegidas
    private String construirConsulta(String tabla1, String tabla2) {
        String query = null;

        if (tabla1.equals("5") && tabla2.equals("1") || tabla1.equals("1") && tabla2.equals("5")) {
            System.out.println("\n----| Consulta de tablas: Productos - Categorias |----\n");
            query = "SELECT p.id_producto, p.nombre, p.precio, p.descripcion, p.cantidad_stock, p.id_proveedor, c.descripcion " +
                    "FROM productos p " +
                    "JOIN categorias c ON p.id_categoria = c.id_categoria";
        } else if (tabla1.equals("5") && tabla2.equals("6") || tabla1.equals("6") && tabla2.equals("5")) {
            System.out.println("\n----| Consulta de tablas: Productos - Clientes |----\n");
            query = "SELECT p.id_producto, p.nombre, p.precio, pr.nombre_empresa " +
                    "FROM productos p " +
                    "JOIN proveedores pr ON p.id_proveedor = pr.id_proveedor";
        } else if (tabla1.equals("7") && tabla2.equals("2") || tabla1.equals("2") && tabla2.equals("7")) {
            System.out.println("\n----| Consulta de tablas: Ventas - Clientes |----\n");
            query = "SELECT v.id_venta, v.fecha_venta, v.total, c.nombre, c.apellido " +
                    "FROM ventas v " +
                    "JOIN clientes c ON v.id_cliente = c.id_cliente";
        } else if (tabla1.equals("3") && tabla2.equals("7") || tabla1.equals("7") && tabla2.equals("3")) {
            System.out.println("\n----| Consulta de tablas: Detalles de venta - Ventas |----\n");
            query = "SELECT d.cantidad_vendida, d.id_producto, d.id_venta, v.fecha_venta, v.id_metodo_pago, v.total_de_la_venta " +
                    "FROM detalles_de_venta d " +
                    "JOIN ventas v ON d.id_venta = v.id_venta";
        } else if (tabla1.equals("3") && tabla2.equals("5") || tabla1.equals("5") && tabla2.equals("3")) {
            System.out.println("\n----| Consulta de tablas: Detalles de venta - Productos |----\n");
            query = "SELECT p.id_producto, p.nombre, p.precio, p.cantidad_stock, d.cantidad_vendida, d.id_producto, d.precio_unitario " +
                    "FROM detalles_de_venta d " +
                    "JOIN productos p ON d.id_producto = p.id_producto";
        } else if (tabla1.equals("7") && tabla2.equals("4") || tabla1.equals("4") && tabla2.equals("7")) {
            System.out.println("\n----| Consulta de tablas: Metodos de pagos - Ventas |----\n");
            query = "SELECT v.id_cliente, v.fecha_venta, m.descripcion, m.id_metodo_pago " +
                    "FROM ventas v " +
                    "JOIN metodos_de_pago m ON v.id_metodo_pago = m.id_metodo_pago";
        }

        return query;
    }

    // Método auxiliar para obtener el nombre de la tabla basado en el código
    private String obtenerNombreTabla(String codigo) {
        switch (codigo) {
            case "1":
                return "Categorias";
            case "2":
                return "Clientes";
            case "3":
                return "Detalles de la venta";
            case "4":
                return "Metodos de pago";
            case "5":
                return "Productos";
            case "6":
                return "Proveedores";
            case "7":
                return "Ventas";
            default:
                return "Código inválido";
        }
    }
}