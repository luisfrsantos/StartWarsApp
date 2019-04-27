package com.example.starwars

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.starwars.common.injection.DaggerApplicationComponet
import com.example.starwars.common.injection.ViewModelFactory
import com.example.starwars.common.ui.BaseActivity
import com.example.starwars.peoples.model.People
import com.example.starwars.peoples.model.Peoples
import com.example.starwars.peoples.repository.PeoplesService
import com.example.starwars.peoples.ui.PeopleViewModel
import com.orhanobut.logger.Logger
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import rx.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var peoplesService : PeoplesService

    private var viewModelFactory : ViewModelFactory? = null
    private var viewModel: PeopleViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModelFactory = ViewModelFactory(peoplesService)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PeopleViewModel::class.java)
        viewModel!!.getAll()
                .subscribeOn(Schedulers.io())
                .subscribe {
                    Logger.d("Peopples" ,it)
                }
    }

    override fun injectComponents() {
        DaggerApplicationComponet.create().inject(this)
    }
}
