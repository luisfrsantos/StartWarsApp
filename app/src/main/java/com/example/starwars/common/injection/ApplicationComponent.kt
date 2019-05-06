package com.example.starwars.common.injection

import com.example.starwars.MainActivity
import com.example.starwars.common.ui.BaseActivity
import com.example.starwars.peoples.ui.PeopleListFragment
import dagger.Component

@Component(modules = [RetrofitModule::class, AdapterModule::class, ViewModelModule::class])
interface ApplicationComponent{
    fun inject(mainActivity: MainActivity)
    fun inject(baseActivity: BaseActivity)
    fun inject(peopleListFragment: PeopleListFragment)
}