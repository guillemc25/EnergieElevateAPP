package com.example.energieelevate

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class AlimentoAdapterMerienda(context: Context, private val alimentoList: List<Alimento>) :
    ArrayAdapter<Alimento>(context, 0, alimentoList) {
    var sumaCalorias = 0
    var nombresConcatenados = ""
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        val holder: ViewHolder


        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_alimento_inflate, parent, false)
            holder = ViewHolder()
            holder.txtNombreAlimento = itemView.findViewById(R.id.txtNombreAlimento)
            holder.txtCalorias = itemView.findViewById(R.id.txtCalorias)
            holder.txtCantidadMarca= itemView.findViewById(R.id.txtCantidadMarca)
            holder.actionButton = itemView.findViewById(R.id.btnAñadir)

            itemView.tag = holder
        } else {
            holder = itemView.tag as ViewHolder
        }

        val alimento = alimentoList[position]

        holder.txtNombreAlimento?.text = alimento.nombre
        holder.txtCantidadMarca?.text= alimento.CantidadMarca
        holder.txtCalorias?.text = alimento.calorias



        holder.actionButton?.setOnClickListener {

            val calorias = alimento.calorias
            val nombreAlimentoSeleccionado = alimento.nombre
            sumaCalorias += calorias.toInt()

            // Concatenar el nombre del alimento seleccionado a la variable existente
            nombresConcatenados += if (nombresConcatenados.isNotEmpty()) {
                ", $nombreAlimentoSeleccionado" // Agregar una coma antes del nombre del alimento si ya hay elementos concatenados
            } else {
                nombreAlimentoSeleccionado
            }

            // Guardar la suma de calorías en SharedPreferences
            val sharedPreferences = context.getSharedPreferences("CaloriasMerienda", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putInt("sumaCaloriasMerienda", sumaCalorias)
            editor.apply()

            // Guardar la cadena concatenada en SharedPreferences
            val sharedPreferences2 = context.getSharedPreferences("AlimentosMerienda", Context.MODE_PRIVATE)
            val editor2 = sharedPreferences2.edit()
            editor2.putString("nombresConcatenados", nombresConcatenados)
            editor2.apply()

            Toast.makeText(context, "Articulo añadido ", Toast.LENGTH_SHORT).show()
        }


        return itemView!!
    }

    private class ViewHolder {
        var txtNombreAlimento: TextView? = null
        var txtCalorias: TextView? = null
        var txtCantidadMarca: TextView? = null
        var actionButton: Button? = null


    }
}