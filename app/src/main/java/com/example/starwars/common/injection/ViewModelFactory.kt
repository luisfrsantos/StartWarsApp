package com.example.starwars.common.injection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.starwars.peoples.repository.PeoplesService
import com.example.starwars.peoples.ui.PeopleViewModel


class ViewModelFactory(private val service: Any) : ViewModelProvider.Factory  {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(PeopleViewModel::class.java)) {
            return PeopleViewModel(service as PeoplesService) as T
        }
        throw  IllegalArgumentException("Unknown ViewModel class")
    }
}