package com.example.fragmentsej1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class MostarEquipo : Fragment() {

    private lateinit var tvMostrarEquipo: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_tv, container, false)
        tvMostrarEquipo = view.findViewById(R.id.tv_verTeams)

        return view
    }

    fun actualizarVista(nombre: String){

        tvMostrarEquipo.text = nombre
    }
}