package com.softtek.ejercicio1.modelo;

public class IvaSuperReducido implements Impuesto {
    private static final double TASA_IVA_SUPER_REDUCIDO = 0.04; // Tasa de IVA super reducido del 4%

    @Override
    public double calcularImpuesto(Producto producto) {
        // Calcula el impuesto para un producto utilizando la tasa super reducida de IVA
        return producto.getPrecio() * TASA_IVA_SUPER_REDUCIDO;
    }
}