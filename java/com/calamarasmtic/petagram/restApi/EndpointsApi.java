package com.calamarasmtic.petagram.restApi;

import com.calamarasmtic.petagram.restApi.model.MascotaResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Calamar Asmàtic on 27/11/2016.
 */

public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<MascotaResponse> getRecentMedia();


}
