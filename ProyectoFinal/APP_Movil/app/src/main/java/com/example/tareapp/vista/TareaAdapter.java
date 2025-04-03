package com.example.tareapp.vista;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tareapp.R;
import com.example.tareapp.modelo.Tarea;

import java.util.List;

public class TareaAdapter extends RecyclerView.Adapter<TareaAdapter.TareaViewHolder> {
    private final List<Tarea> listaTareas;

    public TareaAdapter(List<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public static class TareaViewHolder extends RecyclerView.ViewHolder {
        CheckBox tareaCompletada;
        TextView tituloTarea;
        ImageView prioridadTarea;
        TextView fechaTarea;

        public TareaViewHolder(@NonNull View itemView) {
            super(itemView);
            tareaCompletada = itemView.findViewById(R.id.idTareaCompletada);
            tituloTarea = itemView.findViewById(R.id.idTituloTarea);
            prioridadTarea = itemView.findViewById(R.id.idPrioridadTarea);
            fechaTarea = itemView.findViewById(R.id.idFechaTarea);
        }
    }

    @NonNull
    @Override
    public TareaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tarea, parent, false);
        return new TareaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TareaViewHolder holder, int position) {
        Tarea tarea = listaTareas.get(position);
        holder.tituloTarea.setText(tarea.getTitulo());
        holder.fechaTarea.setText(tarea.getFecha());
        holder.tareaCompletada.setChecked(tarea.isCompletada());

        // Asignar icono de prioridad
        int iconoPrioridad;
        switch (tarea.getPrioridad()) {
            case 1:
                iconoPrioridad = R.drawable.circle_arrow_up_solid;
                break;
            case 2:
                iconoPrioridad = R.drawable.circle_arrow_right_solid;
                break;
            default:
                iconoPrioridad = R.drawable.circle_arrow_down_solid;
                break;
        }
        holder.prioridadTarea.setImageResource(iconoPrioridad);
    }

    @Override
    public int getItemCount() {
        return listaTareas.size();
    }
}
