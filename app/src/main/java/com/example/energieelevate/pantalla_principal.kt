package com.example.energieelevate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class pantalla_principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_principal)
        supportActionBar?.hide()
    }
}