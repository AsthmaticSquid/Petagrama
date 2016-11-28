package com.calamarasmtic.petagram.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.calamarasmtic.petagram.adapter.MascotAdaptor;
import com.calamarasmtic.petagram.db.ConstructorMascotas;
import com.calamarasmtic.petagram.fragments.IRecyclerViewFragmentView;
import com.calamarasmtic.petagram.pojo.Mascota;
import com.calamarasmtic.petagram.restApi.EndpointsApi;
import com.calamarasmtic.petagram.restApi.adapter.RestApiAdapter;
import com.calamarasmtic.petagram.restApi.model.MascotaResponse;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Calamar Asmàtic on 13/11/2016.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> pets;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        //obtenerMascotas();
        obtenerMediosRecientes();
    }

    @Override
    public void obtenerMascotas() {
        constructorMascotas = new ConstructorMascotas(context);
        pets = constructorMascotas.obtenerDatos();
        mostrarMascotasEnRecyclerView();
    }

    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter rAA = new RestApiAdapter();
        Gson gMR = rAA.construyeGsonDeserializadorMediaRecent();
        EndpointsApi ePA = rAA.establecerConexionRestApiInstagram(gMR);
        Call<MascotaResponse> mascotaResponseCall = ePA.getRecentMedia();

        mascotaResponseCall.enqueue(new Callback<MascotaResponse>(){

            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mR = response.body();
                pets = mR.getMascotas();
                mostrarMascotasEnRecyclerView();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "¡Al pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }

        });
    }

    @Override
    public void mostrarMascotasEnRecyclerView() {
        iRecyclerViewFragmentView.inicializarAdaptador(iRecyclerViewFragmentView.crearAdaptador(pets));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
