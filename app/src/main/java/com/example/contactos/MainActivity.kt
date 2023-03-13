package com.example.contactos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.contactos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding:ActivityMainBinding
    private lateinit var mAdapter: ContactoAdapter
    private lateinit var mGridLayout: GridLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val contacto = Contacto(nombre = binding.etName.text.toString().trim())
            mAdapter.add(contacto)
        }

        setupRecyclerView()
    }

    private fun setupRecyclerView() { // Esta funcion la creamos nosotros
        mAdapter = ContactoAdapter(mutableListOf(),this)
        mGridLayout= GridLayoutManager(this,2)

        binding.recyclerView.apply {
            setHasFixedSize(true)//se utiliza para que no cambie de tamaño al especificado en el layout
            layoutManager=mGridLayout //se utiliza para indicarle que va ser de tipo grid
            adapter=mAdapter
        }
    }


    //OnClickListener
    override fun onClick(contacto: Contacto) { // esta funcion la creamos

    }
}