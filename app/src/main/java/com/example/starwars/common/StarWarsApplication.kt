package com.example.starwars.common

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger.addLogAdapter


class StarWarsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        addLogAdapter(AndroidLogAdapter())
    }

}