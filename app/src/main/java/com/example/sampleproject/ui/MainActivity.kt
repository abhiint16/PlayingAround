package com.example.sampleproject.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle

class MainActivity : ComponentActivity() {

    var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            viewModel = hiltViewModel()
            val state = viewModel?.countData?.collectAsStateWithLifecycle()

            ShowCount(count = state?.value?.count)
        }
    }

    @Composable
    fun ShowCount(count: Int, modifier = Modifier()) {
        Text(
            modifier = modifier.fillMaxSize(),
            text = count
        )
    }


}