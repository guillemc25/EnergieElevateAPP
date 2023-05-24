package com.example.energieelevate

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class EjercicioAdapter(context: Context, ejercicios: List<Ejercicio>) :
    ArrayAdapter<Ejercicio>(context, 0, ejercicios) {

    private var ejerciciosList: List<Ejercicio> = ejercicios

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        val ejercicio = getItem(position)

        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_ejercicio, parent, false)
        }

        val textNombreEjercicio = itemView?.findViewById<TextView>(R.id.textNombreEjercicio)
        val textDescripcionEjercicio = itemView?.findViewById<TextView>(R.id.textDescripcionEjercicio)

        ejercicio?.let {
            textNombreEjercicio?.text = it.nombre
            textDescripcionEjercicio?.text = it.descripcion
        }

        return itemView!!
    }

    fun actualizarLista(nuevaLista: List<Ejercicio>) {
        ejerciciosList = nuevaLista
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return ejerciciosList.size
    }

    override fun getItem(position: Int): Ejercicio? {
        return ejerciciosList[position]
    }
}

