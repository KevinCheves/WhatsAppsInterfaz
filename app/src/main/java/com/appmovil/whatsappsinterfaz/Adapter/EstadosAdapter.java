package com.appmovil.whatsappsinterfaz.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.appmovil.whatsappsinterfaz.Model.Usuario;
import com.appmovil.whatsappsinterfaz.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class EstadosAdapter extends RecyclerView.Adapter<EstadosAdapter.UsuarioViewHolder> {
    private Context Ctx;
    private List<Usuario> lstUsuarios;

    public EstadosAdapter(Context mCtx, List<Usuario> usuarios) {
        this.lstUsuarios = usuarios;
        Ctx=mCtx;
    }

    @Override
    public EstadosAdapter.UsuarioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.item_estados, null);
        return new EstadosAdapter.UsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EstadosAdapter.UsuarioViewHolder holder, int position) {

        Usuario usuario = lstUsuarios.get(position);

        holder.textViewName.setText(usuario.getName());
        holder.textViewFecha.setText(usuario.getCreated());

        Glide.with(Ctx)
                .load(usuario.getUrlimage())
                .into(holder.imageView);

    }


    @Override
    public int getItemCount() {
        return lstUsuarios.size();
    }


    class UsuarioViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewFecha;
        ImageView imageView;

        public UsuarioViewHolder(View itemView) {
            super(itemView);

            textViewName= itemView.findViewById(R.id.txtName);
            textViewFecha = itemView.findViewById(R.id.txtfecha);
            imageView = itemView.findViewById(R.id.imgAvatar);
        }
    }

}
