package com.example.proyectazo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FiltrarProductosActivity extends AppCompatActivity {
    private GestorProductos gestorProductos = GestorProductosSingleton.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtrar_productos);

        // Referencias a los componentes
        Spinner spinnerCategoria = findViewById(R.id.spinnerCategoria);
        Button btnFiltrar = findViewById(R.id.btnFiltrar);
        TextView txtResultado = findViewById(R.id.txtResultado); // TextView para mostrar el resultado

        btnFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String categoria = spinnerCategoria.getSelectedItem().toString();

                // Contar productos por categoría
                int count = gestorProductos.contarProductosPorCategoria(categoria);

                // Mostrar el conteo en el TextView
                txtResultado.setText(categoria + ": " + count + " producto(s)");
            }
        });
    }
}

