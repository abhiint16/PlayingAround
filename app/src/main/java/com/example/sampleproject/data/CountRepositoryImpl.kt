package com.example.sampleproject.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CountRepositoryImpl : CountRepository {
    var count = 0

    override suspend fun getCount(): Int {
        withContext(Dispatchers.IO) {
//            state -> 0
            delay(1000)
            fun1()
            fun2()
//            state -> 1
            count++
        }
    }


}