package com.example.anniversarydatereminder.data

import com.example.anniversarydatereminder.data.model.Record


class AnniversaryDateRecordRepository {
    fun populateData(): List<Record> {
        return listOf(
            Record("1", "2013-01-10"),
            Record("2", "2014-11-08"),
            Record("3", "2013-11-11"),
            Record("4", "2018-11-12"),
            Record("5", "2012-11-05"),
            Record("6", "2015-11-04"),
            Record("7", "2015-11-07"),
            Record("8", "2012-10-10"),
            Record("9", "2014-09-08"),
            Record("10", "2017-11-13"),
            Record("11", "2017-11-14"),
            Record("12", "2015-11-06"),
            Record("13", "2015-10-04"),
            Record("14", "2015-04-07"),
            Record("15", null),
            Record("16", null),
            Record("17", null),
            Record("18", "2013-01-05"),
            Record("19", "2018-01-04"),
            Record("20", "2012-11-10"),
            Record("21", "2012-12-29"),
            Record("22", "2017-12-28"),
            Record("23", "2018-12-30"),
            Record("24", null),
            Record("25", null),
            Record("26", "2013-01-05"),
            Record("27", "2009-02-04"),
            Record("28", "2010-03-05"),
            Record("29", "2020-04-05"),
            Record("30", "2019-09-05"),
            Record("31", "2014-10-05")
        )

    }
}