package com.android.tusitio.model.sitio

import com.android.tusitio.model.categoria.Categoria
import com.android.tusitio.model.contacto.Contacto
import com.android.tusitio.model.direccion.Direccion
import java.io.Serializable

class Sitio(): Serializable {
    var id: Int = 0
    lateinit var nombre: String
    lateinit var horarioAbierto: String
    lateinit var horarioCerrado: String
    lateinit var direccion: Direccion
    lateinit var categoria: Categoria
    lateinit var contacto: Contacto
}