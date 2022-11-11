package com.blank.listviewcompose.ui

import androidx.annotation.DrawableRes
import com.blank.listviewcompose.R

data class AndroidVersion(
    @DrawableRes val imageResourceId: Int,
    val name: String,
    val release: String
)

val androidNameList = listOf(

    AndroidVersion(R.drawable.android6, "Marshmallow", "October 5, 2015"),
    AndroidVersion(R.drawable.android7, "Nougat", "August 22, 2016"),
    AndroidVersion(R.drawable.android8, "Oreo", "August 21, 2017"),
    AndroidVersion(R.drawable.android9, "Pie", "August 6, 2018"),
    AndroidVersion(R.drawable.android10, "Android 10", "September 3, 2019"),
    AndroidVersion(R.drawable.android11, "Android 11", "September 8, 2020")
)
