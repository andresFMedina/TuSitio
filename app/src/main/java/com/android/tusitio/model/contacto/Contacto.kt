package com.android.tusitio.model.contacto

import java.io.Serializable

class Contacto() : Serializable {
    var id: Int = 0
    lateinit var celular: String
    lateinit var fijo: String
    lateinit var whatsapp: String
}