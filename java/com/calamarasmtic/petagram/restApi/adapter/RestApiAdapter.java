package com.calamarasmtic.petagram.restApi.adapter;

import com.calamarasmtic.petagram.restApi.ConstantesRestApi;
import com.calamarasmtic.petagram.restApi.EndpointsApi;
import com.calamarasmtic.petagram.restApi.deserializador.MascotaFavDeserializador;
import com.calamarasmtic.petagram.restApi.deserializador.MascotaDeserializador;
import com.calamarasmtic.petagram.restApi.model.MascotaResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Calamar Asmàtic on 27/11/2016.
 */

public class RestApiAdapter {

    public EndpointsApi establecerConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointsApi.class);
    }

    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializador());
        return gsonBuilder.create();
    }

    public Gson construyeGsonDeserializadorMediaRecentOtherUser(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaFavDeserializador());
        return gsonBuilder.create();
    }
}
