package com.arifahmadalfian.thesportsdb.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class SportResponse(

	@field:SerializedName("idSport")
	val idSport: String,

	@field:SerializedName("strFormat")
	val strFormat: String,

	@field:SerializedName("strSport")
	val strSport: String,

	@field:SerializedName("strSportThumb")
	val strSportThumb: String,

	@field:SerializedName("strSportThumbGreen")
	val strSportThumbGreen: String,

	@field:SerializedName("strSportDescription")
	val strSportDescription: String,
)
