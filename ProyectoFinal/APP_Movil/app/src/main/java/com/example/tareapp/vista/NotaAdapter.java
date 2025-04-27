package com.example.tareapp.vista;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tareapp.R;
import com.example.tareapp.modelo.Nota;
import java.util.List;

import android.widget.HorizontalScrollView;

public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.NotaViewHolder> {

    private final List<Nota> listaNotas;
    private OnItemClickListener listener;
    public NotaAdapter(List<Nota> listaNotas) {
        this.listaNotas = listaNotas;
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

        Nota nota = listaNotas.get(position);

        holder.textoNota.setText(nota.getDescripcion());
        String color = nota.getColor();

        switch(color) {
            case "naranja":
                holder.textoNota.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.naranja_nota));
                break;
            case "verde":
                holder.textoNota.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.verde_nota));
                break;
            case "morado":
                holder.textoNota.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.morado_nota));
                break;
            case "amarillo":
                holder.textoNota.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.amarillo_nota));
                break;
            case "rosa":
                holder.textoNota.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.rosa_nota));
                break;
            default:
                holder.textoNota.setBackgroundColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.azul_nota));
                break;
        }

        holder.textoNota.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(nota);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaNotas.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Nota nota);
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    static class NotaViewHolder extends RecyclerView.ViewHolder {
        TextView textoNota;
        public NotaViewHolder(@NonNull View itemView) {
            super(itemView);

            textoNota = itemView.findViewById(R.id.idTextoNota);
        }
    }

}

