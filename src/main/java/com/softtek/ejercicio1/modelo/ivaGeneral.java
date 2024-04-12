package com.softtek.ejercicio1.modelo;

public class ivaGeneral implements Impuesto {
    private static final double TASA_IVA_GENERAL = 0.21; // Tasa de IVA general del 21%

    @Override
    public double calcularImpuesto(Producto producto) {
        // Calcula el impuesto para un producto utilizando la tasa general de IVA
        return producto.getPrecio() * TASA_IVA_GENERAL;
    }
}