package com.example.proyectazo;

import java.util.List;

public interface Gestionable {
    void agregarProducto(Producto producto);
    List<Producto> obtenerProductos();
}