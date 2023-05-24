package com.example.energieelevate

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class DetalleEjercicioActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_detalle_ejercicio)

        val txtNombreEjercicio = findViewById<TextView>(R.id.txtNombreEjercicio)
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val nombreEjercicio = sharedPreferences.getString("nombreEjercicio", "")

        Toast.makeText(this,nombreEjercicio, Toast.LENGTH_SHORT).show()
        // Mostrar el nombre del ejercicio en un TextView u otro componente de la interfaz de usuario
        txtNombreEjercicio.text = nombreEjercicio
    }
}