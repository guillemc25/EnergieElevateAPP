package com.example.energieelevate

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import  com.example.energieelevate.Ejercicio

class DetalleEjercicioActivity : AppCompatActivity() {
    private lateinit var editDuracion: EditText
    private lateinit var editCalorias: EditText
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_detalle_ejercicio)
        val Button = findViewById<Button>(R.id.btnTickOkay)
        editDuracion = findViewById(R.id.editDuracion)
        editCalorias = findViewById(R.id.editCalorias)

        Button.setOnClickListener {

            val intent = Intent(this, pantalla_principal::class.java)
            startActivity(intent)
        }
        editDuracion.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // No se utiliza en este caso
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // No se utiliza en este caso
            }

            override fun afterTextChanged(s: Editable?) {
                val duracionMinutos = s.toString().toIntOrNull()
                if (duracionMinutos != null) {
                    calcularCalorias()
                }
            }
        })


        RecogerNombreSeleccionado()

    }

    private fun RecogerNombreSeleccionado(){

        //Recogemos el nombre
        val txtNombreEjercicio = findViewById<TextView>(R.id.txtNombreEjercicio)
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val nombreEjercicio = sharedPreferences.getString("nombreEjercicio", "")

        Toast.makeText(this,nombreEjercicio, Toast.LENGTH_SHORT).show()
        // Mostrar el nombre del ejercicio en un TextView
        txtNombreEjercicio.text = nombreEjercicio
    }
    private fun calcularCalorias() {


        val duracionMinutos = editDuracion.text.toString().toIntOrNull()

        if (duracionMinutos != null) {
            val sharedPreferences = getSharedPreferences("CaloriasEjercicio", Context.MODE_PRIVATE)
            val ejercicioSeleccionadoCalorias= sharedPreferences.getInt("CaloriasEjercicio", 0)

            if ( ejercicioSeleccionadoCalorias != null) {
                // Realizar el cálculo de las calorías basado en la duración y las calorías por minuto del ejercicio
                val calorias = duracionMinutos *  ejercicioSeleccionadoCalorias

                // Mostrar el resultado en el EditText
                editCalorias.setText(calorias.toString())
            } else {
                // Ejercicio no seleccionado
                editCalorias.setText("")
                Toast.makeText(this, "Seleccione un ejercicio válido", Toast.LENGTH_SHORT).show()
            }
        } else {
            // Duración inválida
            editCalorias.setText("")
            Toast.makeText(this, "Ingrese un valor válido para la duración", Toast.LENGTH_SHORT).show()
        }
    }











}












