package com.jetapp.quizapp.component

import android.util.Log
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import com.jetapp.quizapp.screens.QuestionsViewModel

@Composable
fun Questions(viewModel: QuestionsViewModel) {
    val questions = viewModel.data.value.data?.toMutableList()
    if (viewModel.data.value.loading == true) {
        CircularProgressIndicator()
        Log.d("LOAD", "Questions: Loading")
    } else {
        questions?.forEach { questionItem ->
            Log.d("RES", "Questions: ${questionItem.question}")
        }
        Log.d("SIZE", "Questions: ${questions?.size}")
    }
}