package com.example.tareapp.vista;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tareapp.R;

import java.util.HashMap;
import java.util.List;

import android.widget.HorizontalScrollView;

public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.NotaViewHolder> {

    private final List<HashMap<String, Object>> listaNotas;
    private final NotasView notasView;

    public NotaAdapter(List<HashMap<String, Object>> listaNotas, NotasView notasView) {
        this.listaNotas = listaNotas;
        this.notasView = notasView;
    }

    @NonNull
    @Override
    public NotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_nota, parent, false);
        return new NotaViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull NotaViewHolder holder, int position) {
        HashMap<String, Object> nota = listaNotas.get(position);

        holder.textoNota.setText((String) nota.get("descripcion"));

        String color = (String) nota.get("color");

        // Cambiar el color del fondo del HorizontalScrollView
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) holder.itemView.findViewById(R.id.idHorizontalScrollView);

        switch(color) {
            case "naranja":
                horizontalScrollView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.naranja_nota));
                break;
            case "verde":
                horizontalScrollView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.verde_nota));
                break;
            case "morado":
                horizontalScrollView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.morado_nota));
                break;
            case "amarillo":
                horizontalScrollView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.amarillo_nota));
                break;
            case "rosa":
                horizontalScrollView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.rosa_nota));
                break;
            default:
                horizontalScrollView.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.azul_nota));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return listaNotas.size();
    }

    static class NotaViewHolder extends RecyclerView.ViewHolder {
        TextView textoNota;

        public NotaViewHolder(@NonNull View itemView) {
            super(itemView);
            textoNota = itemView.findViewById(R.id.idTextoNota);
        }
    }
}

