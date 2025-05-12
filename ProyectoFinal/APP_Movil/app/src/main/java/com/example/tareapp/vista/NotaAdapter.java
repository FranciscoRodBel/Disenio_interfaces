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

/**
 * Clase para el funcionamiento de las notas
 * Adaptador para añadir notas a un RecyclerView
 *
 * @author Francisco
 */
public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.NotaViewHolder> {

    private final List<Nota> listaNotas;
    private OnItemClickListener listener;
    public NotaAdapter(List<Nota> listaNotas) { // Constructor que recibe las notas
        this.listaNotas = listaNotas;
    }

    @NonNull
    @Override
    public NotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // Se activa cuando el RecyclerView necesita crear una nueva vista para el item_nota
        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_nota, parent, false);
        return new NotaViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull NotaViewHolder holder, int posicion) { // Funcionamiento de cada item del RecyclerView

        Nota nota = listaNotas.get(posicion); // Recojo la nota actual

        holder.textoNota.setText(nota.getDescripcion()); // Muestro el texto de la nota
        String color = nota.getColor(); // Recojo el color

        switch(color) { // Añado el color de la nota
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

        holder.textoNota.setOnClickListener(v -> { // Cuando se pulsa en la nota llama a onItemClick
            if (listener != null) {
                listener.onItemClick(nota);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaNotas.size();
    } // Devuleve el número de notas

    public interface OnItemClickListener { // Cuando se pulsa en la nota llama a onItemClick
        void onItemClick(Nota nota);
    }


    public void setOnItemClickListener(OnItemClickListener listener) { // Para aplicar un listener al fragmento principal(NotasView)
        this.listener = listener;
    }

    static class NotaViewHolder extends RecyclerView.ViewHolder { // Clase que contiene las vistas de cada item de la nota
        TextView textoNota;
        public NotaViewHolder(@NonNull View itemView) { // Recojo los componentes del item
            super(itemView);

            textoNota = itemView.findViewById(R.id.idTextoNota);
        }
    }
}

