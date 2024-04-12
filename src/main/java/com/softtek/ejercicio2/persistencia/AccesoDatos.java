package com.softtek.ejercicio2.persistencia;

import com.softtek.ejercicio1.modelo.DetalleOrden;
import com.softtek.ejercicio1.modelo.SumaCantidades;
import com.softtek.ejercicio2.modelo.Conexion;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class AccesoDatos {

    private Connection miConexion;

    public AccesoDatos() {
        Conexion conexion = new Conexion();
        try {
            conexion.abrirConexion();
            miConexion = conexion.getMiConexion();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<DetalleOrden> consultarDetallesOrdenes() throws SQLException {
        List<DetalleOrden> detalles = new ArrayList<>();
        String query = "SELECT * FROM order_details";
        try (Statement stmt = miConexion.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                detalles.add(new DetalleOrden(rs.getInt("order_id"), rs.getInt("product_id"),
                        rs.getDouble("unit_price"), rs.getInt("quantity")));
            }
        }
        return detalles;
    }

    public List<DetalleOrden> obtenerDetallesMayor30() throws SQLException {
        return consultarDetallesOrdenes().stream()
                .filter(detalle -> detalle.getUnitPrice() > 30)
                .collect(Collectors.toList());
    }

    public List<DetalleOrden> ordenarPorPrecioDescendente() throws SQLException {
        return consultarDetallesOrdenes().stream()
                .sorted((detalle1, detalle2) -> Double.compare(detalle2.getUnitPrice(), detalle1.getUnitPrice()))
                .collect(Collectors.toList());
    }

    public DetalleOrden obtenerDetallePrecioMinimo() throws SQLException {
        return consultarDetallesOrdenes().stream()
                .min(Comparator.comparingDouble(DetalleOrden::getUnitPrice))
                .orElse(null);
    }

    public IntSummaryStatistics obtenerEstadisticasCantidad() throws SQLException {
        return consultarDetallesOrdenes().stream()
                .mapToInt(DetalleOrden::getQuantity)
                .summaryStatistics();
    }

    public List<SumaCantidades> obtenerSumaCantidadesPorProducto() throws SQLException {
        return consultarDetallesOrdenes().stream()
                .collect(Collectors.groupingBy(DetalleOrden::getProductId,
                        Collectors.summingInt(DetalleOrden::getQuantity)))
                .entrySet().stream()
                .map(entry -> new SumaCantidades(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
