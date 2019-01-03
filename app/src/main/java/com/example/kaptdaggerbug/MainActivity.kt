package com.example.kaptdaggerbug

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.kaptdaggerbug.di.ApplicationModule
import com.example.kaptdaggerbug.di.DaggerApplicationComponent
import com.example.model.Model
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var model: Model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this.application))
            .build()

        component.inject(this)

        Log.d("MainActivity", model.generateText())
    }
}
