package com.android.tusitio.di.component

import com.android.tusitio.di.module.NetworkModule
import com.android.tusitio.ui.gallery.GalleryViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(galleryViewModel: GalleryViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }

}