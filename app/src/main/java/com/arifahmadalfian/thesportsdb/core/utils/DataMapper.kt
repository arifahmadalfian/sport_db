package com.arifahmadalfian.thesportsdb.core.utils

import com.arifahmadalfian.thesportsdb.core.data.source.local.entity.SportEntity
import com.arifahmadalfian.thesportsdb.core.data.source.remote.response.SportResponse
import com.arifahmadalfian.thesportsdb.core.domain.model.Sport

object DataMapper {
    fun mapResponsesToEntities(input: List<SportResponse>): List<SportEntity> {
        val sportList = ArrayList<SportEntity>()
        input.map {
            val sport = SportEntity(
                    idSport = it.idSport,
                    strSport = it.strSport,
                    strSportDescription = it.strSportDescription,
                    strFormat = it.strFormat,
                    strSportThumb = it.strSportThumb,
                    isFavorite = false
            )
            sportList.add(sport)
        }
        return sportList
    }

    fun mapEntitiesToDomain(input: List<SportEntity>): List<Sport> {
        return input.map {
            Sport(
                    idSport = it.idSport,
                    strSport = it.strSport,
                    strSportDescription = it.strSportDescription,
                    strFormat = it.strFormat,
                    strSportThumb = it.strSportThumb,
                    isFavorite = it.isFavorite
            )
        }
    }

    fun mapDomainToEntity(input: Sport) = SportEntity (
            idSport = input.idSport,
            strSport = input.strSport,
            strSportDescription = input.strSportDescription,
            strFormat = input.strFormat,
            strSportThumb = input.strSportThumb,
            isFavorite = input.isFavorite
            )

}