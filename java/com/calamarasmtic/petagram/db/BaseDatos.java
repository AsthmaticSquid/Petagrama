package com.calamarasmtic.petagram.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.content.ContentResolverCompat;

import com.calamarasmtic.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Calamar Asmàtic on 13/11/2016.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " +ConstantesBaseDatos.TABLE_PETS+ "(" +
                                        ConstantesBaseDatos.TABLE_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesBaseDatos.TABLE_PETS_NAME + " TEXT, " +
                                        ConstantesBaseDatos.TABLE_PETS_PHOTO + " INTEGER " +
                                        ")";

        String queryCrearTablaLikesMascota =    "CREATE TABLE " +ConstantesBaseDatos.TABLE_PETS_LIKES+ "(" +
                                                ConstantesBaseDatos.TABLE_PETS_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                ConstantesBaseDatos.TABLE_PETS_LIKES_ID_PET + " INTEGER, " +
                                                ConstantesBaseDatos.TABLE_PETS_LIKES_LIKES + " INTEGER, " +
                                                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_PETS_LIKES_ID_PET + ") " +
                                                "REFERENCES " + ConstantesBaseDatos.TABLE_PETS + "("+ConstantesBaseDatos.TABLE_PETS_ID+") " +
                                                ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_PETS);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_PETS_LIKES);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerFavPets(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT m.*, (SELECT COUNT("+ConstantesBaseDatos.TABLE_PETS_LIKES_LIKES+")"+
                " FROM "+ConstantesBaseDatos.TABLE_PETS_LIKES+
                " WHERE "+ConstantesBaseDatos.TABLE_PETS_LIKES_ID_PET+"=m.id) as likes"+
                " FROM "+ConstantesBaseDatos.TABLE_PETS+" m"+
                " ORDER BY likes DESC"+
                " LIMIT 5";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()){
            /*
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(cursor.getInt(0));
            mascotaActual.setNombre(cursor.getString(1));
            mascotaActual.setFoto(cursor.getInt(2));

            mascotas.add(mascotaActual);
            */
        }
        db.close();

        return mascotas;
    }

    public ArrayList<Mascota> obtenerAllPets(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_PETS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            /*
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_PETS_LIKES_LIKES+") as likes"+
                                " FROM " + ConstantesBaseDatos.TABLE_PETS_LIKES+
                                " WHERE " + ConstantesBaseDatos.TABLE_PETS_LIKES_ID_PET+ "="+mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if(registrosLikes.moveToNext()){
                mascotaActual.setVotos(registrosLikes.getInt(0));
            } else {
                mascotaActual.setVotos(0);
            }

            mascotas.add(mascotaActual);
            */
        }
        db.close();

        return mascotas;
    }

    public void insertarMascota (ContentValues cv){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_PETS, null, cv);
        db.close();

    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_PETS_LIKES, null, contentValues);
        db.close();
    }

    public int obtenerLikesContacto(Mascota mascota){
        int likes = 0;
        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_PETS_LIKES_LIKES+")"+
                        " FROM " + ConstantesBaseDatos.TABLE_PETS_LIKES+
                        " WHERE " + ConstantesBaseDatos.TABLE_PETS_LIKES_ID_PET+ "="+mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor regs = db.rawQuery(query, null);

        if (regs.moveToNext()){
            likes = regs.getInt(0);
        }

        db.close();

        return  likes;
    }
}
