package com.example.starwars.common.injection

import android.content.Context
import com.example.starwars.peoples.model.People
import com.example.starwars.peoples.ui.PeoplesAdapter
import dagger.Module
import dagger.Provides


@Suppress("UNCHECKED_CAST")
@Module
class AdapterModule(private var context: Context, private var list: ArrayList<Any>) {

    @Provides
    fun peoplesService() : PeoplesAdapter  = PeoplesAdapter(context , list as ArrayList<People>)

}