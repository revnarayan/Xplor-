package com.example.anniversarydatereminder.recyclerAdaper

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.anniversarydatereminder.data.model.RecordUIModel
import com.example.anniversarydatereminder.databinding.AnniversaryDateListItemBinding


class AnniversaryDateViewHolder(private val binding: AnniversaryDateListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    var anniversaryDateRecord: RecordUIModel? = null
        set(value) {
            field = value
            value?.let {
                binding.anniversaryDateRecordList = it
            }
        }
}