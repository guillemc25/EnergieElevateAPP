package com.example.energieelevate

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class pantalla_cena : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_cena)
        supportActionBar?.hide()

        // Obtén una lista de alimentos
        val listaAlimentos = obtenerListaDeAlimentos()

        // Crea una instancia del adaptador pasando la lista de alimentos
        val alimentoAdapterCena = AlimentoAdapterCena(this, listaAlimentos)

        // Obtén una referencia al ListView en tu diseño de actividad
        val listView: ListView = findViewById(R.id.lstAlimentosCena)

        // Asigna el adaptador al ListView
        listView.adapter = alimentoAdapterCena
    }

    private fun obtenerListaDeAlimentos(): List<Alimento> {
        // Aquí puedes implementar la lógica para obtener la lista de alimentos de tu base de datos u otra fuente de datos
        // Por simplicidad, aquí se muestra una lista estática
        val alimentos = mutableListOf<Alimento>()
        alimentos.add(Alimento("Manzana","1 pieza de fruta(182 g)", "52"))
        alimentos.add(Alimento("Plátano", "1 pieza de fruta(100 g)","100"))
        alimentos.add(Alimento("Pan Blanco","1 rodaja(28 g)", "74"))
        alimentos.add(Alimento("Aceite de Oliva","1 cucharada(13,5 g)", "119"))
        alimentos.add(Alimento("Huevo Frito","1 huevo grande(46 g)","90"))
        alimentos.add(Alimento("Leche Semidesnatada","Hacendado, 1 taza normal(250 ml)","115"))
        alimentos.add(Alimento("Aguacate, crudo","1 ración(135 g)","216"))
        alimentos.add(Alimento("Leche Desnatada","Hacendado, 1 taza normal(250 ml)", "88"))
        alimentos.add(Alimento("Azucar Blanco","1 cucharadita(5g)","19"))
        alimentos.add(Alimento("Clara de huevo,cruda","2 enteros(66g)", "34"))
        alimentos.add(Alimento("Pechuga de pollo,cocinada","Pechuga de pollo,cocinada", "114"))
        alimentos.add(Alimento("Naranja","1 pieza de fruta, grande(184 g)", "86"))
        alimentos.add(Alimento("Aceite de oliva Virgen Extra","Hacendado, 1 cucharada(10 ml)", "82"))
        alimentos.add(Alimento("Huevo Cocido","1 huevo", "78"))
        alimentos.add(Alimento("Pechuga de pavo, en lonchas","1 racion (33 g)", "34"))
        alimentos.add(Alimento("Jamon Serrano","jamon, 1 rodaja(12g)", "16"))
        alimentos.add(Alimento("Sandia","1 rodaja(286 g)", "86"))
        alimentos.add(Alimento("Barra de Pan","Mercadona, 100g", "272"))
        alimentos.add(Alimento("Yogur Natural + Proteinas","Hacendado,100g", "52"))
        alimentos.add(Alimento("Clara de huevo","Mercadona,100g","75"))
        alimentos.add(Alimento("Piña","1 rodaja(90g)","45"))
        alimentos.add(Alimento("Jamon Cocido","Paladini,30g", "31"))
        alimentos.add(Alimento("Pan Molde Integral","Hacendado, 1 racion(29g)", "69"))
        alimentos.add(Alimento("Cerezas","8 piezas de fruta(64g)","40"))
        alimentos.add(Alimento("Cafe con leche","Dolce Gusto, 1 taza(180 ml)", "40"))
        alimentos.add(Alimento("Aceite","Aceite de oliva virgen Extra, 1 cucharada","41"))
        alimentos.add(Alimento("Lomo embuchado","Hacendado,30g", "60"))
        alimentos.add(Alimento("Queso philadelphia light","Philadelphia,2 capas(30g)","66"))
        alimentos.add(Alimento("Uvas","1 pieza de fruta","3"))
        alimentos.add(Alimento("Café Solo","100 ml","2"))
        alimentos.add(Alimento("Leche Entera","Milbona(Lidl),100 ml", "63"))
        alimentos.add(Alimento("Mandarina","1 pieza de fruta(76g)","40"))
        alimentos.add(Alimento("Tomate Natural","Verduras, 1 racion(50g)","9"))
        alimentos.add(Alimento("Pan de centeno","1 rodaja(32 g)","83"))
        alimentos.add(Alimento("Avena suave","Weetabix, 120g","444"))
        alimentos.add(Alimento("Clara de Huevo Cocida","200g", "68"))
        alimentos.add(Alimento("Patatas Fritas", "Casero,100g","199"))

        // Agrega más alimentos según tus necesidades

        return alimentos
    }

}