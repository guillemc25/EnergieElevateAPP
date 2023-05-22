package com.example.energieelevate

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import org.w3c.dom.Text

class AlimentoAdapter(context: Context, private val alimentoList: List<Alimento>) :
    ArrayAdapter<Alimento>(context, 0, alimentoList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        val holder: ViewHolder

        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_alimento_inflate, parent, false)
            holder = ViewHolder()
            holder.txtNombreAlimento = itemView.findViewById(R.id.txtNombreAlimento)
            holder.txtDescripcion = itemView.findViewById(R.id.txtDescripcion)
            holder.txtCalorias = itemView.findViewById(R.id.txtCalorias)
            holder.txtProteinas = itemView.findViewById(R.id.txtProteinas)
            holder.txtCarboHidratos = itemView.findViewById(R.id.txtCarboHidratos)
            holder.txtGrasas = itemView.findViewById(R.id.txtGrasas)
            itemView.tag = holder
        } else {
            holder = itemView.tag as ViewHolder
        }

        val alimento = alimentoList[position]

        holder.txtNombreAlimento?.text = alimento.nombre
        holder.txtDescripcion?.text = alimento.descripcion
        holder.txtCalorias?.text = alimento.calorias.toString()
        holder.txtProteinas?.text = alimento.proteina.toString()
        holder.txtCarboHidratos?.text = alimento.carbohidratos.toString()
        holder.txtGrasas?.text = alimento.grasas.toString()

        return itemView!!
    }

    private class ViewHolder {
        var txtNombreAlimento: TextView? = null
        var txtDescripcion: TextView? = null
        var txtCalorias: TextView? = null
        var txtProteinas: TextView? = null
        var txtCarboHidratos: TextView? = null
        var txtGrasas: TextView? = null
    }
}

