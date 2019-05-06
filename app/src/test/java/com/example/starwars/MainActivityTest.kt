package com.example.starwars

import com.example.starwars.peoples.ui.PeopleListFragment
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric.buildActivity
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    @Test fun checkIsFragmentLoaded(){
        // GIVEN
        val activity = buildActivity(MainActivity::class.java).setup()

        // WHEN
        activity.pause().stop()

        // THEN
        assertEquals(activity.get().supportFragmentManager.fragments[0].tag, PeopleListFragment.TAG)
    }

}