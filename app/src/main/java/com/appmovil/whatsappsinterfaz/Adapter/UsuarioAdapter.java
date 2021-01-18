package com.appmovil.whatsappsinterfaz.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.appmovil.whatsappsinterfaz.Model.Usuario;
import com.appmovil.whatsappsinterfaz.R;

import java.util.List;


public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder> {

    private Context Ctx;
    private List<Usuario> lstUsuarios;

    public UsuarioAdapter(Context mCtx, List<Usuario> usuarios) {
        this.lstUsuarios = usuarios;
        Ctx=mCtx;
    }

    @Override
    public UsuarioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.item_usuario, null);
        return new UsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UsuarioViewHolder holder, int position) {

        Usuario usuario = lstUsuarios.get(position);

        holder.textViewName.setText(usuario.getName());
        holder.textViewMail.setText(usuario.getType());
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

        TextView textViewName, textViewFecha, textViewMail;
        ImageView imageView;

        public UsuarioViewHolder(View itemView) {
            super(itemView);

            textViewName= itemView.findViewById(R.id.txtName);
            textViewFecha = itemView.findViewById(R.id.txtfecha);
            textViewMail = itemView.findViewById(R.id.txtMensaje);
            imageView = itemView.findViewById(R.id.imgAvatar);
        }
    }

}
