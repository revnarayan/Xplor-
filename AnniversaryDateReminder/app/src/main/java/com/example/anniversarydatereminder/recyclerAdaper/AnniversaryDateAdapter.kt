package com.example.anniversarydatereminder.recyclerAdaper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.anniversarydatereminder.R
import com.example.anniversarydatereminder.data.model.Record


class AnniversaryDateAdapter(private val anniversaryDateRecord: List<Record>?) :
    RecyclerView.Adapter<AnniversaryDateAdapter.AnniversaryDateViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnniversaryDateViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.anniversary_date_list_item, parent, false)
        return AnniversaryDateViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnniversaryDateViewHolder, position: Int) {
        anniversaryDateRecord?.run {
            val item = this[position]
            holder.coupleID.text = item.coupleId
            holder.anniversaryDate.text = item.anniversaryDate
        }

    }

    override fun getItemCount(): Int = anniversaryDateRecord?.size ?: 0

    inner class AnniversaryDateViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var coupleID: TextView = view.findViewById<TextView>(R.id.tvId)
        var anniversaryDate: TextView = view.findViewById<TextView>(R.id.tvDate)
    }

}


