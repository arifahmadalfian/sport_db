package com.arifahmadalfian.thesportsdb.core.data.source.remote.response

data class SportResponse(
        var idSport: String,
        var strSport: String,
        var strSportDescription: String,
        var strFormat: String,
        var strSportThumb: String,
        var isFavorite: Boolean = false
)
