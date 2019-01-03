package com.example.model

import android.content.Context
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Model @Inject constructor(private val context: Context){

    fun generateText() = "Abc"

    fun broken(flowable: Flowable<Int>) {
        // The flowable as an argument breaks the build if Rx is imported with `implementation` (instead of `api`)
    }

    fun thisIsOK(): Flowable<Int> {
        return Flowable.just(5)
    }

}