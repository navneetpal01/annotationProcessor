package com.example.annotation_processor

import android.util.Log
import com.example.annotations.GenerateBinding
import javax.inject.Inject


interface MyRepository{
    fun doSomething()
}


//So now at the annotation processing time we have the access of both MyRepository and MyRepositoryImpl
@GenerateBinding(
    type = MyRepository::class
)
class MyRepositoryIml @Inject constructor() : MyRepository{
    override fun doSomething() {
        Log.d("MyRepository", "doSomething: fom ${this::class.simpleName}")
    }

}



