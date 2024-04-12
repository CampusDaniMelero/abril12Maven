package com.softtek.ejercicio1.modelo;

public class DetalleOrden {
    private int orderId;
    private int productId;
    private double unitPrice;
    private int quantity;

    public DetalleOrden(int orderId, int productId, double unitPrice, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getProductId() {
        return productId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }
}