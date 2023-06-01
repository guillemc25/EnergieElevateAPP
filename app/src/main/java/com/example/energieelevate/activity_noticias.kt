package com.example.energieelevate

import android.annotation.SuppressLint
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class activity_noticias : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var noticiasAdapter: NoticiasAdapter
    private  lateinit var  fechaActual: String

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.noticias)

        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        fechaActual = dateFormat.format(Date())

        val listaNoticias = mutableListOf<Noticia>()

        // Asignar el RecyclerView del layout a la variable
        recyclerView = findViewById(R.id.Recycler_noticias)

        // Configurar el RecyclerView con un LayoutManager
        recyclerView.layoutManager = LinearLayoutManager(this)




        // Crear instancias de noticias y agregarlas a la lista
        val noticia1 = Noticia("Cómo controlar su actividad física de forma inteligente", "En el mundo actual, la falta de actividad física se ha convertido en un problema de salud pública. Sin embargo, la Organización Mundial de la Salud (OMS) tiene un claro mensaje para todos: ¡Muévete! Según las últimas recomendaciones de la OMS, el movimiento constante a lo largo del día es esencial para mantener una vida saludable.\n" +
                "\n" +
                "Las recomendaciones de la OMS abordan aspectos clave como la frecuencia, el volumen y la intensidad adecuados para cada etapa de la vida. Pero lo más importante es que se destaca que todo movimiento cuenta. Ya sea caminar, subir escaleras en lugar de usar el ascensor o realizar desplazamientos activos al colegio o al trabajo, todas estas acciones contribuyen a cumplir con las recomendaciones de actividad física.\n" +
                "\n" +
                "Además, se enfatiza que la actividad física no se limita solo a las sesiones programadas de ejercicio en el gimnasio. Se incluyen todas las actividades que implican un gasto energético superior al metabolismo basal. Ir a la compra caminando, realizar tareas domésticas activas y otras actividades cotidianas también contribuyen a mantenernos en movimiento y mejorar nuestra salud en general.\n" +
                "\n" +
                "La tecnología ha desempeñado un papel fundamental en la promoción de la actividad física. En la actualidad, los dispositivos como las pulseras de actividad y los relojes inteligentes se han vuelto muy populares entre el público no especializado. Estos dispositivos utilizan sensores como podómetros y acelerómetros para medir la actividad física realizada a lo largo del día. Su operatividad, tamaño y precio asequible los convierten en herramientas prácticas y accesibles para el seguimiento personal de la actividad física.",
                fechaActual, R.drawable.noticia1)
         val noticia2 = Noticia("Título 2", "Descripción 2", "2023-05-19", R.drawable.google)
         /*val noticia3 = Noticia("Título 3", "Descripción 3", "2023-05-20", R.drawable.imagen3)

        */



        listaNoticias.add(noticia1)
        listaNoticias.add(noticia2)
        //listaNoticias.add(noticia3)*/

// Pasar la lista de noticias al adaptador
        noticiasAdapter = NoticiasAdapter(listaNoticias)
        recyclerView.adapter = noticiasAdapter



    }

    private fun GuardarNoticiasBD(){


    }
}