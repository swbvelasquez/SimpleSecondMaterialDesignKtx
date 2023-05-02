package com.swbvelasquez.simplesecondmaterialdesignktx.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.swbvelasquez.simplesecondmaterialdesignktx.R
import com.swbvelasquez.simplesecondmaterialdesignktx.adapters.viewholders.DataVH
import com.swbvelasquez.simplesecondmaterialdesignktx.utils.Data

class DataAdapter(
    private var dataList : MutableList<Data>,
    private val onClickListener:(Data)->Unit) : RecyclerView.Adapter<DataVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataVH {
        return DataVH(LayoutInflater.from(parent.context).inflate(R.layout.item_data,parent,false))
    }

    override fun onBindViewHolder(holder: DataVH, position: Int) {
        holder.bind(dataList[position],onClickListener)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun add(data:Data){
        if(!dataList.contains(data)){
            dataList.add(data)
            notifyItemInserted(dataList.size-1)
        }
    }
}