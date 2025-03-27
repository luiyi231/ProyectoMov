package com.example.proyectazo;


import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class GestorProductos {
    private List<Producto> productos;

    public GestorProductos() {
        productos = new ArrayList<>();
    }

    // Método para agregar un producto
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    // Método para obtener todos los productos
    public List<Producto> obtenerProductos() {
        return productos;
    }

    // Método para obtener el producto más caro
    public Producto obtenerProductoMasCaro() {
        Producto productoMasCaro = null;
        for (Producto producto : productos) {
            if (productoMasCaro == null || producto.getPrecio() > productoMasCaro.getPrecio()) {
                productoMasCaro = producto;
            }
        }
        return productoMasCaro;
    }

    // Método para obtener el producto más barato
    public Producto obtenerProductoMasBarato() {
        Producto productoMasBarato = null;
        for (Producto producto : productos) {
            if (productoMasBarato == null || producto.getPrecio() < productoMasBarato.getPrecio()) {
                productoMasBarato = producto;
            }
        }
        return productoMasBarato;
    }

    // Método para obtener el precio promedio
    public double obtenerPromedioPrecio() {
        if (productos.isEmpty()) {
            return 0.0;
        }
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total / productos.size();
    }
}

