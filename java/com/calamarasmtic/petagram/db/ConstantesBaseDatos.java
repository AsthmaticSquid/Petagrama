package com.calamarasmtic.petagram.db;

/**
 * Created by Calamar Asmàtic on 13/11/2016.
 *
 */

public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_PETS = "mascota";
    public static final String TABLE_PETS_ID = "id";
    public static final String TABLE_PETS_PHOTO = "foto";
    public static final String TABLE_PETS_NAME = "nombre";

    public static final String TABLE_PETS_LIKES = "mascota_likes";
    public static final String TABLE_PETS_LIKES_ID = "id";
    public static final String TABLE_PETS_LIKES_ID_PET = "id_mascota";
    public static final String TABLE_PETS_LIKES_LIKES = "numero_likes";
}
