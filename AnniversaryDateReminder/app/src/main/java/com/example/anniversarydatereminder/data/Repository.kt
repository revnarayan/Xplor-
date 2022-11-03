package com.example.anniversarydatereminder.data

import com.example.anniversarydatereminder.data.model.Record


class Repository {
    fun populateData(): List<Record> {
        return listOf(
            Record("1", "2012-11-10"),
            Record("2", "2014-11-08"),
            Record("3", "2013-11-11"),
            Record("4", "2018-11-12"),
            Record("5", "2015-11-05"),
            Record("6", "2015-11-04"),
            Record("7", "2015-11-07"),
            Record("8", "2012-10-10"),
            Record("9", "2014-09-08"),
            Record("10", "2013-08-11"),
            Record("11", "2018-10-12"),
            Record("12", "2015-11-03"),
            Record("13", "2015-10-04"),
            Record("14", "2015-04-07"),
            Record("15", null),
            Record("16", null),
            Record("17", null)
        )

    }
}