package com.example.anniversarydatereminder.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anniversarydatereminder.R
import com.example.anniversarydatereminder.data.model.RecordUIModel
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
        setAnniversaryDateAdapter(anniversaryRecordViewModel.getUpdatedAnniversaryRecord())
    }

    private fun setAnniversaryDateAdapter(dateList: List<RecordUIModel>) {
        requireView().findViewById<RecyclerView>(R.id.recycler_view).apply {
            setHasFixedSize(true)
            adapter = AnniversaryDateAdapter(dateList)
            layoutManager = LinearLayoutManager(view?.context)

        }
    }
}