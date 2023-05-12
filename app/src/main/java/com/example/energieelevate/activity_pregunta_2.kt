package com.example.energieelevate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class activity_pregunta_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pregunta2)
        supportActionBar?.hide()

        val btnSig2 = findViewById<Button>(R.id.btnSig2);

        btnSig2.setOnClickListener{

            val i = Intent(this, activity_pregunta3::class.java)
            startActivity(i)


        }

        val btnRegre2 = findViewById<Button>(R.id.btnRegre2);

        btnRegre2.setOnClickListener{

            val i = Intent(this, activity_pregunta_uno::class.java)
            startActivity(i)
        }
    }
}