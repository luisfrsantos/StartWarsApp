package com.example.starwars

import android.os.Bundle
import com.example.starwars.common.ui.BaseActivity
import com.example.starwars.peoples.ui.PeopleListFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
                .replace(R.id.content, PeopleListFragment(), PeopleListFragment.TAG)
                .commit()
    }

    override fun injectComponents() {
        //ToDo inject components
    }
}
