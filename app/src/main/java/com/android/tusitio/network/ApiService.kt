package com.android.tusitio.network

import com.android.tusitio.model.Direccion
import com.android.tusitio.utils.Constants
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET(/*Constants.DIRECCIONES*/"posts/")
    fun getDirecciones(): Observable<List<Direccion>>
}