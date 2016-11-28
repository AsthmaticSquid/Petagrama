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
import com.calamarasmtic.petagram.adapter.PerfilMascotaAdaptador;
import com.calamarasmtic.petagram.pojo.Mascota;
import com.calamarasmtic.petagram.presentador.IRecyclerViewFragmentPresenter;
import com.calamarasmtic.petagram.presentador.RecyclerViewFragmentPresenter;
import com.calamarasmtic.petagram.presentador.RecyclerViewPerfilFragmentPresenter;

import java.util.ArrayList;


public class PerFragment extends Fragment implements IRecyclerViewFragmentView{

    private ArrayList<Mascota> fotosMiPet;
    private RecyclerView rvFotosMiPet;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        rvFotosMiPet = (RecyclerView) v.findViewById(R.id.rvFotosMiPet);
/*
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
        //glm.setOrientation(LinearLayoutManager.VERTICAL);

        rvFotosMiPet.setLayoutManager(glm);

        //inicializarMascotas();
        inicializarAdaptador();
*/

        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;

    }



    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvFotosMiPet.setLayoutManager(llm);
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rvFotosMiPet.setLayoutManager(gridLayoutManager);
    }

    @Override
    public MascotAdaptor crearAdaptador(ArrayList<Mascota> pets) {
        MascotAdaptor adaptador = new MascotAdaptor(pets, getActivity()  );
        return adaptador;
    }

    @Override
    public void inicializarAdaptador(MascotAdaptor adaptador) {
        rvFotosMiPet.setAdapter(adaptador);
    }

    /*
    public void inicializarMascotas(){
        fotosMiPet = new ArrayList<>();

        fotosMiPet.add(new Mascota(R.drawable.pandaaligator, 4));
        fotosMiPet.add(new Mascota(R.drawable.pandaaligator, 2));
        fotosMiPet.add(new Mascota(R.drawable.pandaaligator, 1));
        fotosMiPet.add(new Mascota(R.drawable.pandaaligator, 0));
        fotosMiPet.add(new Mascota(R.drawable.pandaaligator, 3));
        fotosMiPet.add(new Mascota(R.drawable.pandaaligator, 5));

    }
    */

}
