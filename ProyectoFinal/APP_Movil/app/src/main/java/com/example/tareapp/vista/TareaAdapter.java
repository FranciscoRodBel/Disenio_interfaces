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

/**
 * Clase para el funcionamiento de las tareas
 * Adaptador para añadir tareas a un RecyclerView
 *
 * @author Francisco
 */
public class TareaAdapter extends RecyclerView.Adapter<TareaAdapter.TareaViewHolder> {

    private final List<Tarea> listaTareas; // Tareas que se mostrarán en el RecyclerView
    private OnItemClickListener listener;
    private final Tarea_controlador tarea_controlador = new Tarea_controlador();

    public TareaAdapter(List<Tarea> listaTareas) { // Constructor que recibe las tareas
        this.listaTareas = listaTareas;
    }

    public interface OnItemClickListener { // Si se hace click en la tarea, activa la función onItemClick envíando la tarea
        void onItemClick(Tarea tarea);
    }


    public void setOnItemClickListener(OnItemClickListener listener) { // Para aplicar un listener
        this.listener = listener;
    }

    public static class TareaViewHolder extends RecyclerView.ViewHolder { // Clase que contiene las vistas de cada item de la tarea

        CheckBox tareaCompletada;
        TextView tituloTarea;
        ImageView prioridadTarea;
        TextView fechaTarea;

        public TareaViewHolder(@NonNull View itemView) { // Recojo los componentes del item
            super(itemView);

            tareaCompletada = itemView.findViewById(R.id.idTareaCompletada);
            tituloTarea = itemView.findViewById(R.id.idTitulo);
            prioridadTarea = itemView.findViewById(R.id.idPrioridadTarea);
            fechaTarea = itemView.findViewById(R.id.idEmailCuenta);
        }
    }

    @NonNull
    @Override
    public TareaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // Se activa cuando el RecyclerView necesita crear una nueva vista para el item_tarea
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tarea, parent, false);
        return new TareaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TareaViewHolder holder, int position) { // Funcionamiento de cada item del RecyclerView

        Tarea tarea = listaTareas.get(position); // Recojo la lista actual

        // Añado los datos visibles a la interfaz del item
        holder.tituloTarea.setText(tarea.getTitulo());
        holder.fechaTarea.setText(convertirFechaAString(tarea.getFecha()));
        holder.tareaCompletada.setChecked(tarea.isCompletada());

        int iconoPrioridad;

        switch (tarea.getPrioridad()) { // Añado la imagen de la prioridad
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

        holder.prioridadTarea.setImageResource(iconoPrioridad); // Selecciono la imagen

        holder.itemView.setOnClickListener(v -> { // Si se hace click en el item...

            if (listener != null) {

                listener.onItemClick(tarea); // Activo la función enviando el objeto tarea
            }
        });

        holder.tareaCompletada.setOnClickListener(v -> new Thread(() -> { // Al hacer click en el checkbox para marcar o desmarcar la tarea...

            if (tarea.isCompletada()) { // Si está completada...

                if (tarea_controlador.completarTarea(tarea.getIdTarea(), 0)) tarea.setCompletada(0); // Desmarco la tarea en la BBDD

            } else {

                if (tarea_controlador.completarTarea(tarea.getIdTarea(), 1)) tarea.setCompletada(1); // Marco la tarea en la BBDD
            }
        }).start());
    }

    @Override
    public int getItemCount() {
        return listaTareas.size();
    } // Devuleve el número de tareas

    /**
     * Función que permite convertir el formato fecha de la BBDD al formato de la aplicación dd/mm/yyyy
     *
     * @return Devuelve la fecha en el formato dd/mm/yyyy
     */
    public static String convertirFechaAString(String fechaSQL) {

        try {

            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formatoEntrada.parse(fechaSQL);

            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat formatoSalida = new SimpleDateFormat("dd/MM/yyyy");
            return formatoSalida.format(fecha);

        } catch (Exception e) {
            e.printStackTrace();
            return fechaSQL;
        }
    }
}
