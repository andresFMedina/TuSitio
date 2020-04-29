package com.android.tusitio.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.tusitio.R
import com.android.tusitio.databinding.ItemDireccionBinding
import com.android.tusitio.model.Direccion

class DireccionesAdapter : RecyclerView.Adapter<DireccionesAdapter.ViewHolder>() {
    private lateinit var direcciones: List<Direccion>

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DireccionesAdapter.ViewHolder {
        val binding: ItemDireccionBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_direccion,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DireccionesAdapter.ViewHolder, position: Int) {
        holder.bind(direcciones[position])
    }

    override fun getItemCount(): Int {
        return if (::direcciones.isInitialized) direcciones.size else 0
    }

    fun updateDirecciones(direcciones: List<Direccion>) {
        this.direcciones = direcciones
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemDireccionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val viewModel = DireccionViewModel()


        fun bind(direccion: Direccion) {
            viewModel.bind(direccion)
            binding.viewModel = viewModel
        }
    }

}

