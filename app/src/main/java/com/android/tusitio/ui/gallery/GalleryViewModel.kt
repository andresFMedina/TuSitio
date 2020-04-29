package com.android.tusitio.ui.gallery

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.android.tusitio.R
import com.android.tusitio.base.BaseViewModel
import com.android.tusitio.model.Direccion
import com.android.tusitio.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GalleryViewModel : BaseViewModel() {
    @Inject
    lateinit var apiService: ApiService

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    val direccionesAdapter = DireccionesAdapter()


    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadDirecciones() }

    private lateinit var subscription: Disposable

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    init {
        loadDirecciones()
    }

    private fun loadDirecciones() {
        subscription = apiService.getDirecciones()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveDireccionesStart() }
            .subscribe(
                { result ->
                    Log.d("result", result.toString())
                    onRetrieveDireccionesSuccess(result) },
                { error -> onRetrieveDireccionesError()
                Log.e("Error", error.message)}
            )
    }

    private fun onRetrieveDireccionesStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveDireccionesFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveDireccionesSuccess(direcciones: List<Direccion>) {
        direccionesAdapter.updateDirecciones(direcciones)
    }

    private fun onRetrieveDireccionesError() {
        errorMessage.value = R.string.mensaje_de_error
    }
}