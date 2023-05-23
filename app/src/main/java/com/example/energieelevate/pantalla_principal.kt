package com.example.energieelevate

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.*
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class pantalla_principal : AppCompatActivity() {


    var sumaCalorias = 0
    var nombresConcatenados="";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_principal)
        supportActionBar?.hide()



        agregarIconoClickeableDesayuno()
        agregarIconoClickeableComida()
        agregarIconoClickeableMerienda()
        agregarIconoClickeableCena()

        RecogerCalorias()


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
        val sharedPreferences = getSharedPreferences("MiSharedPreferences", Context.MODE_PRIVATE)
        sumaCalorias = sharedPreferences.getInt("sumaCalorias", 0)
        val textViewCalorias = findViewById<TextView>(R.id.txtCaloriasTotales)
        textViewCalorias.text = sumaCalorias.toString()
    }

    override fun onResume() {
        super.onResume()
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


}














