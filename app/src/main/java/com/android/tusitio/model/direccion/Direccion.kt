package com.android.tusitio.model.direccion

import java.io.Serializable

class Direccion(): Serializable {
    var id: Int = 0
    lateinit var direccion: String
    lateinit var ciudad: String

}