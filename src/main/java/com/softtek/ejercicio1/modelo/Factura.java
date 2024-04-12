package com.softtek.ejercicio1.modelo;

import java.util.List;

public class Factura {
    private Impuesto impuesto;
    private List<Producto> productos;

    public Factura(Impuesto impuesto, List<Producto> productos) {
        this.impuesto = impuesto;
        this.productos = productos;
    }

    public double calcularTotalFactura() {
        double total = 0;
        // Sumar el precio de todos los productos
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        // Calcular el impuesto sobre el total de la factura
        total += calcularImpuestoTotal();
        return total;
    }

    private double calcularImpuestoTotal() {
        double impuestoTotal = 0;
        // Calcular el impuesto para cada producto y sumarlo
        for (Producto producto : productos) {
            impuestoTotal += impuesto.calcularImpuesto(producto);
        }
        return impuestoTotal;
    }
}