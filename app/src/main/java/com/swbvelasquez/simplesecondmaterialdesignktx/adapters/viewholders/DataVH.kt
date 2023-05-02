package com.swbvelasquez.simplesecondmaterialdesignktx.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.swbvelasquez.simplesecondmaterialdesignktx.databinding.ItemDataBinding
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Data

class DataVH(view:View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemDataBinding.bind(view)

    fun bind(data:Data,onClickListener:(Data)->Unit){
        binding.apply {
            tvName.text = data.name
            imvPhoto.setImageResource(data.photoRes)
        }

        itemView.setOnClickListener {
            onClickListener(data)
        }
    }
}