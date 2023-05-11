package com.example.energieelevate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class activity_pregunta_uno : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pregunta_uno)
        supportActionBar?.hide()

        val btnRegre1 = findViewById<Button>(R.id.btnRegre1);

        btnRegre1.setOnClickListener{

            val i = Intent(this, MainActivity::class.java)
            startActivity(i)

        }
        val btnSig= findViewById<Button>(R.id.btnSig1);

        btnSig.setOnClickListener{

            val i = Intent(this, activity_pregunta_2::class.java)
            startActivity(i)
        }


    }
}