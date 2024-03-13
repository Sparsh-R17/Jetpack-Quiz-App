package com.jetapp.quizapp.component


import android.util.Log
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import com.jetapp.quizapp.model.QuestionItem
import com.jetapp.quizapp.screens.QuestionsViewModel

@Composable
fun Questions(viewModel: QuestionsViewModel) {
    val questions = viewModel.data.value.data?.toMutableList()
    val questionIndex = remember {
        mutableIntStateOf(0)
    }
    if (viewModel.data.value.loading == true) {
        CircularProgressIndicator()
    } else {
        val question = try {
            questions?.get(questionIndex.intValue)
        } catch (ex: Exception) {
            Log.d("CATCH", "Questions: ${ex.localizedMessage}")
        }
        if (questions != null) {
            QuestionDisplay(
                question = question as QuestionItem,
                questionIndex = questionIndex,
                viewModel = viewModel
            ) {
                questionIndex.intValue += 1
            }
        }
    }
}