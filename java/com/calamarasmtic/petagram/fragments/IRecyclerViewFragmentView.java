package com.calamarasmtic.petagram.fragments;

import com.calamarasmtic.petagram.adapter.MascotAdaptor;
import com.calamarasmtic.petagram.pojo.Mascota;

import java.util.ArrayList;

import javax.mail.event.ConnectionAdapter;

/**
 * Created by Calamar Asmàtic on 13/11/2016.
 */

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public void generarGridLayout();

    public MascotAdaptor crearAdaptador(ArrayList<Mascota> pets);

    public void inicializarAdaptador(MascotAdaptor adaptador);
}
