package com.example.starwars.common.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        injectComponents()
        super.onCreate(savedInstanceState)
    }
    abstract fun injectComponents()
}