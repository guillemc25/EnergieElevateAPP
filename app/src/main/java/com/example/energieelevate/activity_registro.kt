package com.example.energieelevate

import android.content.ContentValues
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
         //instanciamos los views al codigo
         val edtNombre= findViewById<EditText>(R.id.edtNombre);
         val edtApellido= findViewById<EditText>(R.id.edtApellido);
         val edtUsuarioReg= findViewById<EditText>(R.id.edtUsuarioReg);
         val edtCorreoReg= findViewById<EditText>(R.id.edtCorreoReg);
         val edtContra= findViewById<EditText>(R.id.edtContra);

         //recogemos el texto de los views
         val nombre = edtNombre.text.toString()
         val apellidos = edtApellido.text.toString()
         val nombreUsuario = edtUsuarioReg.text.toString();
         val correoElectronico= edtCorreoReg.text.toString();
         val contrasena= edtContra.text.toString();

         //instanciamos la clase de la base de datos
         val db = DBConnection();
         //realizamos conexion
         val conn = db.connect()
         if (conn != null) {
             val success = db.InsertarUsuario(nombre, apellidos, nombreUsuario, correoElectronico, contrasena)
             if (success) {
                 Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show()

             } else {
                 Toast.makeText(this, "El usuario no sea podido conectar", Toast.LENGTH_SHORT).show()

             }
             db.disconnect()
         } else {
             // Error al conectarse a la base de datos
         }


     }


}