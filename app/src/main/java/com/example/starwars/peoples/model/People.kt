package com.example.starwars.peoples.model

import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class People @Inject constructor(){
    var name : String? = null
    var height : String? = null
    var mass : String? = null
    var hair_color : String? = null
    var skin_color : String? = null
    var eye_color : String? = null
    var birth_year : String? = null
    var gender : String? = null
    var homeworld : String? = null
    var films: ArrayList<String>? = null
    var species: ArrayList<String>? = null
    var vehicles: ArrayList<String>? = null
    var starships: ArrayList<String>? = null
    var created: Date? = null
    var edited: Date? = null
    var url: String? = null
}