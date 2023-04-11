package com.example.energieelevate

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


abstract class activity_registro : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        RegistrarUsuario();

    }
    fun RegistrarUsuario() {
        // inicializamos los views en el código
        val editTextNombre = findViewById<EditText>(R.id.edtNombre);
        val editTextApellido= findViewById<EditText>(R.id.edtApellido);
        val editTextUsuario= findViewById<EditText>(R.id.edtUsuarioReg);
        val EditTextCorreo= findViewById<EditText>(R.id.edtCorreo);
        val EditTextContraseña= findViewById<EditText>(R.id.edtContra);

        // Obtiene los valores ingresados por el usuario
        val nombre: String = editTextNombre.text.toString();
        val apellido: String = editTextApellido.text.toString();
        val usuario: String = editTextUsuario.text.toString();
        val correo: String = EditTextCorreo.getText().toString()
        val contraseña: String = EditTextContraseña.getText().toString()

        // Crea un objeto ContentValues con los valores a insertar
        val valores = ContentValues()
        valores.put("Nombre", nombre)
        valores.put("Apellido", apellido)
        valores.put("Usuario", usuario)
        valores.put("Correo", correo)
        valores.put("Contraseña", contraseña)

        // Inserta los valores en la tabla Usuarios
        val miBaseDeDatos =  BaseDeDatos(this)
        val db: SQLiteDatabase = miBaseDeDatos.getWritableDatabase()
        val newRowId = db.insert("Usuarios", null, valores)

        // Verifica si la inserción fue exitosa
        if (newRowId == -1L) {
            Toast.makeText(this, "Error al registrar usuario", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show()
            // Aquí puedes agregar código para redirigir al usuario a otra actividad o hacer algo más
        }
    }

}