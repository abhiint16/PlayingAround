package com.example.sampleproject.data

interface CountRepository {

    suspend fun getCount(): Int
}