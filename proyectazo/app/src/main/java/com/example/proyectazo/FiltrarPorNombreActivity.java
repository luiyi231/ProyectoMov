package com.example.proyectazo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class FiltrarPorNombreActivity extends AppCompatActivity {

    private GestorProductos gestorProductos = GestorProductosSingleton.getInstance();
    private EditText edtNombre;
    private Button btnFiltrarPorNombre;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtrar_nombre);

        edtNombre = findViewById(R.id.edtNombre);
        btnFiltrarPorNombre = findViewById(R.id.btnFiltrarPorNombre);
        txtResultado = findViewById(R.id.txtResultado);

        btnFiltrarPorNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = edtNombre.getText().toString().trim();
                if (!nombre.isEmpty()) {
                    List<Producto> productosFiltrados = gestorProductos.filtrarPorNombre(nombre);
                    if (productosFiltrados.isEmpty()) {
                        txtResultado.setText("No se encontraron productos con ese nombre.");
                    } else {
                        StringBuilder resultado = new StringBuilder();
                        for (Producto producto : productosFiltrados) {
                            resultado.append(producto.getNombre()).append(" - $").append(producto.getPrecio()).append("\n");
                        }
                        txtResultado.setText(resultado.toString());
                    }
                    txtResultado.setVisibility(View.VISIBLE);
                } else {
                    txtResultado.setText("Por favor, ingresa un nombre para filtrar.");
                    txtResultado.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
