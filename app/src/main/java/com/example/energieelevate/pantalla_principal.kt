package com.example.energieelevate

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.*
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class pantalla_principal : AppCompatActivity() {


    var caloriasTotales=0;
    var nombresConcatenados="";




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_principal)
        supportActionBar?.hide()



        agregarIconoClickeableDesayuno()
        agregarIconoClickeableComida()
        agregarIconoClickeableMerienda()
        agregarIconoClickeableCena()

        val textViewCaloriasCero = findViewById<TextView>(R.id.txtCaloriasTotales)

        textViewCaloriasCero.text= "0"

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navPantalla_principal)

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            // Aquí puedes realizar las acciones correspondientes según el elemento seleccionado
            when (menuItem.itemId) {
                R.id.Rutinas -> {
                    // Acciones para el primer elemento del menú
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.pantallaPrincipal -> {
                    // Acciones para el segundo elemento del menú
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.Ejercicio -> {

                    val intent = Intent(this@pantalla_principal, activity_ejercicios::class.java)
                    startActivity(intent)

                    return@setOnNavigationItemSelectedListener true
                }
                // Agrega más casos según tus elementos del menú
                else -> {
                    // Acciones para otros elementos del menú (si los tienes)
                    return@setOnNavigationItemSelectedListener false
                }
            }
        }



    }

    private fun agregarIconoClickeableDesayuno() {
        val txtDesayuno = findViewById<TextView>(R.id.txtDesayuno)
        val spannableStringBuilder = SpannableStringBuilder("Desayuno                         ")
        val drawable = ContextCompat.getDrawable(this, R.drawable.boton_mas)
        val width = resources.getDimensionPixelSize(R.dimen.icon_width)
        val height = resources.getDimensionPixelSize(R.dimen.icon_height)
        drawable?.setBounds(0, 0, width, height)
        val imageSpan = ImageSpan(drawable!!, ImageSpan.ALIGN_BOTTOM)

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                val intent = Intent(this@pantalla_principal, pantalla_desayuno::class.java)
                startActivity(intent)




            }
        }

        spannableStringBuilder.setSpan(imageSpan, spannableStringBuilder.length - 1,
            spannableStringBuilder.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableStringBuilder.setSpan(clickableSpan, spannableStringBuilder.length - 1,
            spannableStringBuilder.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        txtDesayuno.movementMethod = LinkMovementMethod.getInstance()
        txtDesayuno.text = spannableStringBuilder
    }

    private fun agregarIconoClickeableMerienda() {
        val txtMerienda = findViewById<TextView>(R.id.txtDMerienda)
        val spannableStringBuilder = SpannableStringBuilder("Merienda                          ")
        val drawable = ContextCompat.getDrawable(this, R.drawable.boton_mas)
        val width = resources.getDimensionPixelSize(R.dimen.icon_width)
        val height = resources.getDimensionPixelSize(R.dimen.icon_height)
        drawable?.setBounds(0, 0, width, height)
        val imageSpan = ImageSpan(drawable!!, ImageSpan.ALIGN_BOTTOM)

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                val intent = Intent(this@pantalla_principal, pantalla_merienda::class.java)
                startActivity(intent)
            }
        }

        spannableStringBuilder.setSpan(imageSpan, spannableStringBuilder.length - 1,
            spannableStringBuilder.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableStringBuilder.setSpan(clickableSpan, spannableStringBuilder.length - 1,
            spannableStringBuilder.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        txtMerienda.movementMethod = LinkMovementMethod.getInstance()
        txtMerienda.text = spannableStringBuilder
    }

    private fun agregarIconoClickeableComida() {
        val txtComida = findViewById<TextView>(R.id.txtComida)
        val spannableStringBuilder = SpannableStringBuilder("Comida                             ")
        val drawable = ContextCompat.getDrawable(this, R.drawable.boton_mas)
        val width = resources.getDimensionPixelSize(R.dimen.icon_width)
        val height = resources.getDimensionPixelSize(R.dimen.icon_height)
        drawable?.setBounds(0, 0, width, height)
        val imageSpan = ImageSpan(drawable!!, ImageSpan.ALIGN_BOTTOM)

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                val intent = Intent(this@pantalla_principal, pantalla_alimentacion::class.java)
                startActivity(intent)


            }
        }

        spannableStringBuilder.setSpan(imageSpan, spannableStringBuilder.length - 1,
            spannableStringBuilder.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableStringBuilder.setSpan(clickableSpan, spannableStringBuilder.length - 1,
            spannableStringBuilder.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        txtComida.movementMethod = LinkMovementMethod.getInstance()
        txtComida.text = spannableStringBuilder
    }

    private fun agregarIconoClickeableCena() {
        val txtCena = findViewById<TextView>(R.id.txtCena)
        val spannableStringBuilder = SpannableStringBuilder("Cena                                 ")
        val drawable = ContextCompat.getDrawable(this, R.drawable.boton_mas)
        val width = resources.getDimensionPixelSize(R.dimen.icon_width)
        val height = resources.getDimensionPixelSize(R.dimen.icon_height)
        drawable?.setBounds(0, 0, width, height)
        val imageSpan = ImageSpan(drawable!!, ImageSpan.ALIGN_BOTTOM)

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                val intent = Intent(this@pantalla_principal, pantalla_cena::class.java)
                startActivity(intent)
            }
        }

        spannableStringBuilder.setSpan(imageSpan, spannableStringBuilder.length - 1,
            spannableStringBuilder.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableStringBuilder.setSpan(clickableSpan, spannableStringBuilder.length - 1,
            spannableStringBuilder.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        txtCena.movementMethod = LinkMovementMethod.getInstance()
        txtCena.text = spannableStringBuilder
    }

    private fun RecogerCalorias() {
        val textViewCalorias = findViewById<TextView>(R.id.txtCaloriasTotales)
        val sharedPreferencesDesayuno = getSharedPreferences("CaloriasDesayuno", Context.MODE_PRIVATE)
        val sharedPreferencesComida = getSharedPreferences("CaloriasComida", Context.MODE_PRIVATE)
        val sharedPreferencesMerienda = getSharedPreferences("CaloriasMerienda", Context.MODE_PRIVATE)
        val sharedPreferencesCena = getSharedPreferences("CaloriasCena", Context.MODE_PRIVATE)

        val sumaCaloriasDesayuno = sharedPreferencesDesayuno.getInt("sumaCaloriasDesayuno", 0)
        val sumaCaloriasComida = sharedPreferencesComida.getInt("sumaCaloriasComida", 0)
        val sumaCaloriasMerienda = sharedPreferencesMerienda.getInt("sumaCaloriasMerienda", 0)
        val sumaCaloriasCena = sharedPreferencesCena.getInt("sumaCaloriasCena", 0)

        caloriasTotales = sumaCaloriasDesayuno + sumaCaloriasComida + sumaCaloriasMerienda + sumaCaloriasCena

        textViewCalorias.text = caloriasTotales.toString()
    }

    fun RecogerNombreALimentos(){
        val txtNombreAlimentosDesayuno = findViewById<TextView>(R.id.txtComidasDesayuno)

        val AliementosDesayuno = getSharedPreferences("AlimentosDesayuno", MODE_PRIVATE)
        nombresConcatenados = AliementosDesayuno.getString("nombresConcatenados", "").toString()
        txtNombreAlimentosDesayuno.text = nombresConcatenados

        val txtNombreAlimentosComida = findViewById<TextView>(R.id.txtComidas_comida)

        val AliementosComida = getSharedPreferences("AlimentosComida", MODE_PRIVATE)
        nombresConcatenados = AliementosComida.getString("nombresConcatenados", "").toString()
        txtNombreAlimentosComida.text = nombresConcatenados

        val txtNombreAlimentosMerienda = findViewById<TextView>(R.id.txtComida_merienda)

        val AliementosMerienda = getSharedPreferences("AlimentosMerienda", MODE_PRIVATE)
        nombresConcatenados = AliementosMerienda.getString("nombresConcatenados", "").toString()
        txtNombreAlimentosMerienda.text = nombresConcatenados

        val txtNombreAlimentosCena = findViewById<TextView>(R.id.txtComida_cena)

        val AliementosCena = getSharedPreferences("AlimentosCena", MODE_PRIVATE)
        nombresConcatenados = AliementosCena.getString("nombresConcatenados", "").toString()
        txtNombreAlimentosCena.text = nombresConcatenados


    }

    override fun onResume() {
        super.onResume()
        RecogerCalorias()
        RecogerNombreALimentos()


    }


}














