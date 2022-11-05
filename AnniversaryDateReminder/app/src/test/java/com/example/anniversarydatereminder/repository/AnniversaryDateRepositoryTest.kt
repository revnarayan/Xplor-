package com.example.anniversarydatereminder.repository


import com.example.anniversarydatereminder.data.Repository
import com.example.anniversarydatereminder.data.model.Record
import junit.framework.Assert.assertEquals
import org.junit.Test


class AnniversaryDateRepositoryTest {

    private val repository = Repository()
    private val anniversaryRecords: List<Record> = arrayListOf(Record("1", "2013-01-10"),
        Record("2", "2014-11-08"))

    // TODO:
    @Test
    fun testGetAnniversaryRecords() {
        val result = anniversaryRecords
        val anniversaryDatesList = repository.populateData()
        println("anniversaryDatesList ::$anniversaryDatesList")
        assertEquals(result, anniversaryDatesList)

    }
}