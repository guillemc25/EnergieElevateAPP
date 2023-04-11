package com.example.energieelevate;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDeDatos extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "BaseDeDatosEnergieElevate.db";

    public BaseDeDatos(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // crea las tablas de la base de datos
        db.execSQL("CREATE TABLE Usuarios( Usuario TEXT PRIMARY KEY, Nombre TEXT, Apellido TEXT, " +
                " Correo TEXT UNIQUE, Contraseña TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // actualiza la base de datos a una nueva versión
    }
}
