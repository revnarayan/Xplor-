package com.example.anniversarydatereminder.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anniversarydatereminder.R
import com.example.anniversarydatereminder.data.model.Record
import com.example.anniversarydatereminder.recyclerAdaper.AnniversaryDateAdapter


class AnniversaryDateFragment : Fragment() {
    private val anniversaryRecordViewModel = AnniversaryRecordViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.anniversary_date_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAnniversaryDateAdapter(anniversaryRecordViewModel.getUpdatedAnniversaryRecord(),view)
    }

    private fun setAnniversaryDateAdapter(dateList: List<Record>,view: View) {
        view.findViewById<RecyclerView>(R.id.rvMain).apply {
            setHasFixedSize(true)
            adapter = AnniversaryDateAdapter(dateList)
            layoutManager = LinearLayoutManager(view.context)

        }
    }
}