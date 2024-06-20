package com.example.annotation_processor

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.annotation_processor.ui.theme.AnnotationProcessorTheme


class MainActivity : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnnotationProcessorTheme {

            }
        }
    }

}