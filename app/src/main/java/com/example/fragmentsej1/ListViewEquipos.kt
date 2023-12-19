package com.example.fragmentsej1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment

class ListViewEquipos : Fragment() {

    private var comunicador: EquipoSeleccionado? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is EquipoSeleccionado) {
            comunicador = context
        } else {
            throw RuntimeException("$context debe implementar EquipoSeleccionado")
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_lv, container, false)
        val listViewEquipos = view.findViewById<ListView>(R.id.lv_equipos)

        val equipos = listOf(
            Equipo("FC Barcelona", R.drawable.barsa),
            Equipo("Real Madrid", R.drawable.real_madrid),
            Equipo("Valencia", R.drawable.valencia),
            Equipo("Athletic Bilbao", R.drawable.athletic),
            Equipo("Atletico Madrid", R.drawable.atletico_madrid)

            // Añade aquí todos tus equipos
        )

        val adapter = EquipoAdapter(requireContext(), equipos)
        listViewEquipos.adapter = adapter

        // Accion del listview al clickar
        listViewEquipos.setOnItemClickListener { parent, view, position, id ->
            val equipo = parent.getItemAtPosition(position) as Equipo

            comunicador?.enviarDatos(equipo.nombre)

        }

        return view
    }

}

data class Equipo(val nombre: String, val imagen: Int)

class EquipoAdapter(context: Context, equipos: List<Equipo>) :
    ArrayAdapter<Equipo>(context, 0, equipos),
    ListAdapter {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val equipo = getItem(position)
        val view =
            convertView ?: LayoutInflater.from(context).inflate(R.layout.equipo_item, parent, false)

        val nombreEquipo = view.findViewById<TextView>(R.id.nombre_equipo)
        val imagenEquipo = view.findViewById<ImageView>(R.id.imagen_equipo)

        nombreEquipo.text = equipo?.nombre
        imagenEquipo.setImageResource(equipo?.imagen ?: 0)

        // Ajusta el tamaño de la imagen para que se adapte al ImageView manteniendo la relación de aspecto
        imagenEquipo.scaleType = ImageView.ScaleType.CENTER_INSIDE
        imagenEquipo.adjustViewBounds = true

        return view
    }
}