package com.calamarasmtic.petagram.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.calamarasmtic.petagram.R;
import com.calamarasmtic.petagram.adapter.MascotAdaptor;
import com.calamarasmtic.petagram.pojo.Mascota;
import com.calamarasmtic.petagram.presentador.IRecyclerViewFragmentPresenter;
import com.calamarasmtic.petagram.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by Calamar Asmàtic on 05/11/2016.
 */

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {

    //private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }


   /* public void inicializarMascotas(){
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.ca, "Duff", 1));
        mascotas.add(new Mascota(R.drawable.gat, "Nermal", 1));
        mascotas.add(new Mascota(R.drawable.lloro, "Wings", 1));
        mascotas.add(new Mascota(R.drawable.zoid, "Mister Zoid", 5));
        mascotas.add(new Mascota(R.drawable.pandaaligator, "Bear", 4));
    }*/

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rvMascotas.setLayoutManager(gridLayoutManager);
    }

    @Override
    public MascotAdaptor crearAdaptador(ArrayList<Mascota> pets) {
        MascotAdaptor adaptador = new MascotAdaptor(pets, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptador(MascotAdaptor adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}
