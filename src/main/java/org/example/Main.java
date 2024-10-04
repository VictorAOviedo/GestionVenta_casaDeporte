package org.example;

import org.example.DAO.CategoriaDAO;
import org.example.DAO.ClienteDAO;
import org.example.DAO.DetalleVentaDAO;
import org.example.DAO.Impl.CategoriaImpl;
import org.example.DAO.Impl.ClienteImpl;
import org.example.DAO.Impl.ConsultaMultitablaImpl;
import org.example.DAO.Impl.DetalleVentaImpl;
import org.example.DAO.Impl.MetodoDePagoImpl;
import org.example.DAO.Impl.ProductoImpl;
import org.example.DAO.Impl.ProveedorImpl;
import org.example.DAO.Impl.VentaImpl;
import org.example.DAO.MetodoDePagoDAO;
import org.example.DAO.ProductoDAO;
import org.example.DAO.ProveedorDAO;
import org.example.DAO.VentaDAO;
import org.example.modelos.Categoria;
import org.example.modelos.Cliente;
import org.example.modelos.DetalleVenta;
import org.example.modelos.MetodoDePago;
import org.example.modelos.Producto;
import org.example.modelos.Proveedor;
import org.example.modelos.Venta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ClienteDAO clienteDAO = new ClienteImpl();
        ProductoDAO productoDAO = new ProductoImpl();
        CategoriaDAO categoriaDAO = new CategoriaImpl();
        ProveedorDAO proveedorDAO = new ProveedorImpl();
        MetodoDePagoDAO metodoDePagoDAO = new MetodoDePagoImpl();
        DetalleVentaDAO detalleVentaDAO = new DetalleVentaImpl();
        VentaDAO ventaDAO = new VentaImpl();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú de opciones ---");
            System.out.println("1. Gestionar Productos");
            System.out.println("2. Gestionar Clientes");
            System.out.println("3. Gestionar Proveedores");
            System.out.println("4. Gestionar Categorias");
            System.out.println("5. Gestionar Metodos de pago");
            System.out.println("6. Gestionar Ventas");
            System.out.println("7. Gestionar Detalles de la venta");
            System.out.println("8. Realizar Consultas Multitablas");
            System.out.println("0. Salir");

            try {
                System.out.print("Seleccione una opción: ");
                String opcion = reader.readLine();

                switch (opcion) {
                    case "1":
                        gestionarProductos(reader, productoDAO);
                        break;

                    case "2":
                        gestionarClientes(reader, clienteDAO);
                        break;

                    case "3":
                        gestionarProveedores(reader, proveedorDAO);
                        break;

                    case "4":
                        gestionarCategorias(reader, categoriaDAO);
                        break;

                    case "5":
                        gestionarMetodosDePago(reader, metodoDePagoDAO);
                        break;

                    case "6":
                        gestionarVentas(reader, ventaDAO);
                        break;

                    case "7":
                        gestionarDetallesDeLaVenta(reader, detalleVentaDAO);
                        break;

                    case "8":
                        ejecutarConsultaMultitablas();
                        break;

                    case "0":
                        salir = true;
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (IOException e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }
    }

    private static void gestionarProductos(BufferedReader reader, ProductoDAO productoDAO) {
        boolean salirProducto = false;

        while (!salirProducto) {
            System.out.println("\n--- Gestión de Productos ---");
            System.out.println("1. Insertar Producto");
            System.out.println("2. Actualizar Producto");
            System.out.println("3. Eliminar Producto");
            System.out.println("4. Ver todos los Productos");
            System.out.println("5. Volver al menú principal");

            try {
                System.out.print("Seleccione una opción: ");
                String opcionProducto = reader.readLine();

                switch (opcionProducto) {
                    case "1":
                        Producto nuevoProducto = new Producto();
                        System.out.print("Ingrese el nombre del producto: ");
                        nuevoProducto.setNombre(reader.readLine());
                        System.out.print("Ingrese el ID de la categoría: ");
                        nuevoProducto.setIdCategoria(Integer.parseInt(reader.readLine()));
                        System.out.print("Ingrese la descripción: ");
                        nuevoProducto.setDescripcion(reader.readLine());
                        System.out.print("Ingrese el precio: ");
                        nuevoProducto.setPrecio(Integer.parseInt(reader.readLine()));
                        System.out.print("Ingrese la cantidad en stock: ");
                        nuevoProducto.setCantidadStock(Integer.parseInt(reader.readLine()));
                        System.out.print("Ingrese el ID del proveedor: ");
                        nuevoProducto.setIdProveedor(Integer.parseInt(reader.readLine()));

                        productoDAO.insertar(nuevoProducto);
                        System.out.println("Producto insertado correctamente.");
                        break;

                    case "2":
                        System.out.print("Ingrese el ID del producto a actualizar: ");
                        int idActualizarProducto = Integer.parseInt(reader.readLine());
                        Producto productoActualizar = productoDAO.obtenerPorId(idActualizarProducto);
                        if (productoActualizar != null) {
                            System.out.print("Ingrese el nuevo nombre (actual: " + productoActualizar.getNombre() + "): ");
                            productoActualizar.setNombre(reader.readLine());
                            System.out.print("Ingrese el nuevo ID de la categoría (actual: " + productoActualizar.getIdCategoria() + "): ");
                            productoActualizar.setIdCategoria(Integer.parseInt(reader.readLine()));
                            System.out.print("Ingrese la nueva descripción (actual: " + productoActualizar.getDescripcion() + "): ");
                            productoActualizar.setDescripcion(reader.readLine());
                            System.out.print("Ingrese el nuevo precio (actual: " + productoActualizar.getPrecio() + "): ");
                            productoActualizar.setPrecio(Integer.parseInt(reader.readLine()));
                            System.out.print("Ingrese la nueva cantidad en stock (actual: " + productoActualizar.getCantidadStock() + "): ");
                            productoActualizar.setCantidadStock(Integer.parseInt(reader.readLine()));
                            System.out.print("Ingrese el nuevo ID del proveedor (actual: " + productoActualizar.getIdProveedor() + "): ");
                            productoActualizar.setIdProveedor(Integer.parseInt(reader.readLine()));

                            productoDAO.actualizar(productoActualizar);
                            System.out.println("Producto actualizado correctamente.");
                        } else {
                            System.out.println("Producto no encontrado.");
                        }
                        break;

                    case "3":
                        System.out.print("Ingrese el ID del producto a eliminar: ");
                        int idEliminarProducto = Integer.parseInt(reader.readLine());
                        productoDAO.eliminar(idEliminarProducto);
                        System.out.println("Producto eliminado correctamente.");
                        break;

                    case "4":
                        List<Producto> productos = productoDAO.obtenerTodos();
                        for (Producto producto : productos) {
                            System.out.println(producto);
                        }
                        break;

                    case "5":
                        salirProducto = true;
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (IOException | SQLException e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }
    }

    private static void gestionarClientes(BufferedReader reader, ClienteDAO clienteDAO) {
        boolean salirCliente = false;

        while (!salirCliente) {
            System.out.println("\n--- Gestión de Clientes ---");
            System.out.println("1. Insertar Cliente");
            System.out.println("2. Actualizar Cliente");
            System.out.println("3. Eliminar Cliente");
            System.out.println("4. Ver todos los Clientes");
            System.out.println("5. Volver al menú principal");

            try {
                System.out.print("Seleccione una opción: ");
                String opcionCliente = reader.readLine();

                switch (opcionCliente) {
                    case "1":
                        Cliente nuevoCliente = new Cliente();
                        System.out.print("Ingrese el nombre del cliente: ");
                        nuevoCliente.setNombre(reader.readLine());
                        System.out.print("Ingrese el apellido del cliente: ");
                        nuevoCliente.setApellido(reader.readLine());
                        System.out.print("Ingrese la dirección: ");
                        nuevoCliente.setDireccion(reader.readLine());
                        System.out.print("Ingrese el email: ");
                        nuevoCliente.setCorreoElectronico(reader.readLine());
                        System.out.print("Ingrese el teléfono: ");
                        nuevoCliente.setTelefono(reader.readLine());
                        System.out.print("Ingrese la fecha de registro (yyyy-mm-dd): ");
                        nuevoCliente.setFechaDeRegistro(java.sql.Date.valueOf(reader.readLine()));

                        clienteDAO.insertar(nuevoCliente);
                        System.out.println("Cliente insertado correctamente.");
                        break;

                    case "2":
                        System.out.print("Ingrese el ID del cliente a actualizar: ");
                        int idActualizarCliente = Integer.parseInt(reader.readLine());
                        Cliente clienteActualizar = clienteDAO.obtenerPorId(idActualizarCliente);
                        if (clienteActualizar != null) {
                            System.out.print("Ingrese el nuevo nombre (actual: " + clienteActualizar.getNombre() + "): ");
                            clienteActualizar.setNombre(reader.readLine());
                            System.out.print("Ingrese el nuevo apellido (actual: " + clienteActualizar.getApellido() + "): ");
                            clienteActualizar.setApellido(reader.readLine());
                            System.out.print("Ingrese la nueva dirección (actual: " + clienteActualizar.getDireccion() + "): ");
                            clienteActualizar.setDireccion(reader.readLine());
                            System.out.print("Ingrese el nuevo email (actual: " + clienteActualizar.getCorreoElectronico() + "): ");
                            clienteActualizar.setCorreoElectronico(reader.readLine());
                            System.out.print("Ingrese el nuevo teléfono (actual: " + clienteActualizar.getTelefono() + "): ");
                            clienteActualizar.setTelefono(reader.readLine());
                            System.out.print("Ingrese la nueva fecha de registro (actual: " + clienteActualizar.getFechaDeRegistro() + ") (yyyy-mm-dd): ");
                            clienteActualizar.setFechaDeRegistro(java.sql.Date.valueOf(reader.readLine()));

                            clienteDAO.actualizar(clienteActualizar);
                            System.out.println("Cliente actualizado correctamente.");
                        } else {
                            System.out.println("Cliente no encontrado.");
                        }
                        break;

                    case "3":
                        System.out.print("Ingrese el ID del cliente a eliminar: ");
                        int idEliminarCliente = Integer.parseInt(reader.readLine());
                        clienteDAO.eliminar(idEliminarCliente);
                        System.out.println("Cliente eliminado correctamente.");
                        break;

                    case "4":
                        List<Cliente> clientes = clienteDAO.obtenerTodos();
                        for (Cliente cliente : clientes) {
                            System.out.println(cliente);
                        }
                        break;

                    case "5":
                        salirCliente = true;
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (IOException | SQLException e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }
    }

    private static void gestionarCategorias(BufferedReader reader, CategoriaDAO categoriaDAO) {
        boolean salirCategoria = false;

        while (!salirCategoria) {
            System.out.println("\n--- Gestión de Categoria ---");
            System.out.println("1. Insertar Categoria");
            System.out.println("2. Actualizar Categoria");
            System.out.println("3. Eliminar Categoria");
            System.out.println("4. Ver todas las Categoria");
            System.out.println("5. Volver al menú principal");

            try {
                System.out.print("Seleccione una opción: ");
                String opcionCategoria = reader.readLine();

                switch (opcionCategoria) {
                    case "1":
                        Categoria nuevaCategoria = new Categoria();
                        System.out.print("Ingrese descripcion de la categoria: ");
                        nuevaCategoria.setDescripcion(reader.readLine());

                        categoriaDAO.insertar(nuevaCategoria);
                        System.out.println("Categoria insertada correctamente.");
                        break;

                    case "2":
                        System.out.print("Ingrese el ID de la categoria a actualizar: ");
                        int idActualizarCategoria = Integer.parseInt(reader.readLine());
                        Categoria categoriaActualizar = categoriaDAO.obtenerPorId(idActualizarCategoria);
                        if (categoriaActualizar != null) {
                            System.out.print("Ingrese la nueva descripcion (actual: " + categoriaActualizar.getDescripcion() + "): ");
                            categoriaActualizar.setDescripcion(reader.readLine());

                            categoriaDAO.actualizar(categoriaActualizar);
                            System.out.println("Categoria actualizada correctamente.");
                        } else {
                            System.out.println("Categoria no encontrada.");
                        }
                        break;

                    case "3":
                        System.out.print("Ingrese el ID de la categoria a eliminar: ");
                        int idEliminarCategoria = Integer.parseInt(reader.readLine());
                        categoriaDAO.eliminar(idEliminarCategoria);
                        System.out.println("Categoria eliminada correctamente.");
                        break;

                    case "4":
                        List<Categoria> categorias = categoriaDAO.obtenerTodos();
                        for (Categoria categoria : categorias) {
                            System.out.println(categoria);
                        }
                        break;

                    case "5":
                        salirCategoria = true;
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (IOException | SQLException e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }
    }

    private static void gestionarProveedores(BufferedReader reader, ProveedorDAO proveedorDAO) {
        boolean salirProveedor = false;

        while (!salirProveedor) {
            System.out.println("\n--- Gestión de Proveedor ---");
            System.out.println("1. Insertar Proveedor");
            System.out.println("2. Actualizar Proveedor");
            System.out.println("3. Eliminar Proveedor");
            System.out.println("4. Ver todas los Proveedor");
            System.out.println("5. Volver al menú principal");

            try {
                System.out.print("Seleccione una opción: ");
                String opcionProveedor = reader.readLine();

                switch (opcionProveedor) {
                    case "1":
                        Proveedor nuevoProveedor = new Proveedor();
                        System.out.print("Ingrese Nombre del proveedor: ");
                        nuevoProveedor.setNombreEmpresa(reader.readLine());
                        System.out.print("Ingrese Razon Social del proveedor: ");
                        nuevoProveedor.setRazonSocial(reader.readLine());
                        System.out.print("Ingrese direccion del proveedor: ");
                        nuevoProveedor.setDireccion(reader.readLine());
                        System.out.print("Ingrese correo electronico del proveedor: ");
                        nuevoProveedor.setCorreoElectronico(reader.readLine());
                        System.out.print("Ingrese telefono del proveedor: ");
                        nuevoProveedor.setTelefono(reader.readLine());

                        proveedorDAO.insertar(nuevoProveedor);
                        System.out.println("Proveedor insertado correctamente.");
                        break;

                    case "2":
                        System.out.print("Ingrese el ID del proveedor a actualizar: ");
                        int idActualizarProveedor = Integer.parseInt(reader.readLine());
                        Proveedor proveedorActualizar = proveedorDAO.obtenerPorId(idActualizarProveedor);
                        if (proveedorActualizar != null) {
                            System.out.print("Ingrese el nueva nombre (actual: " + proveedorActualizar.getNombreEmpresa() + "): ");
                            proveedorActualizar.setNombreEmpresa(reader.readLine());
                            System.out.print("Ingrese la nueva razon social (actual: " + proveedorActualizar.getRazonSocial() + "): ");
                            proveedorActualizar.setRazonSocial(reader.readLine());
                            System.out.print("Ingrese la nueva direccion (actual: " + proveedorActualizar.getDireccion() + "): ");
                            proveedorActualizar.setDireccion(reader.readLine());
                            System.out.print("Ingrese el nuevo correo electronico (actual: " + proveedorActualizar.getCorreoElectronico() + "): ");
                            proveedorActualizar.setCorreoElectronico(reader.readLine());
                            System.out.print("Ingrese el nuevo telefono (actual: " + proveedorActualizar.getTelefono() + "): ");
                            proveedorActualizar.setTelefono(reader.readLine());

                            proveedorDAO.actualizar(proveedorActualizar);
                            System.out.println("Proveedor actualizado correctamente.");
                        } else {
                            System.out.println("Proveedor no encontrada.");
                        }
                        break;

                    case "3":
                        System.out.print("Ingrese el ID del proveedor a eliminar: ");
                        int idEliminarProveedor = Integer.parseInt(reader.readLine());
                        proveedorDAO.eliminar(idEliminarProveedor);
                        System.out.println("Proveedor eliminado correctamente.");
                        break;

                    case "4":
                        List<Proveedor> proveedores = proveedorDAO.obtenerTodos();
                        for (Proveedor proveedor : proveedores) {
                            System.out.println(proveedor);
                        }
                        break;

                    case "5":
                        salirProveedor = true;
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (IOException | SQLException e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }
    }

    private static void gestionarMetodosDePago(BufferedReader reader, MetodoDePagoDAO metodoDePagoDAO) {
        boolean salirMetodosDePagos = false;

        while (!salirMetodosDePagos) {
            System.out.println("\n--- Gestión de Metodos de Pagos ---");
            System.out.println("1. Insertar Metodo de pago");
            System.out.println("2. Actualizar Metodo de pago");
            System.out.println("3. Eliminar Metodo de pago");
            System.out.println("4. Ver todos los Metodo de pago");
            System.out.println("5. Volver al menú principal");

            try {
                System.out.print("Seleccione una opción: ");
                String opcionMetodoDePago = reader.readLine();

                switch (opcionMetodoDePago) {
                    case "1":
                        MetodoDePago nuevoMetodoDePago = new MetodoDePago();
                        System.out.print("Ingrese descripcion del metodo de pago: ");
                        nuevoMetodoDePago.setDescripcion(reader.readLine());

                        metodoDePagoDAO.insertar(nuevoMetodoDePago);
                        System.out.println("Metodo de pago insertado correctamente.");
                        break;

                    case "2":
                        System.out.print("Ingrese el ID del metodo de pago a actualizar: ");
                        int idActualizarMetodoDePago = Integer.parseInt(reader.readLine());
                        MetodoDePago metodoDePagoActualizar = metodoDePagoDAO.obtenerPorId(idActualizarMetodoDePago);
                        if (metodoDePagoActualizar != null) {
                            System.out.print("Ingrese la nueva descripcion (actual: " + metodoDePagoActualizar.getDescripcion() + "): ");
                            metodoDePagoActualizar.setDescripcion(reader.readLine());

                            metodoDePagoDAO.actualizar(metodoDePagoActualizar);
                            System.out.println("Metodo de pago actualizado correctamente.");
                        } else {
                            System.out.println("Metodo de pago no encontrada.");
                        }
                        break;

                    case "3":
                        System.out.print("Ingrese el ID del Metodo de pago a eliminar: ");
                        int idEliminarMetodoDePago = Integer.parseInt(reader.readLine());
                        metodoDePagoDAO.eliminar(idEliminarMetodoDePago);
                        System.out.println("Metodo de pago eliminado correctamente.");
                        break;

                    case "4":
                        List<MetodoDePago> metodosDePagos = metodoDePagoDAO.obtenerTodos();
                        for (MetodoDePago metodoDePago : metodosDePagos) {
                            System.out.println(metodoDePago);
                        }
                        break;

                    case "5":
                        salirMetodosDePagos = true;
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (IOException | SQLException e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }
    }

    private static void gestionarVentas(BufferedReader reader, VentaDAO ventaDAO) {
        boolean salirVenta = false;

        while (!salirVenta) {
            System.out.println("\n--- Gestión de Ventas ---");
            System.out.println("1. Insertar Venta");
            System.out.println("2. Actualizar Venta");
            System.out.println("3. Eliminar Venta");
            System.out.println("4. Ver todas las Venta");
            System.out.println("5. Volver al menú principal");

            try {
                System.out.print("Seleccione una opción: ");
                String opcionVenta = reader.readLine();

                switch (opcionVenta) {
                    case "1":
                        Venta nuevaVenta = new Venta();
                        System.out.print("Ingrese el ID_del_Cliente de la VENTA: ");
                        nuevaVenta.setIdCliente(Integer.parseInt(reader.readLine()));
                        System.out.print("Ingrese la fecha de la venta (aaaa-mm-dd): ");
                        nuevaVenta.setFechaVenta(LocalDate.parse(reader.readLine()));
                        System.out.print("Ingrese el total de la venta: ");
                        nuevaVenta.setTotalVenta(Integer.parseInt(reader.readLine()));
                        System.out.print("Ingrese el ID de metodo de pago, de la venta: ");
                        nuevaVenta.setIdMetodoDP(Integer.parseInt(reader.readLine()));


                        ventaDAO.insertar(nuevaVenta);
                        System.out.println("Venta insertada correctamente.");
                        break;

                    case "2":
                        System.out.print("Ingrese el ID de al venta a actualizar: ");
                        int idActualizarVenta = Integer.parseInt(reader.readLine());
                        Venta ventaActualizar = ventaDAO.obtenerPorId(idActualizarVenta);
                        if (ventaActualizar != null) {
                            System.out.print("Ingrese el nuevo id_cliente (actual: " + ventaActualizar.getIdCliente() + "): ");
                            ventaActualizar.setIdCliente(Integer.parseInt(reader.readLine()));
                            System.out.print("Ingrese la nueva fecha de la venta (actual: " + ventaActualizar.getFechaVenta() + "): ");
                            ventaActualizar.setFechaVenta(LocalDate.parse(reader.readLine()));
                            System.out.print("Ingrese el nuevo total de la venta (actual: " + ventaActualizar.getTotalVenta() + "): ");
                            ventaActualizar.setTotalVenta(Integer.parseInt(reader.readLine()));
                            System.out.print("Ingrese el nuevo ID_metodoDePago (actual: " + ventaActualizar.getIdMetodoDP() + "): ");
                            ventaActualizar.setIdMetodoDP(Integer.parseInt(reader.readLine()));


                            ventaDAO.actualizar(ventaActualizar);
                            System.out.println("Venta actualizada correctamente.");
                        } else {
                            System.out.println("Venta no encontrada.");
                        }
                        break;

                    case "3":
                        System.out.print("Ingrese el ID de la venta a eliminar: ");
                        int idEliminarVenta = Integer.parseInt(reader.readLine());
                        ventaDAO.eliminar(idEliminarVenta);
                        System.out.println("Venta eliminada correctamente.");
                        break;

                    case "4":
                        List<Venta> ventas = ventaDAO.obtenerTodos();
                        for (Venta venta : ventas) {
                            System.out.println(venta);
                        }
                        break;

                    case "5":
                        salirVenta = true;
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (IOException | SQLException e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }
    }

    private static void gestionarDetallesDeLaVenta(BufferedReader reader, DetalleVentaDAO detalleVentaDAO) {
        boolean salirDetalleVenta = false;

        while (!salirDetalleVenta) {
            System.out.println("\n--- Gestión de Detalle de Venta ---");
            System.out.println("1. Insertar Detalle de Venta");
            System.out.println("2. Actualizar Detalle de Venta");
            System.out.println("3. Eliminar Detalle de Venta");
            System.out.println("4. Ver todos los Detalles de Ventas");
            System.out.println("5. Volver al menú principal");

            try {
                System.out.print("Seleccione una opción: ");
                String opcionDetalleDV = reader.readLine();

                switch (opcionDetalleDV) {
                    case "1":
                        DetalleVenta nuevoDetalleVenta = new DetalleVenta();
                        System.out.print("Ingrese el ID_venta (Detalle venta): ");
                        nuevoDetalleVenta.setIdVenta(Integer.parseInt(reader.readLine()));
                        System.out.print("Ingrese el ID_producto (Detalle venta): ");
                        nuevoDetalleVenta.setIdProducto(Integer.parseInt(reader.readLine()));
                        System.out.print("Ingrese la cantidad vendida: ");
                        nuevoDetalleVenta.setCantidadV(Integer.parseInt(reader.readLine()));
                        System.out.print("Ingrese el precio unitario: ");
                        nuevoDetalleVenta.setPrecioUnitario(Integer.parseInt(reader.readLine()));


                        detalleVentaDAO.insertar(nuevoDetalleVenta);
                        System.out.println("Detalle de Venta, insertado correctamente.");
                        break;

                    case "2":
                        System.out.print("Ingrese el ID del Detalle de venta a actualizar: ");
                        int idActualizarDetalleVenta = Integer.parseInt(reader.readLine());
                        DetalleVenta detalleVentaActualizar = detalleVentaDAO.obtenerPorId(idActualizarDetalleVenta);
                        if (detalleVentaActualizar != null) {
                            System.out.print("Ingrese el nuevo ID_venta (actual: " + detalleVentaActualizar.getIdVenta() + "): ");
                            detalleVentaActualizar.setIdVenta(Integer.parseInt(reader.readLine()));
                            System.out.print("Ingrese el nuevo ID_producto (actual: " + detalleVentaActualizar.getIdProducto() + "): ");
                            detalleVentaActualizar.setIdProducto(Integer.parseInt(reader.readLine()));
                            System.out.print("Ingrese la nueva cantidad vendida (actual: " + detalleVentaActualizar.getCantidadV() + "): ");
                            detalleVentaActualizar.setCantidadV(Integer.parseInt(reader.readLine()));
                            System.out.print("Ingrese el nuevo precio unitario (actual: " + detalleVentaActualizar.getPrecioUnitario() + "): ");
                            detalleVentaActualizar.setPrecioUnitario(Integer.parseInt(reader.readLine()));

                            detalleVentaDAO.actualizar(detalleVentaActualizar);
                            System.out.println("Detalle de venta actualizado correctamente.");
                        } else {
                            System.out.println("Detalle de venta no encontrado.");
                        }
                        break;

                    case "3":
                        System.out.print("Ingrese el ID del detalle de venta a eliminar: ");
                        int idEliminarDetalleDeVenta = Integer.parseInt(reader.readLine());
                        detalleVentaDAO.eliminar(idEliminarDetalleDeVenta);
                        System.out.println("Detalle de venta eliminado correctamente.");
                        break;

                    case "4":
                        List<DetalleVenta> detalleVentas = detalleVentaDAO.obtenerTodos();
                        for (DetalleVenta detalleVenta : detalleVentas) {
                            System.out.println(detalleVenta);
                        }
                        break;

                    case "5":
                        salirDetalleVenta = true;
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (IOException | SQLException e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }
    }

    public static void ejecutarConsultaMultitablas() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ConsultaMultitablaImpl consulta = new ConsultaMultitablaImpl(); // Crear la instancia del DAO

        System.out.println("Ingrese la primera tabla para la consulta");
        System.out.println("1. Categorias");
        System.out.println("2. Clientes");
        System.out.println("3. Detalles de la venta");
        System.out.println("4. Metodos de pago");
        System.out.println("5. Productos");
        System.out.println("6. Proveedores");
        System.out.println("7. Ventas");
        String tabla1 = reader.readLine();

        System.out.println("Ingrese la segunda tabla para la consulta (ej: categorias):");
        System.out.println("1. Categorias");
        System.out.println("2. Clientes");
        System.out.println("3. Detalles de la venta");
        System.out.println("4. Metodos de pago");
        System.out.println("5. Productos");
        System.out.println("6. Proveedores");
        System.out.println("7. Ventas");
        String tabla2 = reader.readLine();

        try {
            // Llamar al método de consulta multitablas
            List<String> resultado = consulta.generarConsultaMultitablas(tabla1, tabla2);

            // Mostrar el resultado
            for (String fila : resultado) {
                System.out.println(fila);
            }

        } catch (SQLException e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }

}