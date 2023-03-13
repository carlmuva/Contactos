package com.example.contactos

data class Contacto(var id: Long = 0,
                    var nombre: String ,
                    var telefono: String = "",
                    var imagenUrl: String = "")
