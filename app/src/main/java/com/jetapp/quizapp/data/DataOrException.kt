package com.jetapp.quizapp.data

//Wrapper class for repository
data class DataOrException<T, Boolean, E : Exception> (
    var data : T? = null,
    var loading : Boolean? = null,
    var e: E? = null,
)
