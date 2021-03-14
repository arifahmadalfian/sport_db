package com.arifahmadalfian.thesportsdb.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sport(
        var idSport: String,
        var strSport: String,
        var strSportDescription: String,
        var strFormat: String,
        var strSportThumb: String,
        var isFavorite: Boolean = false
): Parcelable
