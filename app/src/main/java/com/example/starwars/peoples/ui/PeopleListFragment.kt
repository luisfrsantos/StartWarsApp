package com.example.starwars.peoples.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.starwars.R
import com.example.starwars.common.injection.AdapterModule
import com.example.starwars.common.injection.DaggerApplicationComponet
import com.example.starwars.common.ui.BaseFragment
import com.example.starwars.peoples.model.Peoples
import com.example.starwars.peoples.repository.PeoplesService
import rx.functions.Action1
import rx.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton
import com.example.starwars.common.injection.ViewModelFactory as ViewModelFactory1


@Singleton
class PeopleListFragment : BaseFragment() {
    @BindView(R.id.rw_list)
    lateinit var rwList: RecyclerView
    @Inject
    lateinit var listAdapter : PeoplesAdapter
    @Inject
    lateinit var peoplesService: PeoplesService
    private var viewModelFactory: ViewModelFactory1? = null
    private var viewModel: PeopleViewModel? = null
    private val peopleList = ArrayList<Any>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelFactory = ViewModelFactory1(peoplesService)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PeopleViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rwList.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        rwList.adapter = listAdapter
        viewModel!!.getAll()
                .subscribeOn(Schedulers.io())
                .doOnError(onError())
                .subscribe(onSubscribe())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.people_fragment, container, false)
        ButterKnife.bind(this, view)
        return view
    }


    override fun injectComponents() {
        DaggerApplicationComponet.builder()
                .adapterModule(AdapterModule(activity!!.applicationContext , peopleList))
                .build()
                .inject(this)
    }

    private fun onError(): Action1<in Throwable>? = Action1 {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun onSubscribe(): Action1<Peoples>? = Action1 {peoples ->
        peoples?.let {
            peopleList.addAll(it.results!!)
            listAdapter.notifyDataSetChanged()
        }
    }

}