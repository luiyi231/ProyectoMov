package com.example.proyectazo;
import java.util.ArrayList;
import java.util.List;

public class GestorProductos {
    private List<Producto> productos;

    public GestorProductos() {
        productos = new ArrayList<>();

        productos.add(new Producto("Dell", 1200.50, "Laptop"));
        productos.add(new Producto("Huawei p30", 300.75, "Smartphone"));
        productos.add(new Producto("Ipad", 450.30, "Tablet"));
        productos.add(new Producto("HP Omen", 1500.75, "Laptop"));
        productos.add(new Producto("Google Pixel 6", 699.90, "Smartphone"));
        productos.add(new Producto("Samsung Galaxy Tab S7", 650.99, "Tablet"));
        productos.add(new Producto("Lenovo ThinkPad", 1300.40, "Laptop"));
        productos.add(new Producto("OnePlus 9", 799.50, "Smartphone"));
        productos.add(new Producto("Amazon Fire HD 10", 150.80, "Tablet"));
        productos.add(new Producto("Asus ROG", 2200.99, "Laptop"));
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> obtenerProductos() {
        return productos;
    }

    public Producto obtenerProductoMasCaro() {
        Producto productoMasCaro = null;
        for (Producto producto : productos) {
            if (productoMasCaro == null || producto.getPrecio() > productoMasCaro.getPrecio()) {
                productoMasCaro = producto;
            }
        }
        return productoMasCaro;
    }

    public Producto obtenerProductoMasBarato() {
        Producto productoMasBarato = null;
        for (Producto producto : productos) {
            if (productoMasBarato == null || producto.getPrecio() < productoMasBarato.getPrecio()) {
                productoMasBarato = producto;
            }
        }
        return productoMasBarato;
    }

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
    public int contarProductosPorCategoria(String categoria) {
        int count = 0;
        for (Producto producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                count++;
            }
        }
        return count;
    }
    public List<Producto> filtrarPorNombre(String nombre) {
        List<Producto> productosFiltrados = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                productosFiltrados.add(producto);
            }
        }
        return productosFiltrados;
    }

}
