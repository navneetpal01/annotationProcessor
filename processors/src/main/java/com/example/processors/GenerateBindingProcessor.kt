package com.example.processors

import com.example.annotations.GenerateBinding
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.ProcessingEnvironment
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement



class GenerateBindingProcessor : AbstractProcessor(){

    private val generateBindingAnnotation = GenerateBinding::class


    //These all are methods cause we are modifying a function which is of another instance / object

    //Here inside this method we tell the processor which annotation we are going to process
    override fun getSupportedAnnotationTypes(): MutableSet<String> {

        //But what if the name of our annotation will change then it won't work that's why we create the reference
        //return mutableSetOf("com.example.annotations.GenerateBinding")
        return mutableSetOf(generateBindingAnnotation.qualifiedName!!)
    }

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latestSupported()
    }

    override fun init(processingEnv: ProcessingEnvironment?) {
        //You can initialize some variables if you want to it provides the processing environment
        super.init(processingEnv)
    }

    //Type element is like any type that can represent at the language level like class interface
    //Round Environment is something annotation will run through multiple pats
    override fun process(annotations: Set<TypeElement>?, roundEnv: RoundEnvironment?): Boolean {


        return true
    }
}
