package com.softtek.ejercicio2.presentacion;

import com.softtek.ejercicio1.modelo.DetalleOrden;
import com.softtek.ejercicio1.modelo.SumaCantidades;

import com.softtek.ejercicio2.persistencia.AccesoDatos;

import java.sql.SQLException;
import java.util.List;

public class MainBBDD {

    public static void main(String[] args) {
        AccesoDatos accesoDatos = new AccesoDatos();
        try {
            List<DetalleOrden> detalles = accesoDatos.obtenerDetallesMayor30();
            // Mostrar detalles cuyo precio unitario sea mayor que 30
            System.out.println("Detalles con precio unitario mayor que 30:");
            System.out.println("Order ID | Product ID | Unit Price | Quantity");
            for (DetalleOrden detalle : detalles) {
                System.out.println(detalle.getOrderId() + " | " + detalle.getProductId() + " | " +
                        detalle.getUnitPrice() + " | " + detalle.getQuantity());
            }

            DetalleOrden detalleMinimo = accesoDatos.obtenerDetallePrecioMinimo();
            // Mostrar detalle con precio mínimo
            if (detalleMinimo != null) {
                System.out.println("\nDetalle con precio mínimo:");
                System.out.println("Order ID | Product ID | Unit Price | Quantity");
                System.out.println(detalleMinimo.getOrderId() + " | " +
                        detalleMinimo.getProductId() + " | " + detalleMinimo.getUnitPrice() + " | " +
                        detalleMinimo.getQuantity());
            }

            List<SumaCantidades> sumaCantidadesPorProducto = accesoDatos.obtenerSumaCantidadesPorProducto();
            // Mostrar productos y la suma de sus cantidades
            System.out.println("\nSuma de cantidades por producto:");
            System.out.println("Product ID | Suma Cantidades");
            for (SumaCantidades productoSuma : sumaCantidadesPorProducto) {
                System.out.println(productoSuma.getProductId() + " | " +
                        productoSuma.getSumaCantidad());
            }

            // Otros ejercicios

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}