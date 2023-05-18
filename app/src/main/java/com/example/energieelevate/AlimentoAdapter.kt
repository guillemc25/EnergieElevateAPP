package com.example.energieelevate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlimentoAdapter(private val listaAlimentos: List<Alimento>) : RecyclerView.Adapter<AlimentoAdapter.AlimentoViewHolder>() {

    //Este método se llama cuando se necesita crear una nueva vista para un elemento del RecyclerView.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlimentoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_alimento_inflate, parent, false)
        return AlimentoViewHolder(view)
    }
// Este método se llama cuando se necesita vincular los datos de un objeto Alimento específico con una instancia de AlimentoViewHolder
    override fun onBindViewHolder(holder: AlimentoViewHolder, position: Int) {
        val alimento = listaAlimentos[position]
        holder.bind(alimento)
    }
//Este método devuelve la cantidad total de elementos en la lista de alimentos.
    override fun getItemCount(): Int {
        return listaAlimentos.size
    }
/*Esta clase interna es responsable de mantener las referencias a las vistas individuales de un elemento de lista.
 En el constructor, se obtienen las referencias de las vistas utilizando sus ID de recursos
 */
inner class AlimentoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val txtNombreAlimento: TextView = itemView.findViewById(R.id.txtNombreAlimento)
    private val txtDescripcion: TextView = itemView.findViewById(R.id.txtDescripcion)
    private val txtCalorias: TextView = itemView.findViewById(R.id.txtCalorias)
    private val txtProteinas: TextView = itemView.findViewById(R.id.txtProteinas)
    private val txtCarboHidratos: TextView = itemView.findViewById(R.id.txtCarboHidratos)
    private val txtGrasas: TextView = itemView.findViewById(R.id.txtGrasas)
/*El método se utiliza para establecer los valores de las vistas con los datos del
objeto Alimento correspondiente.
 */
        fun bind(alimento: Alimento) {
        txtNombreAlimento.text = alimento.nombre
        txtDescripcion.text = alimento.descripcion
        txtCalorias.text = alimento.calorias.toString()
        txtProteinas.text = alimento.proteina.toString()
        txtCarboHidratos.text = alimento.carbohidratos.toString()
        txtGrasas.text = alimento.grasas.toString()


        }
    }
}
