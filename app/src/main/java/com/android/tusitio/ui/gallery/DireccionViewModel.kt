package com.android.tusitio.ui.gallery

import androidx.lifecycle.MutableLiveData
import com.android.tusitio.base.BaseViewModel
import com.android.tusitio.model.Direccion

class DireccionViewModel: BaseViewModel() {
    private val ciudadDireccion = MutableLiveData<String>()
    private val direccionDireccion = MutableLiveData<String>()

    fun bind(direccion: Direccion) {
        ciudadDireccion.value = direccion.ciudad
        this.direccionDireccion.value = direccion.direccion
    }

    fun getCiudadDireccion(): MutableLiveData<String> {
        return ciudadDireccion
    }

    fun getDireccionDireccion(): MutableLiveData<String>{
        return direccionDireccion
    }

}