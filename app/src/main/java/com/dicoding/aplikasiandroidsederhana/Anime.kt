package com.dicoding.aplikasiandroidsederhana

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    val title:String,
    val description:String,
    val image:Int,

    val author:String,
    val genre:String,
    val rating:Double

): Parcelable
