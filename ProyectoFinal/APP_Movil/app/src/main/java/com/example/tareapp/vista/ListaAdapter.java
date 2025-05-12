package com.example.tareapp.vista;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tareapp.R;
import com.example.tareapp.controlador.CambiarVista;
import com.example.tareapp.controlador.Idioma_controlador;
import com.example.tareapp.controlador.Lista_controlador;

import java.util.HashMap;
import java.util.List;

/**
 * Clase para el funcionamiento de las listas
 * Adaptador para añadir listas a un RecyclerView
 *
 * @author Francisco
 */
public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ListaViewHolder> {

    Lista_controlador lista_controlador = new Lista_controlador();
    private final List<HashMap<String, Object>> listas; // Listas que se mostrarán en el RecyclerView
    private final Fragment fragment; // Fragmento donde está el RecyclerView

    public ListaAdapter(List<HashMap<String, Object>> listas, Fragment fragment) { // Constructor que recibe las listas y el fragmento de ListasView
        this.listas = listas;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public ListaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // Se activa cuando el RecyclerView necesita crear una nueva vista para el item_lista
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista, parent, false);
        return new ListaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaViewHolder holder, int posicion) { // Funcionamiento de cada item del RecyclerView

        HashMap<String, Object> lista = listas.get(posicion); // Recojo la lista actual
        String titulo = (String) lista.get("titulo");
        String idLista = String.valueOf(lista.get("idLista"));
        holder.titulo.setText(titulo); // muestro el título de la lista

        holder.idBotonVerLista.setOnClickListener(v -> { // Le añado al item un listener para cuando pulse en ver lista

            SharedPreferences prefs = fragment.requireContext().getSharedPreferences("tarea_lista_seleccionada", 0); // Recojo el prefs de lista seleccionada
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("idListaSeleccionada", Integer.parseInt(idLista)); // Guardo la lista que tiene que estar seleccionada
            editor.apply();

            CambiarVista.cambiarFragmento(fragment.requireActivity().getSupportFragmentManager(), new TareasView()); // Cambio a la vista de TareasView con la lista seleccionada
        });

        holder.idEditarLista.setOnClickListener(v -> { // Le añado al item un listener para cuando pulse en editar lista

            ListaEditar dialog = ListaEditar.nuevaInstancia(idLista, titulo); // Creo el PopUp de editar lista

            if (fragment instanceof ListaEditar.OnListaEditadaListener) { // Compruebo que tenga el listener

                dialog.setOnListaEditadaListener((ListaEditar.OnListaEditadaListener) fragment); // Añado el listener para comprobar si la lista fue editada
            }

            dialog.show(fragment.getParentFragmentManager(), "editar_lista"); // Muestro el PopUp
        });

        holder.idBorrarLista.setOnClickListener(v -> { // Le añado al item un listener para cuando pulse en borrar lista

            // Creo un PopUp con un AlertDialog para preguntar si quiere borrar la lista
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(fragment.getContext());
            alertDialogBuilder.setTitle(Idioma_controlador.getIdioma_seleccionado().getPagina_listas().getPregunta_borrar_lista());
            alertDialogBuilder
                    .setMessage(titulo)
                    .setCancelable(false)
                    .setPositiveButton(Idioma_controlador.getIdioma_seleccionado().getPagina_listas().getBorrar_lista(), new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) { // Si pulsa en aceptar...
                            new Thread(() -> {

                                String mensaje_resultado = lista_controlador.borrar_lista(Integer.parseInt(idLista)); // Borra la lista

                                if (mensaje_resultado.isEmpty()) { // Si el mensaje está vacío es que lo eliminó

                                    ((ListasView) fragment).actualizar_panel_lista(); // Si lo elimina, actualizo el panel de las listas
                                }

                                fragment.requireActivity().runOnUiThread(() -> { // Muestro el mensaje del resultado final con un Toast
                                    Toast.makeText(fragment.getContext(), Idioma_controlador.getIdioma_seleccionado().getPagina_listas().getLista_borrada(), Toast.LENGTH_SHORT).show();
                                });
                            }).start();
                        }
                    })
                    .setNegativeButton(Idioma_controlador.getIdioma_seleccionado().getPagina_tareas().getCancelar(), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) { // Si pulsa en cancelar
                            dialogInterface.cancel(); // Cerrar popUp
                        }
                    }).create().show();
        });

    }

    @Override
    public int getItemCount() {
        return listas.size();
    } // Devuleve el número de listas

    public static class ListaViewHolder extends RecyclerView.ViewHolder { // Clase que contiene las vistas de cada item de la lista
        TextView titulo;
        ImageView idBotonVerLista, idEditarLista, idBorrarLista;

        public ListaViewHolder(@NonNull View itemView) { // Recojo los componentes del item
            super(itemView);
            titulo = itemView.findViewById(R.id.idTitulo);
            idBotonVerLista = itemView.findViewById(R.id.idPrioridadTarea);
            idEditarLista = itemView.findViewById(R.id.idEditarLista);
            idBorrarLista = itemView.findViewById(R.id.idBorrarLista);
        }
    }
}
