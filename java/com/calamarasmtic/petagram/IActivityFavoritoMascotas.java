package com.calamarasmtic.petagram;

import com.calamarasmtic.petagram.adapter.MascotAdaptor;
import com.calamarasmtic.petagram.adapter.MascotFavAdaptor;
import com.calamarasmtic.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Calamar Asmàtic on 14/11/2016.
 */

public interface IActivityFavoritoMascotas {

    public void generarLinearLayoutVertical();

    public MascotFavAdaptor crearAdaptador(ArrayList<Mascota> pets);

    public void inicializarAdaptador(MascotFavAdaptor adaptador);
}
