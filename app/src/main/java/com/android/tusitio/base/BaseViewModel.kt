package com.android.tusitio.base

import androidx.lifecycle.ViewModel
import com.android.tusitio.di.component.DaggerViewModelInjector
import com.android.tusitio.di.component.ViewModelInjector
import com.android.tusitio.di.module.NetworkModule
import com.android.tusitio.ui.gallery.GalleryViewModel

abstract class BaseViewModel: ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when(this){
            is GalleryViewModel -> injector.inject(this)
        }
    }
}