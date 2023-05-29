package com.example.energieelevate

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class activity_ejercicios : AppCompatActivity() {

    private lateinit var listViewEjercicios: ListView
    private lateinit var btnRegresarEjercicio: Button
    private  lateinit var  adapter: EjercicioAdapter
    private  lateinit var  ejercicios : List<Ejercicio>
    private lateinit var ejercicioSeleccionado: Ejercicio
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicios)

        btnRegresarEjercicio = findViewById(R.id.btnRegresarEjercicios)
        btnRegresarEjercicio.setOnClickListener {

            val intent = Intent(this, pantalla_principal::class.java)
            startActivity(intent)
        }

        listViewEjercicios = findViewById(R.id.listViewEjercicios)



        // Crear una lista de ejercicios
        ejercicios = listOf(
            Ejercicio("Flexiones de Pecho", "Realiza flexiones de pecho para fortalecer los músculos pectorales.", "Musculación", 7),
            Ejercicio("Sentadillas", "Realiza sentadillas para fortalecer los músculos de las piernas y glúteos.", "Musculación", 5),
            Ejercicio("Plancha", "Realiza una plancha para fortalecer los músculos del core y abdominales.", "Musculación", 3),
            Ejercicio("Burpees", "Realiza burpees para trabajar todo el cuerpo y mejorar tu resistencia.", "Aeróbicos", 10),
            Ejercicio("Zancadas", "Realiza zancadas para fortalecer las piernas y glúteos.", "Musculación", 6),
            Ejercicio("Fondos de Tríceps", "Realiza fondos de tríceps para fortalecer los músculos de los brazos.", "Musculación", 4),
            Ejercicio("Saltos de Tijera", "Realiza saltos de tijera para trabajar la agilidad y el sistema cardiovascular.", "Aeróbicos", 8),
            Ejercicio("Mountain Climbers", "Realiza mountain climbers para trabajar el core y mejorar la resistencia.", "Aeróbicos", 9),
            Ejercicio("Elevaciones de Piernas", "Realiza elevaciones de piernas para fortalecer los músculos abdominales inferiores.", "Musculación", 5),
            Ejercicio("Flexiones de Brazos en Pared", "Realiza flexiones de brazos en pared para trabajar los músculos pectorales.", "Musculación", 4),
            Ejercicio("Sentadillas con Salto", "Realiza sentadillas con salto para trabajar las piernas y aumentar la potencia.", "Musculación", 7),
            Ejercicio("Plancha Lateral", "Realiza una plancha lateral para fortalecer los músculos oblicuos.", "Musculación", 4),
            Ejercicio("Saltos al Cajón", "Realiza saltos al cajón para trabajar la explosividad y la fuerza de piernas.", "Musculación", 8),
            Ejercicio("Crunch Abdominal", "Realiza crunch abdominales para fortalecer los músculos abdominales.", "Musculación", 3),
            Ejercicio("Flexiones de Brazos en Suelo", "Realiza flexiones de brazos en el suelo para trabajar los músculos pectorales.", "Musculación", 6),
            Ejercicio("Sentadillas Búlgaras", "Realiza sentadillas búlgaras para trabajar las piernas y glúteos.", "Musculación", 5),
            Ejercicio("Plancha con Elevación de Brazo", "Realiza una plancha con elevación de brazo para trabajar el core y los hombros.", "Musculación", 4),
            Ejercicio("Saltos a la Cuerda", "Realiza saltos a la cuerda para mejorar la resistencia cardiovascular.", "Aeróbicos", 12),
            Ejercicio("Bicicleta Abdominal", "Realiza la bicicleta abdominal para trabajar los músculos abdominales y oblicuos.", "Musculación", 5),
            Ejercicio("Flexiones de Brazos en Anillas", "Realiza flexiones de brazos en anillas para trabajar los músculos pectorales y brazos.", "Musculación", 7),
            Ejercicio("Sentadillas Sumo", "Realiza sentadillas sumo para fortalecer los músculos internos y externos de los muslos.", "Musculación", 6),
            Ejercicio("Plancha con Rodillas al Pecho", "Realiza una plancha con rodillas al pecho para trabajar el core y los abdominales.", "Musculación", 5),
            Ejercicio("Salto al Vacío", "Realiza saltos al vacío para trabajar la potencia y la fuerza de piernas.", "Musculación", 9),
            Ejercicio("Escaladores", "Realiza escaladores para trabajar el core, las piernas y mejorar la resistencia.", "Aeróbicos", 10)
        )


        listViewEjercicios.setOnItemClickListener { parent, view, position, id ->

            ejercicioSeleccionado = ejercicios[position]
            //Recogemos Nombre del item seleccionado
            val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("nombreEjercicio", ejercicioSeleccionado.nombre)
            editor.apply()



            val PosicionEjercicio = getSharedPreferences("CaloriasEjercicio", Context.MODE_PRIVATE)
            val editor3 = PosicionEjercicio.edit()
            editor3.putInt("CaloriasEjercicio", ejercicioSeleccionado.caloriasPorMinuto)
            editor3.apply()

            startActivity(Intent(this, DetalleEjercicioActivity::class.java))
        }

        // Crear un adaptador personalizado para la lista de ejercicios
         adapter = EjercicioAdapter(this, ejercicios)

        // Establecer el adaptador en el ListView
        listViewEjercicios.adapter = adapter

    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.filtro_ejercicios, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_aerobic -> {
                // Lógica para filtrar ejercicios aeróbicos
                filtrarPorCategoria("Aeróbicos")
                true
            }
            R.id.action_strength -> {
                // Lógica para filtrar ejercicios de musculación
                filtrarPorCategoria("Musculación")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    fun filtrarPorCategoria(categoria: String) {
        val ejerciciosFiltrados = ejercicios.filter { ejercicio ->
            ejercicio.Categoria == categoria
        }
        // Actualiza el adaptador del ListView con los ejercicios filtrados
        adapter.actualizarLista(ejerciciosFiltrados)
    }



}

data class Ejercicio(val nombre: String, val descripcion: String, val Categoria: String, val caloriasPorMinuto: Int)