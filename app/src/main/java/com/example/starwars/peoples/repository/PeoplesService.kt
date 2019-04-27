package com.example.starwars.peoples.repository


import com.example.starwars.peoples.model.Peoples
import retrofit2.http.GET
import rx.Observable


interface PeoplesService {
    @GET("people/")
    fun getAll(): Observable<Peoples>
}