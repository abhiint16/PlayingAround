package com.example.sampleproject.domain

import com.example.sampleproject.data.CountRepository
import com.example.sampleproject.model.CountData
import kotlinx.coroutines.flow.Flow

class GetCountUseCase(private val countRepository: CountRepository) {

    fun getCount(): Flow<CountData> {
        return countRepository.getCount()
    }
}