package com.softtek.ejercicio1.modelo;


public class SumaCantidades {
    private int productId;
    private int sumaCantidad;

    public SumaCantidades(int productId, int sumaCantidad) {
        this.productId = productId;
        this.sumaCantidad = sumaCantidad;
    }

    public int getProductId() {
        return productId;
    }

    public int getSumaCantidad() {
        return sumaCantidad;
    }
}