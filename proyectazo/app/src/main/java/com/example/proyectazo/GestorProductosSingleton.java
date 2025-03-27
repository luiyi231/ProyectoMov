package com.example.proyectazo;

public class GestorProductosSingleton {
    private static GestorProductos instance;

    private GestorProductosSingleton() {
        // Constructor privado para evitar instancias externas
    }

    public static GestorProductos getInstance() {
        if (instance == null) {
            instance = new GestorProductos();
        }
        return instance;
    }
}
