package com.example.energieelevate

import android.database.sqlite.SQLiteDatabase
import android.content.Context
import android.database.sqlite.SQLiteOpenHelper

    class DBconnection(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

        companion object {
            const val DATABASE_VERSION = 1
            const val DATABASE_NAME = "energie_elevate.db"

        }

        override fun onCreate(db: SQLiteDatabase?) {
            db?.execSQL("PRAGMA foreign_keys=ON;")

            db?.execSQL(
                "CREATE TABLE Usuario (" +
                        "IDusuario INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "Nombre TEXT," +
                        "Apellidos TEXT," +
                        "NombreUsuario TEXT," +
                        "CorreoElectornico TEXT, " +
                        "Contraseña TEXT" +
                        ")"
            )

            db?.execSQL(
                "CREATE TABLE Alimento_comidas (" +
                        "IDalimento_comida INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "NombreAlimento TEXT," +
                        " Descripcion_alimento TEXT," +
                        "Grasas_100g INTEGER," +
                        "Proteina_100g INTEGER," +
                        "Carbohidratos_100g INTEGER,"+
                        "Calorias_100g INTEGER"+
                        ")"
            )

            db?.execSQL(
                "CREATE TABLE Ejercicio (" +
                        "IDejercicio INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "Nombre_ejercicio TEXT," +
                        "grupo_muscular TEXT," +
                        "categoria INTEGER" +
                        ")"
            )

            db?.execSQL(
                "CREATE TABLE Rutinas_ejercicios (" +
                        "IDrutina INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "Descripcion_rutina TEXT," +
                        "fecha_creacion DATE," +
                        "Duracion_estimada INTEGER," +
                        "Nivel_dificultad INTEGER" +
                        ")"
            )
            db?.execSQL(
                "CREATE TABLE Rutina_ejercicio (" +
                        "IDrutina INTEGER, " +
                        "IDejercicio INTEGER," +
                        "FOREIGN KEY (IDrutina) REFERENCES Rutina_ejercicios(IDrutina),"+
                        "FOREIGN KEY (IDejercicio) REFERENCES Ejercicio(IDejercicio)" +

                        ")"
            )
            db?.execSQL(
                "CREATE TABLE datos_fisico(" +
                        "IDusuario INTEGER, " +
                        "Altura DOUBLE," +
                        "Objetivo_fisico TEXT," +
                        "Peso_kg DOUBLE" +
                        ")"
            )





        }

        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
            TODO("Not yet implemented")
        }

    }
