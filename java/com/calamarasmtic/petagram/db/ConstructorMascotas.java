package com.calamarasmtic.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.calamarasmtic.petagram.R;
import com.calamarasmtic.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Calamar Asmàtic on 13/11/2016.
 */

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context c;
    public ConstructorMascotas(Context c){
        this.c = c;
    }

    public ArrayList<Mascota> obtenerDatosFavs(){
        BaseDatos db = new BaseDatos(c);
        return db.obtenerFavPets();
    }

    public ArrayList<Mascota> obtenerDatos(){
       /* ArrayList<Mascota> mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.ca, "Duff", 1));
        mascotas.add(new Mascota(R.drawable.gat, "Nermal", 1));
        mascotas.add(new Mascota(R.drawable.lloro, "Wings", 1));
        mascotas.add(new Mascota(R.drawable.zoid, "Mister Zoid", 5));
        mascotas.add(new Mascota(R.drawable.pandaaligator, "Bear", 4));
        return mascotas;*/

        BaseDatos db = new BaseDatos(c);
        insertarMascotas(db);
        return db.obtenerAllPets();
    }

    public void insertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NAME, "Duff");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PHOTO, R.drawable.ca);
        //contentValues.put(ConstantesBaseDatos.TABLE_PETS_LIKES_LIKES, 1);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NAME, "Mister Zoid");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PHOTO, R.drawable.zoid);
        //contentValues.put(ConstantesBaseDatos.TABLE_PETS_LIKES_LIKES, 5);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_NAME, "Bear");
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_PHOTO, R.drawable.pandaaligator);
        //contentValues.put(ConstantesBaseDatos.TABLE_PETS_LIKES_LIKES, 4);

        db.insertarMascota(contentValues);

    }

    public void darLike(Mascota mascota){
        BaseDatos db = new BaseDatos(c);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_LIKES_ID_PET, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_PETS_LIKES_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(c);
        return  db.obtenerLikesContacto(mascota);
    }
}
