package com.example.tareapp.vista;

import static java.security.AccessController.getContext;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.example.tareapp.controlador.Idioma_controlador;
import com.example.tareapp.controlador.Lista_controlador;

import java.util.HashMap;
import java.util.List;

public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ListaViewHolder> {

    Lista_controlador lista_controlador = new Lista_controlador();
    private final List<HashMap<String, Object>> listas;
    private final Fragment fragment;

    public ListaAdapter(List<HashMap<String, Object>> listas, Fragment fragment) {
        this.listas = listas;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public ListaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista, parent, false);
        return new ListaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaViewHolder holder, int position) {
        HashMap<String, Object> lista = listas.get(position);
        String titulo = (String) lista.get("titulo");
        String idLista = String.valueOf(lista.get("idLista"));
        holder.titulo.setText(titulo);

        holder.idBotonVerLista.setOnClickListener(v -> {

            System.out.println("Ver lista: " + titulo);
        });

        holder.idEditarLista.setOnClickListener(v -> {

            ListaEditar dialog = ListaEditar.newInstance(idLista, titulo);

            if (fragment instanceof ListaEditar.OnListaEditadaListener) {

                dialog.setOnListaEditadaListener((ListaEditar.OnListaEditadaListener) fragment);
            }

            dialog.show(fragment.getParentFragmentManager(), "editar_lista");
        });

        holder.idBorrarLista.setOnClickListener(v -> {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(fragment.getContext());
            alertDialogBuilder.setTitle(Idioma_controlador.getIdioma_seleccionado().getPagina_listas().getPregunta_borrar_lista());
            alertDialogBuilder
                    .setMessage(titulo)
                    .setCancelable(false)
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            new Thread(() -> {

                                String mensaje_resultado = lista_controlador.borrar_lista(Integer.parseInt(idLista));

                                if (mensaje_resultado.isEmpty()) {

                                    mensaje_resultado = Idioma_controlador.getIdioma_seleccionado().getPagina_listas().getLista_borrada();

                                    ((ListasView) fragment).actualizar_panel_lista();
                                }

                                fragment.requireActivity().runOnUiThread(() -> {
                                    Toast.makeText(fragment.getContext(), Idioma_controlador.getIdioma_seleccionado().getPagina_listas().getLista_borrada(), Toast.LENGTH_SHORT).show();
                                });
                            }).start();
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel(); // Cerrar popUp
                        }
                    }).create().show();
        });

    }

    @Override
    public int getItemCount() {
        return listas.size();
    }

    public static class ListaViewHolder extends RecyclerView.ViewHolder {
        TextView titulo;
        ImageView idBotonVerLista, idEditarLista, idBorrarLista;

        public ListaViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.idTituloTarea);
            idBotonVerLista = itemView.findViewById(R.id.idBotonVerLista);
            idEditarLista = itemView.findViewById(R.id.idEditarLista);
            idBorrarLista = itemView.findViewById(R.id.idBorrarLista);
        }
    }
}
