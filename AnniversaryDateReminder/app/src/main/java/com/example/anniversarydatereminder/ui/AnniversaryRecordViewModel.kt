package com.example.anniversarydatereminder.ui

import androidx.annotation.ColorRes
import androidx.lifecycle.ViewModel
import com.example.anniversarydatereminder.data.Repository
import com.example.anniversarydatereminder.data.model.AnniversaryType
import com.example.anniversarydatereminder.data.model.Record
import java.text.SimpleDateFormat
import java.util.*


class AnniversaryRecordViewModel(): ViewModel() {
    private val repository = Repository()
    private val upcomingAnniversaries: ArrayList<Record> = arrayListOf()
    fun getAnniversaryEventRecord(record: Record) {
        val format = "yyyy-MM-dd"
        val simpleDateFormat = SimpleDateFormat(format, Locale.getDefault())
        record.anniversaryDate?.let {
            simpleDateFormat.parse(record.anniversaryDate)?.let { date ->
                val currentDay = Calendar.getInstance()
                val anniversaryDateThisYear = Calendar.getInstance().apply {
                    time= date
                    set(Calendar.YEAR, currentDay.get(Calendar.YEAR))
                }
                val anniversaryDateNextYear = Calendar.getInstance().apply {
                    time = date
                    set(Calendar.YEAR, currentDay.get(Calendar.YEAR) + 1)
                }

                val currentYearAnniversary = anniversaryDateThisYear.timeInMillis - currentDay.timeInMillis
                if (currentYearAnniversary >= 0 && currentYearAnniversary < 14 * 24 * 60 * 60 * 1000) {
                    upcomingAnniversaries.add(
                        Record(
                            record.coupleId,
                            simpleDateFormat.format(anniversaryDateThisYear.time)
                        )
                    )
                }
                val futureYearAnniversary = anniversaryDateNextYear.timeInMillis - currentDay.timeInMillis
                if (futureYearAnniversary >= 0 && futureYearAnniversary < 14 * 24 * 60 * 60 * 1000) {
                    upcomingAnniversaries.add(
                        Record(
                            record.coupleId,
                            simpleDateFormat.format(anniversaryDateNextYear.time)
                        )
                    )
                }
            }
        }
    }


}