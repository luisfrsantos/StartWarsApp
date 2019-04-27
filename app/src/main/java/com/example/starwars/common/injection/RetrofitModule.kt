package com.example.starwars.common.injection

import com.example.starwars.peoples.repository.PeoplesService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
class RetrofitModule {

    @Provides
    fun peoplesService() : PeoplesService  =
            getRetrofit().create(PeoplesService::class.java)


    private fun getRetrofit() = Retrofit.Builder()
            .baseUrl("https://swapi.co/api/")
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}