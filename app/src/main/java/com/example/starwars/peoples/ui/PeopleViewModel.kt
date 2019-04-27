package com.example.starwars.peoples.ui

import androidx.lifecycle.ViewModel
import com.example.starwars.peoples.repository.PeoplesService


class PeopleViewModel(val peoplesService : PeoplesService) : ViewModel(){
    fun getAll() = peoplesService.getAll()
}