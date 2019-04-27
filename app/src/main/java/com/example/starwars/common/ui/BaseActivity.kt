package com.example.starwars.common.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.starwars.common.injection.DaggerApplicationComponet

abstract class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        injectComponents()
        super.onCreate(savedInstanceState)
        DaggerApplicationComponet.create().inject(this)
    }
    abstract fun injectComponents()
}