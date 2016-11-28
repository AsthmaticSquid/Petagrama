package com.calamarasmtic.petagram.restApi.model;

import android.support.v7.app.AppCompatActivity;

import com.calamarasmtic.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Calamar Asmàtic on 27/11/2016.
 */

public class MascotaResponse {

    ArrayList<Mascota> mascotas;

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }
    public void setMascotas(ArrayList<Mascota> mascotas) {this.mascotas = mascotas;}
}
