package com.example.energieelevate

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class activity_pregunta3 : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pregunta3)
        supportActionBar?.hide()

        val btnRegre3= findViewById<Button>(R.id.btnRegre3);

        btnRegre3.setOnClickListener{

            val i = Intent(this, activity_pregunta_2::class.java)
            startActivity(i)

        }
    }
}