package com.example.proyectazo;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> {
    private List<Producto> listaProductos;

    public ProductoAdapter(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);
        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Producto producto = listaProductos.get(position);
        holder.txtNombre.setText(producto.getNombre());
        holder.txtPrecio.setText("Precio: $" + producto.getPrecio());
        holder.txtCategoria.setText("Categoría: " + producto.getCategoria());
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    static class ProductoViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre, txtPrecio, txtCategoria;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtPrecio = itemView.findViewById(R.id.txtPrecio);
            txtCategoria = itemView.findViewById(R.id.txtCategoria);
        }
    }
}


