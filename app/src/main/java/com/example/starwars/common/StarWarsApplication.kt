package com.example.starwars.common

import android.app.Application
import com.example.starwars.common.injection.DaggerApplicationComponet
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger.addLogAdapter


class StarWarsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponet.create()
        addLogAdapter(AndroidLogAdapter())
    }

}