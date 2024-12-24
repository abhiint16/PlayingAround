package com.example.sampleproject.ui

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleproject.domain.GetCountUseCase
import com.example.sampleproject.model.CountData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class MainViewModel(private val getCountUseCase: GetCountUseCase) : ViewModel() {

    //    private val _countData: MutableStateFlow<CountData> = MutableStateFlow(CountData())
//    val countData: StateFlow<CountData> = _countData.asStateFlow()
    val countData: StateFlow<CountData> = getCountUseCase.getCount().stateIn(
        scope = viewModelScope,
        initialValue = CountData(), // set initial value here
        started = SharingStarted.WhileSubscribed(5000)
    )

//    suspend fun generateInitialCount() {
//        countData = getCountUseCase.getCount().stateIn(
//            scope = viewModelScope,
//            initialValue = CountData(), // set initial value here
//            started = SharingStarted.WhileSubscribed(5000)
//        )
////        countData = getCountUseCase.getCount().stateIn(viewModelScope).
//    }
}