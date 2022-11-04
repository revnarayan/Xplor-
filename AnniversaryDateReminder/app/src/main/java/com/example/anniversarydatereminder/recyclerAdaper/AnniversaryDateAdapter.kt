package com.example.anniversarydatereminder.recyclerAdaper

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.anniversarydatereminder.data.model.Record
import com.example.anniversarydatereminder.data.model.RecordUIModel
import com.example.anniversarydatereminder.databinding.AnniversaryDateListItemBinding


class AnniversaryDateAdapter(private val items: List<RecordUIModel>  ) : RecyclerView.Adapter<AnniversaryDateViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnniversaryDateViewHolder {
        val binding = AnniversaryDateListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return AnniversaryDateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnniversaryDateViewHolder, position: Int) {
        holder.anniversaryDateRecord = items[position]
    }

    override fun getItemCount(): Int = items.size

}


