package com.example.energieelevate

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class pantalla_alimentacion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_alimentacion)
        supportActionBar?.hide()

        val searchView = findViewById<SearchView>(R.id.BuscarAlimentos)
        searchView.setIconifiedByDefault(false)
        searchView.queryHint = "Buscar alimentos..."

        // Obtén una lista de alimentos
        val listaAlimentos = obtenerListaDeAlimentos()

        // Crea una instancia del adaptador pasando la lista de alimentos
        val alimentoAdapter = AlimentoAdapter(this, listaAlimentos)

        // Obtén una referencia al ListView en tu diseño de actividad
        val listView: ListView = findViewById(R.id.lstAlimentos)

        // Asigna el adaptador al ListView
        listView.adapter = alimentoAdapter
    }

    private fun obtenerListaDeAlimentos(): List<Alimento> {
        // Aquí puedes implementar la lógica para obtener la lista de alimentos de tu base de datos u otra fuente de datos
        // Por simplicidad, aquí se muestra una lista estática
        val alimentos = mutableListOf<Alimento>()
        alimentos.add(Alimento("Manzana", "Una fruta deliciosa", 0, 0, 14, 52))
        alimentos.add(Alimento("Plátano", "Una fruta tropical", 0, 1, 22, 96))
        // Agrega más alimentos según tus necesidades

        return alimentos
    }







    }
