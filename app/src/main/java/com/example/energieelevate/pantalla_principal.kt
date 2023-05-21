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
import android.widget.Toast
import androidx.core.content.ContextCompat

class pantalla_principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_principal)
        supportActionBar?.hide()

        // Obtiene la referencia al TextView con el ID en el diseño XML.
        val txtDesayuno = findViewById<TextView>(R.id.txtDesayuno)
        val txtComida = findViewById<TextView>(R.id.txtComida)
        val txtMerienda = findViewById<TextView>(R.id.txtDMerienda)
        val txtCena = findViewById<TextView>(R.id.txtCena)

        agregarIconoClickeable(this,txtDesayuno,"Desayuno                          ")
        agregarIconoClickeable(this,txtComida,"Comida                             ")
        agregarIconoClickeable(this,txtMerienda,"Merienda                          ")
        agregarIconoClickeable(this,txtCena, "Cena                                 ")


    }

    fun agregarIconoClickeable(context: Context, textView: TextView, Texto:String) {
        //Creamos un objeto SpannableStringBuilder y lo inicializamos con el texto proporcionado.
        val spannableStringBuilder = SpannableStringBuilder(Texto)
        //Obtenemos el recurso de imagen boton_mas como un objeto Drawable utilizando el contexto actual.
        val drawable = ContextCompat.getDrawable(this, R.drawable.boton_mas)
        //Obtenemos el ancho deseado del icono desde los recursos (dimen/icon_width).
        val width = resources.getDimensionPixelSize(R.dimen.icon_width)
        //Obtenemos el alto deseado del icono desde los recursos (dimen/icon_height).
        val height = resources.getDimensionPixelSize(R.dimen.icon_height)
        //Establecemos los límites del drawable para controlar el tamaño del icono.
        drawable?.setBounds(0, 0, width, height)
        // Creamos un objeto ImageSpan utilizando el drawable y lo alineamos en la parte inferior del texto.
        val imageSpan = ImageSpan(drawable!!, ImageSpan.ALIGN_BOTTOM)

        // Creamos un objeto ClickableSpan anónimo que define el comportamiento al hacer clic en el icono.
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                val intent = Intent(context, pantalla_alimentacion::class.java)
                startActivity(intent)

            }
        }
        //Establecemos el ImageSpan en la posición del último carácter del texto.
        spannableStringBuilder.setSpan(imageSpan, spannableStringBuilder.length - 1,
            spannableStringBuilder.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        //Establecemos el ClickableSpan en la posición del último carácter del texto.
        spannableStringBuilder.setSpan(clickableSpan, spannableStringBuilder.length - 1,
            spannableStringBuilder.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        //Configuramos el TextView para que sea clickeable.
        textView.movementMethod = LinkMovementMethod.getInstance()
        //asigna el texto formateado con iconos y comportamientos clickeables al TextView.
        textView.text = spannableStringBuilder
    }

}