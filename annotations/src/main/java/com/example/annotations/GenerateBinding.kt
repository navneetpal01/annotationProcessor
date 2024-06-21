package com.example.annotations

import kotlin.reflect.KClass



@Target(AnnotationTarget.CLASS) //It can only be applied on a class
@Retention(AnnotationRetention.BINARY)
//There are three types of Retention
//1 - Source - Means that the annotation will stay in the source code of the application
//2 - Binary - Means that the annotation is stored in the binary Output and be visible at the compile time but when the application is running this annotation won't be visible
//3 - Runtime - Means that the annotation is stored in the binary Output and be visible at the compile time and when the application is running this annotation will be visible
annotation class GenerateBinding(
    val type : KClass<*> //Part of Kotlin Reflect instance of the class can be obtained by ::class
)

//Kotlin Reflection API
//The Kotlin reflection API allows you to inspect and manipulate the structure of your program at runtime. This introspection capability provides features like:

//Now we will write the code which reads this annotation and generate the code and give to the application
//It is recommended to make a separate module for the annotation else jvm will process everything at once. creating separate module will make jvm to process it in different instance.
