package com.example.energieelevate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*

class activity_pregunta_uno : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pregunta_uno)
        supportActionBar?.hide()

        val btnRegre1 = findViewById<Button>(R.id.btnRegre1);

        //Regresamos al incio de sesion
        btnRegre1.setOnClickListener{

            val i = Intent(this, MainActivity::class.java)
            startActivity(i)

        }
        //Vamos a la siguiente pregunta
        val btnSig= findViewById<Button>(R.id.btnSig1);

        btnSig.setOnClickListener{

            val i = Intent(this, activity_pregunta_2::class.java)
            startActivity(i)
        }

        val spOBjetivo = findViewById<Spinner>(R.id.spObjetivo);


        // Crea un ArrayAdapter con los elementos de la lista
        val items = arrayOf("Selecciona Objetivo","Ganar Peso", "Perder Peso", "Mantenerse en forma")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)

// Asigna el ArrayAdapter al Spinner
        spOBjetivo.adapter = adapter




    }
}