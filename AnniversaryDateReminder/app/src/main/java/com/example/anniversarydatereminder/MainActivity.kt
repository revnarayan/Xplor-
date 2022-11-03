package com.example.anniversarydatereminder

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anniversarydatereminder.recyclerAdaper.AnniversaryDateAdapter
import com.example.anniversarydatereminder.data.model.Record
import com.example.anniversarydatereminder.ui.AnniversaryRecordViewModel
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private val anniversaryRecordViewModel = AnniversaryRecordViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dataList = populateData()
        dataList.forEach {
            a(it)
        }
        setAnniversaryDateAdapter(upcomingAnniversaries)
        Log.d("TAG", upcomingAnniversaries.size.toString())
    }

    private fun setAnniversaryDateAdapter(dateList: List<Record>) {
        findViewById<RecyclerView>(R.id.rvMain).apply {
            setHasFixedSize(true)
            adapter = AnniversaryDateAdapter(dateList)
            layoutManager = LinearLayoutManager(this@MainActivity)

        }
    }

}