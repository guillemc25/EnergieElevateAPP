package com.example.energieelevate

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()


        val btnIniciarSesion= findViewById<TextView>(R.id.btnIniciarSesion)

        btnIniciarSesion.setOnClickListener {
            IniciarSesion();
            val i = Intent(this, pantalla_principal::class.java)
            startActivity(i)

        }
        val txtReg= findViewById<TextView>(R.id.txtReg);
        //Al hacer click al texto de registrarse iremos al activity registro
        txtReg.setOnClickListener {
            // Código para manejar el evento de clic aquí
            val intent = Intent(this, activity_registro::class.java)
            startActivity(intent)
        }



    }

    fun IniciarSesion (){

        val edtCorreo = findViewById<TextView>(R.id.edtCorreoUsuario);
        val edtContra = findViewById<TextView>(R.id.edtContraseña)

        // Obtener los valores de los EditText
        val usuarioCorreo = edtCorreo.text.toString()
        val contrasena = edtContra.text.toString()

// Obtener una instancia de la base de datos
        val db = DBconnection(this).writableDatabase

// Realizar una consulta para buscar el usuario
        val cursor = db.rawQuery(
            "SELECT * FROM Usuario WHERE (NombreUsuario = ? OR CorreoElectornico = ?) AND Contraseña = ?",
            arrayOf(usuarioCorreo, usuarioCorreo, contrasena)
        )

// Verificar si se encontró un usuario con la información proporcionada
        if (cursor.moveToFirst()) {
            Toast.makeText(this, "Inicio de sesion satisfactorio", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "El usuario no existe", Toast.LENGTH_SHORT).show()

        }

// Cerrar el cursor y la conexión a la base de datos
        cursor.close()
        db.close()
    }

}