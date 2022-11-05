package com.example.anniversarydatereminder.repository


import com.example.anniversarydatereminder.data.AnniversaryDateRecordRepository
import org.junit.Assert
import org.junit.Test


class AnniversaryDateRepositoryTest {

    private val anniversaryDateRecordRepository = AnniversaryDateRecordRepository()


    @Test
    fun testGetAnniversaryRecords_isNotNull() {
        val anniversaryDatesList = anniversaryDateRecordRepository.populateData()
        Assert.assertNotNull(anniversaryDatesList)
    }
}