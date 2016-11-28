package com.calamarasmtic.petagram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.calamarasmtic.petagram.ActivityFavoritoMascotas;
import com.calamarasmtic.petagram.db.ConstructorMascotas;
import com.calamarasmtic.petagram.pojo.Mascota;
import com.calamarasmtic.petagram.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class MascotAdaptor extends RecyclerView.Adapter<MascotAdaptor.MascotaViewHolder> {

    private ArrayList<Mascota> mascotas = new ArrayList<>();
    private Activity activity;

    public MascotAdaptor(ArrayList<Mascota> pets, FragmentActivity mainActivity){
        this.mascotas = pets;
        this.activity = mainActivity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota m = mascotas.get(position);
        // holder.imgFotoCV.setImageResource(m.getFoto());
        Picasso.with(activity)
                .load(m.getUrlfoto())
                .placeholder(R.drawable.pandaaligator)
                .into(holder.imgFotoCV);

        holder.tvNombreCV.setText(m.getNombre());
        //holder.tvContCV.setText(Integer.toString(m.getVotos()));
        holder.tvContCV.setText(String.valueOf(m.getVotos()));

        holder.btnWhiteBoneCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + m.getNombre(), Toast.LENGTH_SHORT).show();
                //m.setVotos(m.getVotos()+1);
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLike(m);
                m.setVotos(constructorMascotas.obtenerLikesMascota(m));
                holder.tvContCV.setText(Integer.toString(m.getVotos()));

                //constructorMascotas.darLike(m);
                //int numV = constructorMascotas.obtenerLikesMascota(m);
                //holder.tvContCV.setText(Integer.toString(constructorMascotas.obtenerLikesMascota(m)));
                //holder.tvContCV.setText(Integer.toString(numV));
                //CharSequence num = holder.tvContCV.getText();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotoCV;
        private TextView tvNombreCV;
        private TextView tvContCV;
        private ImageButton btnWhiteBoneCV;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoCV = (ImageView) itemView.findViewById(R.id.imgFotoCV);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvContCV = (TextView) itemView.findViewById(R.id.tvContCV);
            btnWhiteBoneCV = (ImageButton) itemView.findViewById(R.id.btnWhiteBoneCV);
        }
    }



    }

