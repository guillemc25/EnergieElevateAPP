package com.example.energieelevate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class NoticiasAdapter(private val noticias: MutableList<Noticia>) :
    RecyclerView.Adapter<NoticiasAdapter.NoticiaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticiaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_noticias, parent, false)
        return NoticiaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoticiaViewHolder, position: Int) {
        val noticia = noticias[position]
        holder.bind(noticia)
    }

    override fun getItemCount(): Int {
        return noticias.size
    }



    inner class NoticiaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(noticia: Noticia) {
            // Asignar los datos de la noticia a las vistas del elemento
            itemView.findViewById<TextView>(R.id.tituloNoticia).text = noticia.titulo
            itemView.findViewById<TextView>(R.id.descripcionNoticia).text = noticia.descripcion
            itemView.findViewById<TextView>(R.id.fechaNoticia).text = noticia.fecha.toString()
            val imageNoticia = itemView.findViewById<ImageView>(R.id.imageNoticia)
            imageNoticia.setImageResource(noticia.imagen)

        }
    }

}


data class Noticia(
    val titulo: String,
    val descripcion: String,
    val fecha: String,
    val imagen: Int
)

