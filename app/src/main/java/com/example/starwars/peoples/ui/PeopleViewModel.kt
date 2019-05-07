package com.example.starwars.peoples.ui

import androidx.lifecycle.ViewModel
import com.example.starwars.peoples.repository.PeoplesService
import javax.inject.Inject


class PeopleViewModel @Inject constructor (private val peoplesService : PeoplesService) : ViewModel(){
    fun getAll() = peoplesService.getAll()
}