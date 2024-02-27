package com.harissabil.fmipalist.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dept(
    val name: String,
    val imageUrl: String,
    val description: String
) : Parcelable
