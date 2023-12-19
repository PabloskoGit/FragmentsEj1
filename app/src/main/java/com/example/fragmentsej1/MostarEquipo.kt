package com.example.fragmentsej1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class MostarEquipo : Fragment() {

    private lateinit var tvMostrarEquipo: TextView
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("nombreEquipo", tvMostrarEquipo.text.toString())
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_tv, container, false)
        tvMostrarEquipo = view.findViewById(R.id.tv_verTeams)

        if (savedInstanceState != null) {
            // Recuperamos el texto guardado y lo asignamos a la variable textoActual.
            tvMostrarEquipo.text = savedInstanceState.getString("nombreEquipo")
            // Actualizamos el TextView en la vista con el texto recuperado.
            view.findViewById<TextView>(R.id.tv_verTeams).text = tvMostrarEquipo.text
        }
        
        return view
    }

    fun actualizarVista(nombre: String){

        tvMostrarEquipo.text = nombre
    }
}