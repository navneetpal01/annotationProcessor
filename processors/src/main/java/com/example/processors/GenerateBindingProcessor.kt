package com.example.processors

import com.example.annotations.GenerateBinding
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeName
import dagger.Binds
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.ProcessingEnvironment
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.SourceVersion
import javax.lang.model.element.Modifier
import javax.lang.model.element.Name
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
    override fun process(type: Set<TypeElement>, roundEnv: RoundEnvironment): Boolean {
        //We want all the interface which have our annotation so for that we need rounding environment
        roundEnv
            .getElementsAnnotatedWith(generateBindingAnnotation.java)
            .filterIsInstance<TypeElement>()
            .forEach {typeElement : TypeElement ->                                  // We are getting single type element here which uses our annotation
                generateHiltModuleWithBinding(typeElement)
            }
        return true
    }

    fun generateHiltModuleWithBinding(type : TypeElement){
        val firstInterface = type.interfaces.firstOrNull() ?: type.superclass
        val boundType = TypeName.get(firstInterface) //Bound Type is the interface eg - MyRepository
        val boundTypeName : Name = processingEnv.typeUtils.asElement(firstInterface).simpleName

        //So here in this example we are basically building a clone of our dagger module
        //Generating code using the java poet library
        //Will generate a function with a name boundType
        val methodSpec = MethodSpec.methodBuilder("bind$boundType")
            .addModifiers(Modifier.PUBLIC,Modifier.ABSTRACT)
            .addAnnotation(Binds::class.java)                           //This annotation  is coming from the dagger not Hilt so we need the Dagger Dependency is our module


    }






}
