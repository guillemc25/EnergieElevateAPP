package com.example.energieelevate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val txtReg= findViewById<TextView>(R.id.txtReg);

        txtReg.setOnClickListener {
            // Código para manejar el evento de clic aquí
            val intent = Intent(this, activity_registro::class.java)
            startActivity(intent)
        }

    }

}