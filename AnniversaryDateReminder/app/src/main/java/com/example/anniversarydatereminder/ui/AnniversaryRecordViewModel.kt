package com.example.anniversarydatereminder.ui

import androidx.lifecycle.ViewModel
import com.example.anniversarydatereminder.R
import com.example.anniversarydatereminder.common.Constants
import com.example.anniversarydatereminder.data.AnniversaryDateRecordRepository
import com.example.anniversarydatereminder.data.model.Record
import com.example.anniversarydatereminder.data.model.RecordUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class AnniversaryRecordViewModel @Inject constructor(private val anniversaryDateRecordRepository: AnniversaryDateRecordRepository) : ViewModel() {
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
                getAnniversaryDateList(
                    currentYearAnniversary,
                    anniversaryDateThisYear,
                    recordAnniversaryDate,
                    record,
                    simpleDateFormat
                )

                val futureYearAnniversary =
                    anniversaryDateNextYear.timeInMillis - currentDay.timeInMillis
                getAnniversaryDateList(
                    futureYearAnniversary,
                    anniversaryDateNextYear,
                    recordAnniversaryDate,
                    record,
                    simpleDateFormat
                )
            }
        }
    }

    private fun getAnniversaryDateList(
        anniversaryYear: Long,
        anniversaryDate: Calendar,
        recordAnniversaryDate: Calendar,
        record: Record,
        simpleDateFormat: SimpleDateFormat
    ) {
        if (anniversaryYear >= 0 && anniversaryYear < Constants.TWO_WEEKS) {
            if ((anniversaryDate.get(Calendar.YEAR) - recordAnniversaryDate.get(Calendar.YEAR)) % 5 == 0) {
                if ((anniversaryDate.get(Calendar.YEAR) - recordAnniversaryDate.get(Calendar.YEAR)) % 10 == 0) {
                    upcomingAnniversaries.add(
                        RecordUIModel(
                            record.coupleId,
                            simpleDateFormat.format(anniversaryDate.time),
                            R.color.gold
                        )
                    )
                } else {
                    upcomingAnniversaries.add(
                        RecordUIModel(
                            record.coupleId,
                            simpleDateFormat.format(anniversaryDate.time),
                            R.color.silver
                        )
                    )
                }
            } else {
                upcomingAnniversaries.add(
                    RecordUIModel(
                        record.coupleId,
                        simpleDateFormat.format(anniversaryDate.time),
                        R.color.neutral
                    )
                )
            }

        }
    }

    fun getUpdatedAnniversaryRecord(): ArrayList<RecordUIModel> {
        val dataList = anniversaryDateRecordRepository.populateData()
        dataList.forEach {
            getAnniversaryEventRecord(it)
        }
        return upcomingAnniversaries
    }

}