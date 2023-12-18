package com.example.fragmentsej1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), EquipoSeleccionado {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){

            supportFragmentManager.beginTransaction().replace(R.id.fl_fragment_listView_container, ListViewEquipos()).commit()
            supportFragmentManager.beginTransaction().replace(R.id.fl_fragment_textView_container, MostarEquipo()).commit()
        }

    }

    override fun enviarDatos(nombre: String){

        val mostrarEquipoFragment = supportFragmentManager.findFragmentById(R.id.fl_fragment_textView_container) as MostarEquipo
        mostrarEquipoFragment.actualizarVista(nombre)
    }
}