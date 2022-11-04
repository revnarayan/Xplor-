package com.example.anniversarydatereminder.data.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes


data class RecordUIModel(
    val coupleId: String,
    val anniversaryDate: String?,
    val color: Int = 0
)

val Record.uiModel: RecordUIModel
    get() = RecordUIModel(this.coupleId, this.anniversaryDate)

