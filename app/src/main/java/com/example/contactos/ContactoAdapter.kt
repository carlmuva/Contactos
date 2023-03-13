package com.example.contactos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.contactos.databinding.ItemContactBinding

class ContactoAdapter(private var contactos: MutableList<Contacto>, private var listener: OnClickListener) :
    RecyclerView.Adapter<ContactoAdapter.ViewHolder>() { // Cuando definamos esta clase tenemos que implementar los miebros de RecyclerView.Adapter

    private lateinit var mContext: Context



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {  // aqui inflamos nuestra vista
        mContext = parent.context

        val view = LayoutInflater.from(mContext).inflate(R.layout.item_contact, parent,false) // inflamos la vista que vamos a retornar a nuestro ViewHolder

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contacto = contactos.get(position)

        with(holder){
            setListener(contacto)

            binding.tvName.text= contacto.nombre
        }


    }

    override fun getItemCount(): Int = contactos.size


    fun add(contacto: Contacto) {
        contactos.add(contacto)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemContactBinding.bind(view)

        fun setListener(contacto: Contacto){
            binding.root.setOnClickListener{ listener.onClick(contacto) }
        }

    }
}