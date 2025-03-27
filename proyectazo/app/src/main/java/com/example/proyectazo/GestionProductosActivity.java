package com.example.proyectazo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;

public class GestionProductosActivity extends AppCompatActivity {
    private GestorProductos gestorProductos = GestorProductosSingleton.getInstance();

    private RecyclerView recyclerView;
    private ProductoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_productos);

        EditText edtNombre = findViewById(R.id.edtNombre);
        EditText edtPrecio = findViewById(R.id.edtPrecio);
        EditText edtCategoria = findViewById(R.id.edtCategoria);
        Button btnAgregar = findViewById(R.id.btnAgregar);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProductoAdapter(gestorProductos.obtenerProductos());
        recyclerView.setAdapter(adapter);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = edtNombre.getText().toString();
                double precio = Double.parseDouble(edtPrecio.getText().toString());
                String categoria = edtCategoria.getText().toString();

                gestorProductos.agregarProducto(new Producto(nombre, precio, categoria));
                adapter.notifyDataSetChanged();
                Toast.makeText(GestionProductosActivity.this, "Producto agregado", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
