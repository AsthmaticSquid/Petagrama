package com.calamarasmtic.petagram.adapter;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.calamarasmtic.petagram.R;
import com.calamarasmtic.petagram.db.ConstructorMascotas;
import com.calamarasmtic.petagram.pojo.Mascota;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

/**
 * Created by Calamar Asmàtic on 14/11/2016.
 */

public class MascotFavAdaptor extends RecyclerView.Adapter<MascotFavAdaptor.MascotaFavViewHolder> {

    private ArrayList<Mascota> mascotas = new ArrayList<>();
    private Activity activity;

    public MascotFavAdaptor(ArrayList<Mascota> pets, Activity favsActivity){
        this.mascotas = pets;
        this.activity = favsActivity;
    }

    @Override
    public MascotaFavViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota_favs, parent, false);
        return new MascotaFavViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotFavAdaptor.MascotaFavViewHolder holder, int position) {
        final Mascota m = mascotas.get(position);
        ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);

        Picasso.with(activity)
                .load(m.getUrlfoto())
                .placeholder(R.drawable.pandaaligator)
                .into(holder.imgFotoFavCV);

        holder.tvNombreFavCV.setText(m.getNombre());
        holder.tvContFavCV.setText(String.valueOf(m.getVotos()));
        //holder.tvContFavCV.setText(Integer.toString(constructorMascotas.obtenerLikesMascota(m)));

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaFavViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFotoFavCV;
        private TextView tvNombreFavCV;
        private TextView tvContFavCV;

        public MascotaFavViewHolder(View itemView) {
            super(itemView);
            imgFotoFavCV = (ImageView) itemView.findViewById(R.id.imgFotoFavCV);
            tvNombreFavCV = (TextView) itemView.findViewById(R.id.tvNombreFavCV);
            tvContFavCV = (TextView) itemView.findViewById(R.id.tvContFavCV);
        }
    }
}
