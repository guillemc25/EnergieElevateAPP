package com.example.energieelevate

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


 class activity_registro : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        supportActionBar?.hide()

            val btnRegistrar = findViewById<Button>(R.id.btnRegistrarse);

             btnRegistrar.setOnClickListener{

                Registrar();

        }


    }
     fun Registrar (){

         // Obtener una instancia de la base de datos
         var db = DBconnection(this).writableDatabase

         // Obtener referencias a los EditText del layout
         val nombreEditText = findViewById<EditText>(R.id.edtNombre)
         val apellidosEditText = findViewById<EditText>(R.id.edtApellido)
         val nombreUsuarioEditText = findViewById<EditText>(R.id.edtUsuarioReg)
         val correoElectronicoEditText = findViewById<EditText>(R.id.edtCorreoReg)
         val contrasenaEditText = findViewById<EditText>(R.id.edtContra)


             val nombre = nombreEditText.text.toString()
             val apellidos = apellidosEditText.text.toString()
             val nombreUsuario = nombreUsuarioEditText.text.toString()
             val correoElectronico = correoElectronicoEditText.text.toString()
             val contrasena = contrasenaEditText.text.toString()

             // Crear la sentencia SQL INSERT para insertar el nuevo usuario
             val insertSql = "INSERT INTO Usuario (Nombre, Apellidos, NombreUsuario, CorreoElectornico, Contraseña) " +
                     "VALUES ('$nombre', '$apellidos', '$nombreUsuario', '$correoElectronico', '$contrasena')"

             // Ejecutar la sentencia SQL INSERT en la base de datos
             db.execSQL(insertSql)


             // Mostrar un mensaje indicando que el usuario se ha registrado correctamente
             Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show()

             // Limpiar los EditText
             nombreEditText.text.clear()
             apellidosEditText.text.clear()
             nombreUsuarioEditText.text.clear()
             correoElectronicoEditText.text.clear()
             contrasenaEditText.text.clear()

             db.close();

             val i = Intent(this, activity_pregunta_uno::class.java)
             startActivity(i)
         }
     }





