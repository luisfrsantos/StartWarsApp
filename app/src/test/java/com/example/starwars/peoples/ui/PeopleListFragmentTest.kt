package com.example.starwars.peoples.ui


import androidx.fragment.app.testing.launchFragment
import com.example.starwars.peoples.model.Peoples
import com.example.starwars.peoples.repository.PeoplesService
import com.example.starwars.util.FileUtil
import com.google.gson.Gson
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit
import org.robolectric.RobolectricTestRunner
import rx.Observable
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.example.starwars.common.StarWarsApplication

@RunWith(RobolectricTestRunner::class)
class PeopleListFragmentTest {

    @get:Rule
    var rule = MockitoJUnit.rule()

    @Mock
    lateinit var peoplesService : PeoplesService

    @InjectMocks
    lateinit var mViewModel : PeopleViewModel

    private val gson = Gson()

    private val fileUtil = FileUtil()

    private val app = getApplicationContext<StarWarsApplication>()

    private lateinit var peoplesMock: Peoples

    @Before fun setUp(){
         peoplesMock = gson.fromJson(fileUtil.fileToBufferedReader(app.applicationContext,"Peoples.json") , Peoples::class.java)
    }

    @Test fun peoplesLoaded(){
        // GIVEN
        val scenario  = launchFragment<PeopleListFragment>()
        // WHEN
        Mockito.`when`(peoplesService.getAll())
                .thenReturn(Observable.just(peoplesMock))
        // THEN
        scenario.onFragment {
            it.viewModel.getAll().subscribe {
                Assert.assertEquals(it,peoplesMock)
            }
        }
    }
}