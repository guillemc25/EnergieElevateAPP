package com.example.energieelevate

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
                "2023-06-01", R.drawable.noticia1)
        val noticia2 = Noticia("Los mejores mini ‘steppers’ para ejercitar piernas y glúteos", "Entre las múltiples máquinas para ejercitarse desde casa que ‘imitan’ a las versiones más profesionales de los gimnasios se encuentran los steppers. También conocidas como máquinas escaladoras, reproducen el movimiento que se lleva a cabo al subir una escalera. De esta manera, se trabaja el tren inferior del cuerpo de forma muy completa, incluidos los tobillos, rodillas, caderas y glúteos. Incluso ayuda a fortalecer los abdominales inferiores y la zona lumbar.\n" +
                "\n" +
                "Los modelos más básicos, destinados a principiantes, son los conocidos como mini steppers, que hemos elegido para esta comparativa. Este tipo de máquinas, muy compactas y fáciles de guardar, favorecen la quema de grasa, aunque sus efectos se notan en mayor o menor medida en función de la resistencia que son capaces de ofrecer. Con la ventaja, además, de que cuidan las articulaciones. Se componen de unos pedales que se mueven en vertical (y no en círculos como los de las bicicletas) situados en una base antideslizante que también cuenta con un pequeño monitor para realizar un seguimiento de los aspectos esenciales del ejercicio (número de pasos, calorías quemadas…). Algunos modelos incluso poseen anillas para conectar cintas con las que ejercitar a la vez los brazos y hombros.",
            "2023-06-02", R.drawable.noticia2)

        val noticia3 = Noticia("Protege tus oídos del frío con estas diademas térmicas para ‘running’ y deportes al aire libre",
            "Los oídos son una de las zonas del cuerpo más sensibles y propensas a infectarse al tener un resfriado o si se ven expuestas a temperaturas muy bajas. Por ello, es importante protegerlos en caso de que vayas a pasar mucho tiempo al aire libre, ya sea si decides optar por hacer una travesía en la montaña, al jugar un partido de fútbol un día de mucho frío o si practicas running.\n" +
                    "\n" +
                    "Y es que no hay excusa, ya que existe una solución práctica y muy económica para proteger los oídos del frío: las diademas térmicas. Se trata de bandas elásticas confeccionadas con forros térmicos y transpirables, que funcionan como cintas de pelo, manteniendo el cabello y el sudor alejado del rostro, y además retienen el calor como unas orejeras. En esta selección puedes encontrar cuatro modelos disponibles en Amazon, con una relación calidad-precio excepcional y de marcas tan reconocidas como Nike o Columbia. ¡Descúbrelas!",
            "2023-06-02", R.drawable.noticias3)




        listaNoticias.add(noticia1)
        listaNoticias.add(noticia2)
        listaNoticias.add(noticia3)

// Pasar la lista de noticias al adaptador
        noticiasAdapter = NoticiasAdapter(listaNoticias)
        recyclerView.adapter = noticiasAdapter



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.noticias_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.boton_volver_noticias -> {
                // Acción a realizar al hacer clic en el botón del ActionBar
                val intent = Intent(this, pantalla_principal::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}