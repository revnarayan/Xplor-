package com.example.anniversarydatereminder.ui

import androidx.lifecycle.ViewModel
import com.example.anniversarydatereminder.R
import com.example.anniversarydatereminder.common.Constants
import com.example.anniversarydatereminder.data.Repository
import com.example.anniversarydatereminder.data.model.Record
import com.example.anniversarydatereminder.data.model.RecordUIModel
import java.text.SimpleDateFormat
import java.util.*


class AnniversaryRecordViewModel() : ViewModel() {
    private val repository = Repository()
    private val upcomingAnniversaries: ArrayList<RecordUIModel> = arrayListOf()
    private fun getAnniversaryEventRecord(record: Record) {
        val format = "yyyy-MM-dd"
        val simpleDateFormat = SimpleDateFormat(format, Locale.getDefault())
        record.anniversaryDate?.let {
            simpleDateFormat.parse(record.anniversaryDate)?.let { date ->
                val currentDay = Calendar.getInstance()
                val anniversaryDateThisYear = Calendar.getInstance().apply {
                    time = date
                    set(Calendar.YEAR, currentDay.get(Calendar.YEAR))
                }
                val anniversaryDateNextYear = Calendar.getInstance().apply {
                    time = date
                    set(Calendar.YEAR, currentDay.get(Calendar.YEAR) + 1)
                }
                val recordAnniversaryDate = Calendar.getInstance().apply {
                    time = date
                }

                val currentYearAnniversary =
                    anniversaryDateThisYear.timeInMillis - currentDay.timeInMillis
                if (currentYearAnniversary >= 0 && currentYearAnniversary < Constants.TWO_WEEKS) {
                    if ((anniversaryDateThisYear.get(Calendar.YEAR) - recordAnniversaryDate.get(
                            Calendar.YEAR
                        )) % 5 == 0
                    ) {
                        if ((anniversaryDateThisYear.get(Calendar.YEAR) - recordAnniversaryDate.get(
                                Calendar.YEAR
                            )) % 10 == 0
                        ) {
                            upcomingAnniversaries.add(
                                RecordUIModel(
                                    record.coupleId,
                                    simpleDateFormat.format(anniversaryDateThisYear.time),
                                    R.color.gold
                                )
                            )
                        } else {
                            upcomingAnniversaries.add(
                                RecordUIModel(
                                    record.coupleId,
                                    simpleDateFormat.format(anniversaryDateThisYear.time),
                                    R.color.silver
                                )
                            )
                        }
                    } else {
                        upcomingAnniversaries.add(
                            RecordUIModel(
                                record.coupleId,
                                simpleDateFormat.format(anniversaryDateThisYear.time),
                                R.color.black
                            )
                        )
                    }
                }
                val futureYearAnniversary =
                    anniversaryDateNextYear.timeInMillis - currentDay.timeInMillis
                if (futureYearAnniversary >= 0 && futureYearAnniversary < Constants.TWO_WEEKS) {
                    upcomingAnniversaries.add(
                        RecordUIModel(
                            record.coupleId,
                            simpleDateFormat.format(anniversaryDateNextYear.time),
                            R.color.black
                        )
                    )
                }
            }
        }
    }

    fun getUpdatedAnniversaryRecord(): ArrayList<RecordUIModel> {
        val dataList = repository.populateData()
        dataList.forEach {
            getAnniversaryEventRecord(it)
        }
        return upcomingAnniversaries
    }

    fun updateBackgroundColor(): Int {
        return R.color.silver
    }

}