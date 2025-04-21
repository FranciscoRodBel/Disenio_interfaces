package com.example.tareapp.vista;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tareapp.R;
import com.example.tareapp.controlador.Tarea_controlador;
import com.example.tareapp.modelo.Tarea;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TareaAdapter extends RecyclerView.Adapter<TareaAdapter.TareaViewHolder> {
    private final List<Tarea> listaTareas;
    private final Tarea_controlador tarea_controlador = new Tarea_controlador();

    public TareaAdapter(List<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public interface OnItemClickListener {
        void onItemClick(Tarea tarea);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
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
            fechaTarea = itemView.findViewById(R.id.idEmailCuenta);
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
        holder.fechaTarea.setText(convertirFechaAString(tarea.getFecha()));
        holder.tareaCompletada.setChecked(tarea.isCompletada());

        int iconoPrioridad;
        switch (tarea.getPrioridad()) {
            case 1:
                iconoPrioridad = R.drawable.circle_arrow_down_solid;
                break;
            case 2:
                iconoPrioridad = R.drawable.circle_arrow_right_solid;
                break;
            default:
                iconoPrioridad = R.drawable.circle_arrow_up_solid;
                break;
        }
        holder.prioridadTarea.setImageResource(iconoPrioridad);

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(tarea);
            }
        });

        holder.tareaCompletada.setOnClickListener(v -> new Thread(() -> {

            if (tarea.isCompletada()) {

                if (tarea_controlador.completarTarea(tarea.getIdTarea(), 0)) tarea.setCompletada(0);

            } else {

                if (tarea_controlador.completarTarea(tarea.getIdTarea(), 1)) tarea.setCompletada(1);
            }
        }).start());
    }

    @Override
    public int getItemCount() {
        return listaTareas.size();
    }

    /**
     * Función que permite convertir el formato Date de la BBDD al formato de la aplicación dd/mm/yyyy
     *
     * @return Devuelve la fecha en el formato dd/mm/yyyy
     */
    public static String convertirFechaAString(String fechaSQL) {

        try {

            @SuppressLint("SimpleDateFormat") SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formatoEntrada.parse(fechaSQL);

            @SuppressLint("SimpleDateFormat") SimpleDateFormat formatoSalida = new SimpleDateFormat("dd/MM/yyyy");
            return formatoSalida.format(fecha);

        } catch (Exception e) {
            e.printStackTrace();
            return fechaSQL;
        }
    }
}
