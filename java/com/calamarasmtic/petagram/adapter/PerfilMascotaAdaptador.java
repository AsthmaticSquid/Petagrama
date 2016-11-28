package com.calamarasmtic.petagram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.calamarasmtic.petagram.ActivityDetalleMascota;
import com.calamarasmtic.petagram.R;
import com.calamarasmtic.petagram.pojo.Mascota;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Calamar Asmàtic on 06/11/2016.
*/

public class PerfilMascotaAdaptador extends RecyclerView.Adapter<PerfilMascotaAdaptador.FotoPerfilViewHolder> {

    private ArrayList<Mascota> fotosPerf;
    Activity activity;

    public PerfilMascotaAdaptador(ArrayList<Mascota> pets, Activity mainActivity){
        this.fotosPerf = pets;
        this.activity = mainActivity;
    }

    @Override
    public FotoPerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota_perfil, parent, false);
        return new PerfilMascotaAdaptador.FotoPerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FotoPerfilViewHolder holder, int position) {
        final Mascota m = fotosPerf.get(position);

        Picasso.with(activity)
                .load(m.getUrlfoto())
                .placeholder(R.drawable.pandaaligator)
                .into(holder.imgFotoCV);
        holder.tvContCV.setText(String.valueOf(m.getVotos()));

        holder.imgFotoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activity, ActivityDetalleMascota.class);
                i.putExtra("url", m.getUrlfoto());
                i.putExtra("like", m.getVotos());
                activity.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return fotosPerf.size();
    }

    public static class FotoPerfilViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotoCV;
        private TextView tvContCV;

        public FotoPerfilViewHolder(View itemView) {
            super(itemView);
            imgFotoCV = (ImageView) itemView.findViewById(R.id.imgFotoCVPerfil);
            tvContCV = (TextView) itemView.findViewById(R.id.tvContCVPerfil);
        }
    }
}