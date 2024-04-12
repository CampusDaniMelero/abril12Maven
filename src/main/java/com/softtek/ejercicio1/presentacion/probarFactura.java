package com.softtek.ejercicio1.presentacion;


import com.softtek.ejercicio1.modelo.Factura;
import com.softtek.ejercicio1.modelo.Impuesto;
import com.softtek.ejercicio1.modelo.IvaSuperReducido;
import com.softtek.ejercicio1.modelo.Producto;
import com.softtek.ejercicio1.modelo.ivaGeneral;

import java.util.ArrayList;
import java.util.List;

public class probarFactura {
    public static void main(String[] args) {
        // Creamos los productos
        Producto producto1 = new Producto("Camisa", 25.0);
        Producto producto2 = new Producto("Pantalón", 35.0);

        System.out.println("Productos: " + producto1.getNombre() + " con precio : " + producto1.getPrecio() +    "  , Producto segundo " + producto2.getNombre() +  " con precio : " + producto2.getPrecio());
        // Introducimos los productos en un ArrayList
        List<Producto> productos = new ArrayList<>();
        productos.add(producto1);
        productos.add(producto2);

        // Creamos una factura con IVA general
        Impuesto ivaGeneral = new ivaGeneral();
        Factura facturaConIvaGeneral = new Factura(ivaGeneral, productos);
        double totalConIvaGeneral = facturaConIvaGeneral.calcularTotalFactura();
        System.out.println("Total con IVA general: " + totalConIvaGeneral);

        // Creamos una factura con IVA super reducido
        Impuesto ivaSuperReducido = new IvaSuperReducido();
        Factura facturaConIvaSuperReducido = new Factura(ivaSuperReducido, productos);
        double totalConIvaSuperReducido = facturaConIvaSuperReducido.calcularTotalFactura();
        System.out.println("Total con IVA super reducido: " + totalConIvaSuperReducido);
    }
}