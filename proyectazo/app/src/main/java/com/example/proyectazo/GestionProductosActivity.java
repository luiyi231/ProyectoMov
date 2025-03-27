package com.example.proyectazo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

        // Spinner para seleccionar categoría
        Spinner spinnerCategoria = findViewById(R.id.spinnerCategoria);
        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(
                this, R.array.categorias_array, android.R.layout.simple_spinner_item);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategoria.setAdapter(adapterSpinner);

        Button btnAgregar = findViewById(R.id.btnAgregar);
        Button btnFiltrarCategoria = findViewById(R.id.btnFiltrarCategoria);
        Button btnFiltrarPorNombre = findViewById(R.id.btnFiltrarPorNombre);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProductoAdapter(gestorProductos.obtenerProductos());
        recyclerView.setAdapter(adapter);

        // Agregar producto
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = edtNombre.getText().toString();
                double precio = Double.parseDouble(edtPrecio.getText().toString());
                String categoria = spinnerCategoria.getSelectedItem().toString(); // Obtener categoría seleccionada

                gestorProductos.agregarProducto(new Producto(nombre, precio, categoria));
                adapter.notifyDataSetChanged();
                Toast.makeText(GestionProductosActivity.this, "Producto agregado", Toast.LENGTH_SHORT).show();
            }

        });

        btnFiltrarCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GestionProductosActivity.this, FiltrarProductosActivity.class);
                startActivity(intent);
            }
        });
        btnFiltrarPorNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GestionProductosActivity.this, FiltrarPorNombreActivity.class);
                startActivity(intent);
            }
        });

    }
}

