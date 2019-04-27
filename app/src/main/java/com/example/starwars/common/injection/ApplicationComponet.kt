package com.example.starwars.common.injection

import com.example.starwars.MainActivity
import com.example.starwars.common.ui.BaseActivity
import dagger.Component

@Component(modules = [RetrofitModule::class])
interface ApplicationComponet{
    fun inject(mainActivity: MainActivity)
    fun inject(baseActivity: BaseActivity)
}