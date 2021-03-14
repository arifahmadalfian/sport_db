package com.arifahmadalfian.thesportsdb.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "sport")
data class SportEntity(
        @PrimaryKey
        @NotNull
        @ColumnInfo(name = "idSport")
        var idSport: String,

        @ColumnInfo(name = "strSport")
        var strSport: String,

        @ColumnInfo(name = "strSportDescription")
        var strSportDescription: String,

        @ColumnInfo(name = "strFormat")
        var strFormat: String,

        @ColumnInfo(name = "strSportThumb")
        var strSportThumb: String,

        @ColumnInfo(name = "isFavorite")
        var isFavorite: Boolean = false
)