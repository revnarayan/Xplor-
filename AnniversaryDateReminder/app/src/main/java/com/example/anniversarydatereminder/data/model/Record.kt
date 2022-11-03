package com.example.anniversarydatereminder.data.model


data class Record (
    val coupleId: String,
    val anniversaryDate: String?,
    val type:AnniversaryType = AnniversaryType.NO_TYPE
    )

enum class AnniversaryType {
    FIVE_YEAR,
    TEN_YEAR,
    NO_TYPE
}
