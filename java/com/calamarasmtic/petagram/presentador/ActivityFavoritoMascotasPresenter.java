package com.calamarasmtic.petagram.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.calamarasmtic.petagram.IActivityFavoritoMascotas;
import com.calamarasmtic.petagram.db.ConstructorMascotas;
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
 * Created by Calamar Asmàtic on 14/11/2016.
 */

public class ActivityFavoritoMascotasPresenter implements IActivityFavoritoMascotasPresenter {

    private IActivityFavoritoMascotas iActivityFavoritoMascotas;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> pets;

    public ActivityFavoritoMascotasPresenter(IActivityFavoritoMascotas iActivityFavoritoMascotas, Context context) {
        this.iActivityFavoritoMascotas = iActivityFavoritoMascotas;
        this.context = context;
        //obtenerMascotasFavs();
        obtenerMediosRecientesFav();
    }

    @Override
    public void obtenerMascotasFavs() {
        constructorMascotas = new ConstructorMascotas(context);
        pets = constructorMascotas.obtenerDatosFavs();
        mostrarMascotasFavs();
    }

    @Override
    public void obtenerMediosRecientesFav() {
        RestApiAdapter rAA = new RestApiAdapter();
        Gson gMR = rAA.construyeGsonDeserializadorMediaRecent();
        EndpointsApi ePA = rAA.establecerConexionRestApiInstagram(gMR);
        Call<MascotaResponse> mascotaResponseCall = ePA.getRecentMedia();

        mascotaResponseCall.enqueue(new Callback<MascotaResponse>(){

            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mR = response.body();
                pets = mR.getMascotas();
                mostrarMascotasFavs();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "¡Al pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }

        });
    }

    @Override
    public void mostrarMascotasFavs() {
        iActivityFavoritoMascotas.inicializarAdaptador(iActivityFavoritoMascotas.crearAdaptador(pets));
        iActivityFavoritoMascotas.generarLinearLayoutVertical();
    }
}
