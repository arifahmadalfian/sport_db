package com.arifahmadalfian.thesportsdb.core.domain.usecase

import com.arifahmadalfian.thesportsdb.core.data.Resource
import com.arifahmadalfian.thesportsdb.core.data.SportRepository
import com.arifahmadalfian.thesportsdb.core.domain.model.Sport
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import junit.framework.TestCase
import kotlinx.coroutines.flow.Flow
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SportInteractorTest {

    private lateinit var sportInteractor: SportInteractor

    @Mock
    private lateinit var repository: SportRepository

    @Mock
    private lateinit var dummyAllSport: Flow<Resource<List<Sport>>>

    @Mock
    private lateinit var dummyFavoriteSport: Flow<List<Sport>>

    @Before
    fun setUp() {
        sportInteractor = SportInteractor(repository)
        `when`(repository.getAllSport()).thenReturn(dummyAllSport)
        `when`(repository.getFavoriteSport()).thenReturn(dummyFavoriteSport)
    }

    @Test
    fun getAllSport() {
        val result = sportInteractor.getAllSport()
        verify(repository).getAllSport()
        verifyNoMoreInteractions(repository)
        TestCase.assertNotNull(result)
    }

    @Test
    fun getFavoriteSport() {
        val result = sportInteractor.getFavoriteSport()
        verify(repository).getFavoriteSport()
        verifyNoMoreInteractions(repository)
        TestCase.assertNotNull(result)
    }

    @Test
    fun setFavoriteSport() {
        val dummySport = Mockito.mock(Sport::class.java)
        val dummyState = true
        sportInteractor.setFavoriteSport(dummySport, dummyState)
        verify(repository).setFavoriteSport(dummySport, dummyState)
        verifyNoMoreInteractions(repository)
    }
}