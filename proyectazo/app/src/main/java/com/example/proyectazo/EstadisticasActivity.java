package com.example.proyectazo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Toast;


import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EstadisticasActivity extends AppCompatActivity {
    private GestorProductos gestorProductos = GestorProductosSingleton.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        // Asegurarse de que el gestor de productos no sea null
        if (gestorProductos == null) {
            // Si gestorProductos es null, muestra un mensaje de error y termina la actividad
            Toast.makeText(this, "Error al cargar los datos", Toast.LENGTH_SHORT).show();
            finish();  // Termina la actividad si ocurre un error
            return;
        }

        // Obtener las estadísticas
        String estadisticas = obtenerEstadisticas();

        // Mostrar las estadísticas en un TextView
        TextView txtEstadisticas = findViewById(R.id.txtEstadisticas);
        txtEstadisticas.setText(estadisticas);
    }

    private String obtenerEstadisticas() {
        Producto productoMasCaro = gestorProductos.obtenerProductoMasCaro();
        Producto productoMasBarato = gestorProductos.obtenerProductoMasBarato();
        double promedioPrecio = gestorProductos.obtenerPromedioPrecio();

        // Asegúrate de que los productos no sean nulos antes de acceder a sus atributos
        if (productoMasCaro == null || productoMasBarato == null) {
            return "No se pudieron obtener las estadísticas. No hay productos.";
        }

        return "Producto más caro: " + productoMasCaro.getNombre() + " - $" + productoMasCaro.getPrecio() + "\n" +
                "Producto más barato: " + productoMasBarato.getNombre() + " - $" + productoMasBarato.getPrecio() + "\n" +
                "Promedio de precio: $" + promedioPrecio;
    }

}

