package com.arifahmadalfian.thesportsdb.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class SportResponse(

	@field:SerializedName("idSport")
	val idSport: String? = null,

	@field:SerializedName("strFormat")
	val strFormat: String? = null,

	@field:SerializedName("strSport")
	val strSport: String? = null,

	@field:SerializedName("strSportThumb")
	val strSportThumb: String? = null,

	@field:SerializedName("strSportThumbGreen")
	val strSportThumbGreen: String? = null,

	@field:SerializedName("strSportDescription")
	val strSportDescription: String? = null
)
