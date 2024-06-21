package com.example.annotation_processor

import android.util.Log
import javax.inject.Inject


interface MyRepository{
    fun doSomething()
}

class MyRepositoryIml @Inject constructor() : MyRepository{
    override fun doSomething() {
        Log.d("MyRepository", "doSomething: fom ${this::class.simpleName}")
    }

}



