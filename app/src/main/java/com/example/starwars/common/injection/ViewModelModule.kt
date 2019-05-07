package com.example.starwars.common.injection

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.starwars.peoples.repository.PeoplesService
import com.example.starwars.peoples.ui.PeopleViewModel
import dagger.Module
import dagger.Provides


@Suppress("UNCHECKED_CAST")
@Module
class ViewModelModule(private var fragment: Fragment) {

    @Provides
    fun peopleViewModel() : PeopleViewModel   =
        ViewModelProviders.of(fragment,  ViewModelFactory(RetrofitModule().getRetrofit().create(PeoplesService::class.java)))
                            .get(PeopleViewModel::class.java)

}